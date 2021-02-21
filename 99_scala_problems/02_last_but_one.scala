object Main extends App {
  def penultimateBuiltin[A](list: List[A]): A =
    if (list.isEmpty) throw new NoSuchElementException
    else list.init.last

  def penultimateRecursive[A](list: List[A]): A = list match {
    case x :: _ :: Nil  => x
    case _ :: tail => penultimateRecursive(tail)
    case _         => throw new NoSuchElementException
  }

  // println(penultimateBuiltin(List())) // 5
  println(penultimateBuiltin(List(1, 1, 2, 3, 5, 8))) // 5
  println(penultimateRecursive(List(1, 1, 2, 3, 5, 8))) // 5
}
