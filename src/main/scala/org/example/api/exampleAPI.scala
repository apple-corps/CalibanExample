package org.example.api

import Types._
import caliban.schema.Annotations._

object Types {
  final case class MutationCreateUserArgs(input: CreateUserInput)
      derives caliban.schema.Schema.SemiAuto,
        caliban.schema.ArgBuilder
  final case class MutationUpdateUserArgs(
      userID: Int,
      input: scala.Option[UpdateUserInput]
  ) derives caliban.schema.Schema.SemiAuto,
        caliban.schema.ArgBuilder
  final case class MutationDeleteUserArgs(input: DeleteUserInput)
      derives caliban.schema.Schema.SemiAuto,
        caliban.schema.ArgBuilder
  final case class QueryGetUserArgs(input: GetUserInput)
      derives caliban.schema.Schema.SemiAuto,
        caliban.schema.ArgBuilder
  final case class QueryUpdateUserArgs(input: UpdateUserInput)
      derives caliban.schema.Schema.SemiAuto,
        caliban.schema.ArgBuilder
  final case class User(
      id: Long,
      systemID: Int,
      createdAt: String,
      lastUpdated: String,
      email: String,
      username: String,
      fullName: String,
      profilePictureURLs: List[String],
      bio: String,
      authProviders: scala.Option[List[AuthProvider]],
      accountSettings: scala.Option[AccountSettings],
      extra: scala.Option[String]
  ) derives caliban.schema.Schema.SemiAuto
  final case class Event(
      id: Long,
      systemID: Int,
      createdAt: String,
      lastUpdated: String,
      name: String,
      description: String
  ) derives caliban.schema.Schema.SemiAuto
  final case class AuthProvider(
      provider: String,
      providerUserId: String,
      accessToken: scala.Option[String],
      refreshToken: scala.Option[String],
      expiresAt: scala.Option[String]
  ) derives caliban.schema.Schema.SemiAuto
  final case class AccountSettings(
      webNotifications: Int,
      emailNotifications: Int
  ) derives caliban.schema.Schema.SemiAuto
  final case class CreateUserInput(
      email: String,
      username: String,
      fullName: String,
      profilePictureURLs: List[String],
      bio: String
  ) derives caliban.schema.Schema.SemiAuto,
        caliban.schema.ArgBuilder
  final case class GetUserInput(
      id: scala.Option[Long],
      systemID: scala.Option[Int],
      username: scala.Option[String],
      fullName: scala.Option[String]
  ) derives caliban.schema.Schema.SemiAuto,
        caliban.schema.ArgBuilder
  final case class UpdateUserInput(
      email: scala.Option[String],
      username: scala.Option[String],
      fullName: scala.Option[String],
      profilePictureURLs: scala.Option[List[String]],
      bio: scala.Option[String]
  ) derives caliban.schema.Schema.SemiAuto,
        caliban.schema.ArgBuilder
  final case class DeleteUserInput(
      id: scala.Option[Long],
      systemID: Int,
      password: String
  ) derives caliban.schema.Schema.SemiAuto,
        caliban.schema.ArgBuilder

}

object Operations {

  final case class Query(
      getUser: QueryGetUserArgs => zio.UIO[scala.Option[User]],
      updateUser: QueryUpdateUserArgs => zio.UIO[scala.Option[User]]
  ) derives caliban.schema.Schema.SemiAuto

  final case class Mutation(
      createUser: MutationCreateUserArgs => zio.UIO[scala.Option[User]],
      updateUser: MutationUpdateUserArgs => zio.UIO[scala.Option[User]],
      deleteUser: MutationDeleteUserArgs => zio.UIO[Boolean]
  ) derives caliban.schema.Schema.SemiAuto

}
