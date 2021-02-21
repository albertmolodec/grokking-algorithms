import scala.annotation.tailrec

object PatternMatching {
  def main(args: Array[String]): Unit = {
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

    println(
      "[Loop]      List(\"Hello\", \"Mr.\", \"Williams\"), \"Mr.\", \"Mrs.\"" + " -> " + recursiveReplace(
        List("Hello", "Mr.", "Williams"),
        "Mr.",
        "Mrs."
      )
    )
    println(
      "[Recursion] List(\"Hello\", \"Mr.\", \"Williams\"), \"Mr.\", \"Mrs.\"" + " -> " + replace(
        List("Hello", "Mr.", "Williams"),
        "Mr.",
        "Mrs."
      )
    )
  }
}
