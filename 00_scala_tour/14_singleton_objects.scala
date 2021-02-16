import scala.math._

object SingletonObjects {
  def main(args: Array[String]) = {
    // Companion objects:
    case class Circle(radius: Double) {
      import Circle._
      def area: Double = calculateArea(radius)
    }

    object Circle {
      private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)
    }

    val circle1 = Circle(5.0)

    println(circle1.area)

    class Email(val username: String, val domainName: String)

    object Email {
      def fromString(emailString: String): Option[Email] = {
        emailString.split('@') match {
          case Array(a, b) => Some(new Email(a, b))
          case _           => None
        }
      }
    }

    val scalaCenterEmail = Email.fromString("scala.center@epfl.ch")
    scalaCenterEmail match {
      case Some(email) => println(s"""Registered an email
            |Username: ${email.username}
            |Domain name: ${email.domainName}
        """.stripMargin)
      case None        => println("Error: could not parse email")
    }
  }
}
