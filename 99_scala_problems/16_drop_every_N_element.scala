object Main extends App {
  def dropEvery[A](n: Int, list: List[A]): List[A] =
    list.zipWithIndex.filter(e => (e._2 + 1) % n != 0).map(_._1)

  def dropEveryRecursively[A](n: Int, list: List[A]): List[A] = {
    def dropR(c: Int, curList: List[A]): List[A] = (c, curList) match {
      case (_, Nil)       => Nil
      case (1, _ :: tail) => dropR(n, tail)
      case (_, h :: tail) => h :: dropR(c - 1, tail)
    }
    dropR(n, list)
  }

  println(
    dropEvery(3, List('a', 'b', 'c', 'd', 'e', 'f', 'j', 'h', 'i', 'j', 'k'))
  ) // List(a, b, d, e, j, h, j, k)
  println(
    dropEveryRecursively(3, List('a', 'b', 'c', 'd', 'e', 'f', 'j', 'h', 'i', 'j', 'k'))
  ) // List(a, b, d, e, j, h, j, k)
}
