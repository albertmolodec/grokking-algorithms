// or CURRYING

object Currying {
  def main(args: Array[String]) = {
    val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val res = numbers.foldLeft(0)((m, n) => m + n)
    println(res) // 55

    val res2 = numbers.foldLeft(0)({ (m: Int, n: Int) => m + n })
    println(res2)

    val res3 = numbers.foldLeft(0)(_ + _)
    println(res3)

    val numberFunc = numbers.foldLeft(List[Int]())_ // z = Empty.List[Int]
    val squares = numberFunc((xs, x) => xs :+ x*x)
    println(squares)
    val cubes = numberFunc((xs, x) => xs :+ x*x*x)
    println(cubes)

    println()

    println(numbers.foldLeft(0)((sum, item) => sum + item)) // Общая Форма
    println(numbers.foldRight(0)((sum, item) => sum + item)) // Общая Форма

    println(numbers.foldLeft(0)(_+_)) // Форма с каррированием
    println(numbers.foldRight(0)(_+_)) // Форма с каррированием
  }
}
