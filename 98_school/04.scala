object Main extends App {
  def computeFrequencies(list: List[Boolean]): (Int, Int) = {
    val (f, t) = list.partition(_ == false)
    return (f.length, t.length)
  }

  def recoverList(falseCount: Int, trueCount: Int): List[Boolean] = {
    List.fill(falseCount)(false) ::: List.fill(trueCount)(true)
  }

  def countSort(list: List[Boolean]): List[Boolean] = {
    val frequencies = computeFrequencies(list)
    recoverList(frequencies._1, frequencies._2)
  }

  val result1 = countSort(
    List(false, true, true, false, false, false, true)
  )

  println(result1) // List(false, false, false, false, true, true, true)
}
