object Main extends App {
  def isPalindrome[A](list: List[A]): Boolean = list == list.reverse

  println(isPalindrome(List(1, 2, 3, 2, 1))) // true
  println(isPalindrome(List(1, 2, 3, 2))) // false
}
