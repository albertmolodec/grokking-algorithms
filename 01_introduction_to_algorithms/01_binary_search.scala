def binarySearch(sortedList: List[Int], item: Int): Int = {
  var low = 0
  var high = sortedList.length
  println(low, high)
  low
}

val myList = List(1,3,5,7,9)
println(binarySearch(myList, 3))
println(binarySearch(myList, -1))