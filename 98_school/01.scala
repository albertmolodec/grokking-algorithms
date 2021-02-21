object Main extends App {
  def dropFalse(list: List[Boolean]): List[Boolean] = list.dropWhile(_ == false)

  val result1 = dropFalse(dropFalse(List(true, true, false, true, false))) // List(true, true, false, true, false)
  val result2 = dropFalse(dropFalse(List(false, false, false, true, false))) // List(true, false)
  println(result1)
  println(result2)
}
