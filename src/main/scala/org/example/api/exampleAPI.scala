package org.example.api

import Types._

import caliban.schema.Annotations._

object Types {
  type ID = java.util.UUID
  final case class MutationCreateUserArgs(input: CreateUserInput)
  final case class MutationUpdateUserArgs(
      userID: Int,
      input: scala.Option[UpdateUserInput]
  )
  final case class MutationDeleteUserArgs(input: DeleteUserInput)
  final case class QueryGetUserArgs(input: GetUserInput)
  final case class User(
      id: ID,
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
  ) extends SystemFields
      with UserInfo
      with UserSettings
  final case class AuthProvider(
      provider: String,
      providerUserId: String,
      accessToken: scala.Option[String],
      refreshToken: scala.Option[String],
      expiresAt: scala.Option[String]
  )
  final case class AccountSettings(
      webNotifications: Int,
      emailNotifications: Int
  )
  final case class CreateUserInput(
      userInfo: scala.Option[UserInfo],
      userSettings: scala.Option[UserSettings]
  )
  final case class GetUserInput(
      systemID: scala.Option[Int],
      username: scala.Option[Int],
      fullName: scala.Option[Int]
  )
  final case class UpdateUserInput(
      userInfo: scala.Option[UserInfo],
      userSettings: scala.Option[UserSettings],
      profilePicsToAdd: scala.Option[List[String]]
  )
  final case class DeleteUserInput(systemID: Int, password: String)

  @GQLInterface
  sealed trait SystemFields extends scala.Product with scala.Serializable {
    def id: ID
    def systemID: Int
    def createdAt: String
    def lastUpdated: String
  }

  @GQLInterface
  sealed trait UserInfo extends scala.Product with scala.Serializable {
    def email: String
    def username: String
    def fullName: String
    def profilePictureURLs: List[String]
    def bio: String
  }

  @GQLInterface
  sealed trait UserSettings extends scala.Product with scala.Serializable {
    def authProviders: scala.Option[List[AuthProvider]]
    def accountSettings: scala.Option[AccountSettings]
  }

}

object Operations {

  final case class Query(
      getUser: QueryGetUserArgs => zio.UIO[scala.Option[User]]
  )

  final case class Mutation(
      createUser: MutationCreateUserArgs => zio.UIO[scala.Option[User]],
      updateUser: MutationUpdateUserArgs => zio.UIO[scala.Option[User]],
      deleteUser: MutationDeleteUserArgs => zio.UIO[Boolean]
  )

}
