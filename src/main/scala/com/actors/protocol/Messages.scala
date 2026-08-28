package com.actors.protocol

object Messages {
  sealed trait Command

  case class CreateUser(id: String, name: String, email: String) extends Command
  case class GetUser(id: String) extends Command
  case object ListUsers extends Command
  case class DeleteUser(id: String) extends Command

  case class UserCreated(id: String) extends Command
  case class UserFound(name: String, email: String) extends Command
  case object UserNotFound extends Command
}
