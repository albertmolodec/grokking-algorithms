object Main extends App {
  def length[A](list: List[A]): Int = list.length

  def lengthRecursive[A](list: List[A]): Int = list match {
    case Nil => 0
    case x :: tail => lengthRecursive(tail) + 1
  }

  println(length(List(1, 2, 3, 4, 5, 10))) // 6
  println(lengthRecursive(List(1, 2, 3, 4, 5, 10))) // 6
}
