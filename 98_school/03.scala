object Main extends App {
  def addIndexAndDropEven(list: List[Int]): List[Int] = {
    list.zipWithIndex
      .filter(elem => (elem._2 - 1) % 2 == 0)
      .flatMap(elem => List(elem._2 + elem._1))
  }

  val result1 = addIndexAndDropEven(List(1)) // Nil
  val result2 = addIndexAndDropEven(List(1, 2, 3, 4, 5)) // List(3, 7)
  val result3 = addIndexAndDropEven(List(54, 22, 45, 59)) // List(23, 62)

  println(result1)
  println(result2)
  println(result3)
}
