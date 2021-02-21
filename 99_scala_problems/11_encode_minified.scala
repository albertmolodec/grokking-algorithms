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

  // import P10.encode
  def encode[A](list: List[A]): List[(Int, A)] = {
    pack(list) map (e => (e.length, e.head))
  }

  def encodeModifiedStrongTyped[A](list: List[A]): List[Either[A, (Int, A)]] = {
    encode(list) map (e => if (e._1 == 1) Left(e._2) else Right(e))
  }

  def encodeModifiedLightTyped[A](list: List[A]): List[Any] = {
    encode(list) map (e => if (e._1 == 1) e._2 else e)
  }

  println(
    encodeModifiedStrongTyped(
      List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    )
  ) // List(Right((4,a)), Left(b), Right((2,c)), Right((2,a)), Left(d), Right((4,e)))

  println(
    encodeModifiedLightTyped(
      List('a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e')
    )
  ) // List((4,a), b, (2,c), (2,a), d, (4,e))
}
