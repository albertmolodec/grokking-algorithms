object ForComprehensions {
  def main(args: Array[String]) = {
    case class User(name: String, age: Int)

    val userBase = List(
      User("Travis", 28),
      User("Kelly", 33),
      User("Jennifer", 44),
      User("Dennis", 23)
    )

    val twentySomethings =
      for (
        user <- userBase if user.age >= 20 && user.age < 30
      ) // (...) — enumerator is either a generator which introduces new variables, or it is a filter
        yield user.name // i.e. add this to a list
    // 💡 user <- userBase is a List, and because we said yield user.name where user.name is a String, the overall result is a List[String]

    twentySomethings.foreach(println)


    def foo(n: Int, v: Int) =
      for (
        i <- 0 until n;
        j <- 0 until n if i + j == v
      )
        yield (i, j)

    foo(10, 10) foreach { case (i, j) =>
      print(
        s"($i, $j) "
      ) // prints (1, 9) (2, 8) (3, 7) (4, 6) (5, 5) (6, 4) (7, 3) (8, 2) (9, 1)
    }
  }
}
