package bot

trait UserRepository[F[_]] extends Repository[F, User]