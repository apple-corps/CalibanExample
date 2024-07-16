package org.example.quill

import io.getquill.*
import org.example.api.Types.*
import com.typesafe.config.ConfigFactory
import io.getquill.context.qzio.ImplicitSyntax._
import io.getquill.util.LoadConfig
import io.getquill.autoQuote
import zio.{ZIO, ZLayer, ZIOAppDefault}

import javax.sql.DataSource

object QuillTestApp extends ZIOAppDefault {
  object Ctx extends PostgresZioJdbcContext(Literal)
  import Ctx.*

  lazy val ds = JdbcContextConfig(LoadConfig("link")).dataSource
  given Implicit[DataSource] = Implicit(ds)

  override def run = {
    val named = "discord"

    inline def somePeople = quote {
      query[User].filter(u => u.fullName == lift(named))
    }

    val peopleEffect: ZIO[DataSource, Throwable, List[User]] = Ctx.run(somePeople)

    peopleEffect.provide(ZLayer.succeed(ds)) // Provide the DataSource
      .tap { people =>
        ZIO.attempt(println(s"People: $people"))
      }
      .exitCode
  }
}