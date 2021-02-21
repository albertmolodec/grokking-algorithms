object Main extends App {
  def compressFunctional[A](list: List[A]): List[A] =
    list.foldRight(List[A]()) { (h, r) =>
      if (r.isEmpty || r.head != h) h :: r
      else r
    }

  def compressRecursive[A](list: List[A]): List[A] = list match {
    case Nil => Nil
    case x :: tail => x :: compressRecursive(tail.dropWhile(_ == x))
  }

  println(
    compressFunctional(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))
  ) // List('a', 'b', 'c', 'a', 'd', 'e')
  println(
    compressRecursive(List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e'))
  ) // List('a', 'b', 'c', 'a', 'd', 'e')
}
