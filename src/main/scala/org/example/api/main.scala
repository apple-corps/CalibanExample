package org.example.api

import zio._
import caliban._
import caliban.schema.Annotations._
import caliban.RootResolver

import org.example.api._
import org.example.api.Types._ 
import org.example.api.Operations._

object Resolvers {
  var users: Map[Int, User] = Map()

    val queryResolver = Query(
      getUser = args => ZIO.succeed(users.get(args.input.systemID.getOrElse(0)))
    )

    val mutationResolver = Mutation(
      createUser = args /*: MutationCreateUserArgs */ => ZIO.succeed(None),
      updateUser = args => ZIO.succeed(None),
      deleteUser = args => ZIO.succeed(true)
    )
}