package bot

trait Repository[F[_], Data] {
  def save(data: Data): F[Unit]

  def findByID(id: Int): F[Either[String, Data]]

  def getAll: F[List[(Int, Data)]]
}