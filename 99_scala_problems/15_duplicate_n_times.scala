object Main extends App {
  def duplicateN[A](n: Int, list: List[A]): List[A] = list flatMap { e => List.fill(n)(e) }

  println(
    duplicateN(3, List('a', 'b', 'c', 'c', 'd'))
  ) // List(a, a, a, b, b, b, c, c, c, c, c, c, d, d, d)
}
