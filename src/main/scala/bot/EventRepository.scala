package bot

trait EventRepository[F[_]] extends Repository[F, Event]