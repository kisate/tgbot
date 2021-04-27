package bot

import java.time.ZonedDateTime

case class User(firstname: String, lastname: String, email: String, password: String, id: Int) {
  private val calendar = Calendar(List.empty[Event])
}

case class Event(description: String, start: ZonedDateTime, end: ZonedDateTime, id: Int)

case class Calendar(events: List[Event])