object Main extends App {
  def shift[A](n: Int, list: List[A]): List[A] = {
    val s = if (n >= 0) n else list.length - n.abs
    list.slice(s, list.length) ::: list.slice(0, s)
  }

  println(
    shift(
      3,
      List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    )
  ) // List('d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'a', 'b', 'c')

  println(
    shift(
      -2,
      List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    )
  ) // List('j', 'k', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i')
}
