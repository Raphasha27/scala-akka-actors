package com.actors.user

import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.Behaviors
import com.actors.protocol.Messages

case class User(id: String, name: String, email: String)

object UserActor {
  def apply(): Behavior[Messages.Command] = active(Map.empty)

  private def active(users: Map[String, User]): Behavior[Messages.Command] =
    Behaviors.receive { (context, message) =>
      message match {
        case Messages.CreateUser(id, name, email) =>
          context.log.info(s"Creating user: $name")
          val user = User(id, name, email)
          active(users + (id -> user))

        case Messages.GetUser(id) =>
          users.get(id) match {
            case Some(user) =>
              context.log.info(s"Found user: ${user.name}")
            case None =>
              context.log.info(s"User not found: $id")
          }
          Behaviors.same

        case Messages.ListUsers =>
          context.log.info(s"Total users: ${users.size}")
          users.values.foreach(u => context.log.info(s"  - ${u.name} (${u.email})"))
          Behaviors.same

        case Messages.DeleteUser(id) =>
          context.log.info(s"Deleting user: $id")
          active(users - id)
      }
    }
}
