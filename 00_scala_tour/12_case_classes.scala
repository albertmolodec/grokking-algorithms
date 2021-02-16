object CaseClasses {
  def main(args: Array[String]) = {
    case class Book(isbn: String)

    val frankenstein = Book("978-0486282114")
    println(frankenstein)


    case class Message(sender: String, recipient: String, body: String)
    val message1 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")
    val message2 = Message("guillaume@quebec.ca", "jorge@catalonia.es", "Ça va ?")

    println(message1.sender)  // prints guillaume@quebec.ca
    // message1.sender = "travis@washington.us"  // this line does not compile

    // Instances of case classes are compared by structure and not by reference:
    val messagesAreTheSame = message1 == message2
    println(messagesAreTheSame) // true


    // Shallow copy:
    val message4 = Message("julien@bretagne.fr", "travis@washington.us", "Me zo o komz gant ma amezeg")
    val message5 = message4.copy(sender = message4.recipient, recipient = "claire@bourgogne.fr")
    println(message5) // Message(travis@washington.us,claire@bourgogne.fr,Me zo o komz gant ma amezeg)
  }
}

