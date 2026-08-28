package com.actors

import akka.actor.typed.{ActorRef, ActorSystem, Behavior}
import akka.actor.typed.scaladsl.Behaviors
import com.actors.user.UserActor
import com.actors.protocol.Messages

object Main {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem(Behaviors.setup[Nothing] { context =>
      val userActor = context.spawn(UserActor(), "userActor")

      userActor ! Messages.CreateUser("user1", "Alice", "alice@example.com")
      userActor ! Messages.CreateUser("user2", "Bob", "bob@example.com")
      userActor ! Messages.GetUser("user1")
      userActor ! Messages.ListUsers

      Behaviors.empty
    }, "AkkaSystem")

    Thread.sleep(1000)
    system.terminate()
  }
}
