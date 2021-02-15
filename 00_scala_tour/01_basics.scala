object Main {
  def main(args: Array[String]): Unit = {
    println("Hello, Scala developer!")


    val addOne = (x: Int) => x + 1

    def addTwo(x: Int): Int = x + 2

    println(addOne(10)) // 11
    println(addTwo(10)) // 12


    class Greeter(prefix: String, suffix: String) {
      def greet(name: String): Unit = {
        println(s"$prefix $name $suffix")
      }
    }

    val greeter = new Greeter("Sir", "Jr.")
    greeter.greet("Albert") // Sir Albert Jr.


    case class Point(x: Int, y: Int)
    val point = Point(1, 2)
    val anotherPoint = Point(1, 2)
    val yetAnotherPoint = Point(2, 2)
    if (point == anotherPoint) {
      println(point + " and " + anotherPoint + " are the same.")
    } else {
      println(point + " and " + anotherPoint + " are different.")
    } // Point(1,2) and Point(1,2) are the same.

    if (point == yetAnotherPoint) {
      println(point + " and " + yetAnotherPoint + " are the same.")
    } else {
      println(point + " and " + yetAnotherPoint + " are different.")
    } // Point(1,2) and Point(2,2) are different.


    object IdFactory {
      private var counter = 0

      def create(): Int = {
        counter += 1
        counter
      }
    }
    val id1 = IdFactory.create()
    println(id1) // 1
    val id2 = IdFactory.create()
    println(id2) // 2


    trait TraitGreeter {
      def greet(name: String): Unit = {
        println(s"Hello $name!")
      }
    }
    class DefaultGreeter extends TraitGreeter
    class CustomizableGreeter(prefix: String, postfix: String) extends DefaultGreeter {
      override def greet(name: String): Unit = {
        println(prefix + " " + name + " " + postfix)
      }
    }
    val defaultGreeter = new DefaultGreeter()
    defaultGreeter.greet("Bob")
    val customizableGreeter = new CustomizableGreeter("Awesome", "the Master")
    customizableGreeter.greet("Jack")
  }
}