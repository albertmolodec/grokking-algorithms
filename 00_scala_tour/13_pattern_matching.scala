import scala.util.Random

object PatternMatching {
  def main(args: Array[String]) = {
    val x: Int = Random.nextInt(10) // [0,10]

    val randomValue = x match {
      case 0 => "zero"
      case 1 => "one"
      case 2 => "two"
      case _ => "other" // catch all
    }
    println(x, randomValue)


    abstract class Notification
    case class Email(sender: String, title: String, body: String) extends Notification
    case class SMS(caller: String, message: String) extends Notification
    case class VoiceRecording(contactName: String, link: String) extends Notification

    def showNotification(notification: Notification): String = {
      notification match {
        case VoiceRecording(contactName, link) => s"You received a Voice Recording from $contactName! Click the link to hear it: $link"
        case Email(sender, title, _) => s"You got an email from $sender with title: $title"
        case SMS(caller, message) => s"You got an SMS from $caller! Message: $message"
      }
    }

    val someSms = SMS("12345", "Are you there?")
    val someVoiceRecording = VoiceRecording("Kevin", "https://voicestore.com/123e4567-e89b-12d3-a456-426655440000")

    println(showNotification(someSms))
    println(showNotification(someVoiceRecording))


    // Pattern guards
    def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
      notification match {
        case Email(sender, title, body) if importantPeopleInfo.contains(sender) => s"You got an email from special someone!"
        case SMS(caller, _) if importantPeopleInfo.contains(caller) => "You got an SMS from special someone!"
        case _ => showNotification(notification)
      }
    }

    val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")

    val someCommonSms = SMS("123-4567", "Are you there?")
    val someCommonVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")
    val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
    val importantSms = SMS("867-5309", "I'm here! Where are you?")

    println(showImportantNotification(someCommonSms, importantPeopleInfo)) // You got an SMS from 123-4567! Message: Are you there?
    println(showImportantNotification(someCommonVoiceRecording, importantPeopleInfo)) // You received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123
    println(showImportantNotification(importantEmail, importantPeopleInfo)) // You got an email from special someone!
    println(showImportantNotification(importantSms, importantPeopleInfo)) // You got an SMS from special someone!


    // Matching type only
    abstract class Device
    case class Phone(model: String) extends Device {
      def screenOff = "Turning screen off"
    }
    case class Computer(model: String) extends Device {
      def screenSaverOn = "Turning screen saver on"
    }

    def goIdle(device: Device) = device match {
      case p: Phone => p.screenOff
      case c: Computer => c.screenSaverOn
    }

    println(goIdle(Phone("iPhone XR"))) // Turning screen off
    println(goIdle(Computer("Macbook Pro M1 2020"))) // Turning screen saver on


    // sealed means all subtypes must be declared in the same file
    sealed abstract class Furniture
    case class Couch() extends Furniture
    case class Chair() extends Furniture

    def findPlaceToSit(piece: Furniture): String = piece match {
      case a: Couch => "Lie on the couch"
      case b: Chair => "Sit on the chair"
    }

    println(findPlaceToSit(Couch())) // Lie on the couch
    println(findPlaceToSit(Chair())) // Sit on the chair
  }
}

