import scala.annotation.tailrec

def replace(
    list: List[String],
    replacing: String,
    replacement: String
): List[String] = {
  list.map {
    case x if x == replacing => replacement
    case other               => other
  }
}

def recursiveReplace(
    list: List[String],
    replacing: String,
    replacement: String
): List[String] = {

  @tailrec
  def recursiveReplace(
      list: List[String],
      replacing: String,
      replacement: String,
      reversedAccumulator: List[String]
  ): List[String] = {
    println(s"$list => $reversedAccumulator")
    list match {
      case x :: tail if x == replacing =>
        recursiveReplace(
          tail,
          replacing,
          replacement,
          replacement :: reversedAccumulator
        )
      case other :: tail =>
        recursiveReplace(
          tail,
          replacing,
          replacement,
          other :: reversedAccumulator
        )
      case Nil => reversedAccumulator.reverse
    }
  }

  recursiveReplace(list, replacing, replacement, List())
}

recursiveReplace(List("Hello", "Mr.", "Williams"), "Mr.", "Mrs.")