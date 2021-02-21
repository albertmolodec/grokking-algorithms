object Main extends App {
  def findPattern(list: List[Int]): Boolean = {
    val search = List(1, 2, 3, 2, 1)
    list.containsSlice(search)
  }

  val result1 = findPattern(List(65, 1, 2, 3, 2, 1, 5, 2)) // true
  val result2 = findPattern(List(8, 3, 2, 1)) // false
  val result3 = findPattern(List()) // false

  val result4 = findPattern(List(1, 2, 3, 2, 1)) // true
  val result5 = findPattern(List(1, 2, 3, 2, 1, 0)) // true
  val result6 = findPattern(List(0, 1, 2, 3, 2, 1)) // true

  val result7 = findPattern(List(2, 2, 2, 3, 2, 1)) // false
  val result8 = findPattern(List(0, 1, 2, 3, 2, 2)) // false

  println(result1)
  println(result2)
  println(result3)
  println(result4)
  println(result5)
  println(result6)
  println(result7)
  println(result8)
}
