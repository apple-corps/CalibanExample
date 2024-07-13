package org.example.quill
import io.getquill.*
import org.example.api.Types.*
import com.typesafe.config.ConfigFactory
import io.getquill.context.qzio.ImplicitSyntax._
import io.getquill.util.LoadConfig
import io.getquill.autoQuote

import javax.sql.DataSource

object QuillTestApp {
  object Ctx extends PostgresZioJdbcContext(Literal)
  import Ctx._
  lazy val ds = JdbcContextConfig(LoadConfig("link")).dataSource
  given Implicit[DataSource] = Implicit(ds)

  def main(args: Array[String]): Unit = {
    val named = "discord"

    inline def somePeople = quote {
      query[User].filter(u => u.fullName == lift(named))
    }

    val people = run(somePeople)
    // TODO Get SQL
    println(people)
    }
}