object Main extends App {
  // import P09.pack
  def pack[A](list: List[A]): List[List[A]] = {
    if (list.isEmpty) List(List())
    else {
      val (packed, next) = list span (_ == list.head)
      if (next == Nil) List(packed)
      else packed :: pack(next)
    }
  }

  def encode[A](list: List[A]): List[(Int, A)] = {
    pack(list) map (e => (e.length, e.head))
  }

  println(
    encode(
      List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    )
  ) // List((4,'a'), (1,'b'), (2,'c'), (2,'a'), (1,'d'), (4,'e'))
}
