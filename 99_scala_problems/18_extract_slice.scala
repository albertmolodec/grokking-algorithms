object Main extends App {
  def sliceBuiltin[A](start: Int, end: Int, list: List[A]): List[A] =
    list.slice(start, end)

  def sliceRecursive[A](start: Int, end: Int, list: List[A]): List[A] =
    (start, end, list) match {
      case (_, _, Nil)                 => Nil
      case (_, e, _) if e <= 0         => Nil
      case (s, e, h :: tail) if s <= 0 => h :: sliceRecursive(0, e - 1, tail)
      case (s, e, h :: tail)           => sliceRecursive(s - 1, e - 1, tail)
    }

  def sliceFunctional[A](start: Int, end: Int, list: List[A]): List[A] =
    list.drop(start).take(end - (start.abs))

  println(
    sliceBuiltin(
      3,
      7,
      List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    )
  ) // List('d', 'e', 'f', 'g')

  println(
    sliceRecursive(
      3,
      7,
      List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    )
  ) // List('d', 'e', 'f', 'g')

  println(
    sliceFunctional(
      3,
      7,
      List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k')
    )
  ) // List('d', 'e', 'f', 'g')
}
