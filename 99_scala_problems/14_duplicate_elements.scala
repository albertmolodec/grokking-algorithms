object Main extends App {
  def duplicate[A](list: List[A]): List[A] = list flatMap { e => List(e, e) }

  println(
    duplicate(List('a', 'b', 'c', 'c', 'd'))
  ) // List('a', 'a', 'b', 'b', 'c', 'c', 'c', 'c', 'd', 'd')
}
