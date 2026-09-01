<div align="center">

# 🎭 Scala Akka Actors

![Scala](https://img.shields.io/badge/Scala-3.4-DC322F?style=flat&logo=scala&logoColor=white)
![Akka](https://img.shields.io/badge/Akka-2.9-990000?style=flat)
![License](https://img.shields.io/badge/License-MIT-green?style=flat)
![Status](https://img.shields.io/badge/Build-Passing-brightgreen?style=flat)

*Actor-based concurrency system with Akka*

</div>

---

## ✨ Features

- Actor model concurrency
- Message-driven architecture
- Fault tolerance with supervision
- Cluster management
- Distributed computing
- Event sourcing support
- Persistence layer
- Lightweight actor system

## 🛠️ Tech Stack

![Scala](https://img.shields.io/badge/Scala-3.4-DC322F?style=flat&logo=scala&logoColor=white)
![Akka](https://img.shields.io/badge/Akka-2.9-990000?style=flat)
![SBT](https://img.shields.io/badge/SBT-1.9-DC322F?style=flat)

## 🚀 Quick Start

```bash
# Clone repository
git clone https://github.com/Raphasha27/scala-akka-actors.git
cd scala-akka-actors

# Run application
sbt run

# Run tests
sbt test
```

## 📡 Usage Example

```scala
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors

// Define messages
sealed trait Command
case class Greet(name: String) extends Command

// Define actor behavior
def greetingBehavior(): Behaviors.Receive[Command] =
  Behaviors.receiveMessage {
    case Greet(name) =>
      println(s"Hello, $name!")
      Behaviors.same
  }

// Create actor system
val system = ActorSystem(greetingBehavior(), "Greeter")
system ! Greet("World")
```

## 🏗️ Architecture

```
┌─────────────────────────────────────────┐
│          Actor System                   │
│       (Akka Runtime)                    │
└──────────────────┬──────────────────────┘
                   │
      ┌────────────┼────────────┐
      │            │            │
┌─────▼─────┐ ┌────▼────┐ ┌────▼─────┐
│  Actor A  │ │ Actor B │ │ Actor C  │
│ (Parent)  │ │(Child)  │ │(Child)   │
└─────┬─────┘ └─────────┘ └──────────┘
      │
      │ Messages (Immutable)
      │
┌─────▼─────┐
│  Mailbox  │
│  (Queue)  │
└───────────┘
```

### Supervision Tree

```
User Guardian
    │
    ├── SupervisorActor
    │       ├── WorkerActor-1
    │       ├── WorkerActor-2
    │       └── WorkerActor-3
    │
    └── AnotherActor
```

## 🌐 Live Demo

| Platform | URL |
|----------|-----|
| GitHub Pages | [raphasha27.github.io/scala-akka-actors](https://raphasha27.github.io/scala-akka-actors) |
| Docker Hub | [hub.docker.com/r/raphasha27/scala-akka-actors](https://hub.docker.com/r/raphasha27/scala-akka-actors) |

## 👤 Author

**raphasha27** — [GitHub](https://github.com/raphasha27)
