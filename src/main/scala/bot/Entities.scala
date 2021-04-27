package bot

import java.time.ZonedDateTime

case class User(firstname: String, lastname: String, email: String, password: String, calendar: Calendar)

case class Event(description: String, start: ZonedDateTime, end: ZonedDateTime)

case class Calendar(events: List[Event])