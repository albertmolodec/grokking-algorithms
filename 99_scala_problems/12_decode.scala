object Main extends App {
  def decode[A](list: List[(Int, A)]): List[A] = {
    list flatMap { e => List.fill(e._1)(e._2) }
  }

  println(
    decode(
      List((4, 'a'), (1, 'b'), (2, 'c'), (2, 'a'), (1, 'd'), (4, 'e'))
    )
  ) // List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
}
