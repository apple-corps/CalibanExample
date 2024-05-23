[error] 16 |  final case class User() extends SystemFields with UserInfo with UserSettings
[error]    |                   ^
[error]    |class User needs to be abstract, since:
[error]    |it has 11 unimplemented members.
[error]    |/** As seen from class User, the missing signatures are as follows.
[error]    | *  For convenience, these are usable as stub implementations.
[error]    | */
[error]    |  // Members declared in org.example.api.Types$.SystemFields
[error]    |  def createdAt: String = ???
[error]    |  def id: org.example.api.Types.ID = ???
[error]    |  def lastUpdated: String = ???
[error]    |  def systemID: Int = ???
[error]    |  
[error]    |  // Members declared in org.example.api.Types$.UserInfo
[error]    |  def bio: String = ???
[error]    |  def email: String = ???
[error]    |  def fullName: String = ???
[error]    |  def profilePictureURLs: List[String] = ???
[error]    |  def username: String = ???
[error]    |  
[error]    |  // Members declared in org.example.api.Types$.UserSettings
[error]    |  def accountSettings: Option[org.example.api.Types.AccountSettings] = ???
[error]    |  def authProviders: Option[List[org.example.api.Types.AuthProvider]] = ???
[error] one error found
[error] (Compile / compileIncremental) Compilation failed
[error] Total time: 1 s, completed May 22, 2024, 5:06:24 PM
