object Main extends App {
  def last[A](list: List[A]): A = list.last

  def lastRecursive[A](list: List[A]): A = list match {
    case x :: Nil  => x
    case _ :: tail => lastRecursive(tail)
    case _         => throw new NoSuchElementException
  }

  println(last(List(1, 1, 2, 3, 5, 8))) // 8
  println(lastRecursive(List(1, 1, 2, 3, 5, 8))) // 8
}
