object Main extends App {
  def pack[A](list: List[A]): List[List[A]] = {
    if (list.isEmpty) List(List())
    else {
      val (packed, next) = list span (_ == list.head)
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }

  println(
    pack(
      List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    )
  ) // List(List(a, a, a, a), List(b), List(c, c), List(a, a), List(d), List(e, e, e, e))
}
