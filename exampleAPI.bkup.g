   interface SystemFields {
      # system fields
      id: ID!
      ## change type to BigInt for database mapping !?
      systemID: Int!
      createdAt: String!
      lastUpdated: String!
   }
   
   # fragment vs interface.. ?!
   interface UserInfo {
      email: String!
      username: String!
      fullName: String!
      profilePictureURLs: [String!]!
      bio: String!
   }

   interface UserSettings {
      # preferences: UserPreferences!
      authProviders: [AuthProvider!]
      accountSettings: AccountSettings
   }

   type User implements SystemFields & UserInfo & UserSettings {
      # system fields
      id: ID!
      ## change type to BigInt for database mapping !?
      systemID: Int!
      createdAt: String!
      lastUpdated: String!

      email: String!
      username: String!
      fullName: String!
      profilePictureURLs: [String!]!
      bio: String!

      # preferences: UserPreferences!
      authProviders: [AuthProvider!]
      accountSettings: AccountSettings
 

     # user fields
     
     extra: String
   }

   type Event implements SystemFields {
       id: ID!
       systemID: Int!
       ## change type to BigInt for database mapping !?

       createdAt: String!
       lastUpdated: String!

       name: String!
       description: String!
   }

    type AuthProvider {
      # Consider an enumeration type of Google, Facebook, Apple
      provider: String!
      providerUserId: String!
      accessToken: String
      refreshToken: String
      expiresAt: String
    }

#   type UserPreferences {
#      #interests: [String!]!
#      #contentPreferences: ContentPreferences!
#      # ... other preference fields
#    }

   input CreateUserInput {
       email: String!
       username: String!
       fullName: String!
       profilePictureURLs: [String!]!
       bio: String!
   }

   input GetUserInput {
     id: ID
     systemID: Int
     username: String
     fullName: String
     # location: PhysicalLocation
   }

   input UpdateUserInput {
     email: String
     username: String
     fullName: String
     profilePictureURLs: [String!]
     bio: String
   }

   input DeleteUserInput {
    id: ID
    systemID: Int!
    password: String!
   }

   type AccountSettings {
      webNotifications: Int!
      emailNotifications: Int!
      # ... other account settings fields
    }

  type Mutation {
     #User API
     createUser(input: CreateUserInput!) : User
     updateUser(userID: Int!, input: UpdateUserInput) : User
     deleteUser(input: DeleteUserInput!) : Boolean!
     
     }

type Query {
     getUser(input: GetUserInput!) : User

}
 