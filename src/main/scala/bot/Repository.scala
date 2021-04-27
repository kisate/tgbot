package bot

import java.util.concurrent.ConcurrentHashMap
import scala.collection.concurrent.Map
import scala.jdk.CollectionConverters.ConcurrentMapHasAsScala

trait Repository[F, Data] {
  def save(data: Data, id: Int)

  def findByID(id: Int): Either[String, Data]

  def getAll: List[(Int, Data)]
}


trait ConcurrentHashMapRepository[Data] extends Repository[Map[Int, Data], Data] {
  private val map: Map[Int, Data] = new ConcurrentHashMap[Int, Data] ().asScala

  override def save(data: Data, id: Int): Unit = {
    map.put(id, data)
  }

  override def findByID(id: Int): Either[String, Data] = map.get(id) match {
    case None => Left (s"No data with id $id")
    case Some (x) => Right (x)
  }

  override def getAll: List[(Int, Data)] = {
    map.toList
  }
}