object Main extends App {
  def flatten(list: List[Any]): List[Any] = list flatMap {
    case ms: List[_] => flatten(ms)
    case x           => List(x)
  }

  println(
    flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  ) // List(1, 1, 2, 3, 5, 8)
}
