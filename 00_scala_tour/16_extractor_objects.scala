import scala.util.Random

object ExtractorObjects {
  def main(args: Array[String]) = {
    object CustomerID {
      def apply(name: String) = s"$name--${Random.nextLong}"

      def unapply(customerID: String): Option[String] = {
        val stringArray: Array[String] = customerID.split("--")
        if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
      }
    }

    val customer1ID = CustomerID("Incapsulata")
    println(customer1ID) // incapsulata--2494186533696907709
    customer1ID match {
      case CustomerID(name) => println(name) // incapsulata
      case _ => println("Couldn't extract a CustomerID")
    }

    val customer2ID = CustomerID("Nico")
    val CustomerID(name) = customer2ID // or ___const { name } = customer2Id___ in JS
    println(name)  // Nico

    val CustomerID(name2) = "Jack--asdfasdfasdf"
    println(name2) // Jack

    // val CustomerID(name3) = "-asdfasdfasdf" // MatchError
  }
}
