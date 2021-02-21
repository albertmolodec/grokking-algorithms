object Main extends App {
  def split[A](n: Int, list: List[A]): (List[A], List[A]) = list.splitAt(n)

  def splitRecursive[A](n: Int, list: List[A]): (List[A], List[A]) = (n, list) match {
    case (_, Nil) => (Nil, Nil)
    case (0, ls) => (Nil, ls)
    case (n, h :: tail) => {
      val (pre, post) = splitRecursive(n - 1, tail)
      (h :: pre, post)
    }
  }

  println(
    split(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
  ) //(List(a, b, c),List(d, e, f, g, h, i, j, k))
  println(
    splitRecursive(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
  ) //(List(a, b, c),List(d, e, f, g, h, i, j, k))
}
