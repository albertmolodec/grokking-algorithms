object Main extends App {
  def reverse[A](list: List[A]): List[A] = list.reverse

  def reverseRecursive[A](list: List[A]): List[A] = list match {
    case Nil       => Nil
    case x :: tail => reverseRecursive(tail) ::: List(x)
  }

  println(reverse(List(1, 1, 2, 3, 5, 8)))          // List(8, 5, 3, 2, 1, 1)
  println(reverseRecursive(List(1, 1, 2, 3, 5, 8))) // List(8, 5, 3, 2, 1, 1)
}
