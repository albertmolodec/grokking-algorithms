object Main extends App {
  def stupidRemoveAt[A](k: Int, list: List[A]): (List[A], A) = {
    // import 03
    def nth[A](k: Int, list: List[A]): A = {
      if (k >= 0) list(k)
      else throw new NoSuchElementException
    }
    return (
      list.zipWithIndex.filter(e => (e._2) != k).map(_._1),
      nth(k, list)
    )
  }

  def removeAt[A](n: Int, list: List[A]): (List[A], A) = list.splitAt(n) match {
    case (Nil, _) if n < 0 => throw new NoSuchElementException
    case (pre, e :: post) =>
      println(s"\n${list.splitAt(n)}\n$pre\n$e\n$post\n")
      (pre ::: post, e)
    case (_, Nil) => throw new NoSuchElementException
  }

  println(
    stupidRemoveAt(1, List('a', 'b', 'c', 'd'))
  ) // List('a', 'c', 'd'),'b'

  println(
    removeAt(1, List('a', 'b', 'c', 'd'))
  ) // List('a', 'c', 'd'),'b'
}
