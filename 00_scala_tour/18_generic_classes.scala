object GenericClasses {
  def main(args: Array[String]) = {
    class Stack[A] {
      private var elements: List[A] = Nil
      def push(x: A): Unit =
        elements = x :: elements
      def peek: A = elements.head
      def pop(): A = {
        var currentTop = peek
        elements = elements.tail
        currentTop
      }
    }

    val strings = new Stack[String]
    strings.push("Albert")
    strings.push("Alice")
    println(strings.peek)

    val numbers = new Stack[Number]
    numbers.push(1)
    numbers.push(2)
    println(numbers.pop())
    println(numbers.pop())

    class Fruit
    class Banana extends Fruit
    class Apple extends Fruit

    val fruits = new Stack[Fruit]
    val apple = new Apple
    val banana = new Banana

    fruits.push(apple)
    fruits.push(banana)
    println(fruits.pop())
    println(fruits.pop())
  }
}
