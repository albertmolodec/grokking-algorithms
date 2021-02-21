
object Main extends App {
  def nth[A](k: Int, list: List[A]): A = {
    if (k >= 0) list(k)
    else throw new NoSuchElementException
  }

  def nthRecursive[A](k: Int, list: List[A]): A = (k, list) match {
    case (0, x :: _)    => x
    case (k, _ :: tail) => nthRecursive(k - 1, tail)
    case (_, Nil)       => throw new NoSuchElementException
  }

  println(nth(2, List(1, 1, 2, 3, 5, 8))) // 2
  println(nthRecursive(2, List(1, 1, 2, 3, 5, 8))) // 2

  // println(nth(-5, List(1, 1, 2, 3, 5, 8))) // 2
  // println(nthRecursive(-5, List(1, 1, 2, 3, 5, 8))) // 2
}
