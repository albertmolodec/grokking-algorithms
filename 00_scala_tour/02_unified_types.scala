val list: List[Any] = List(
  "a string",
  732,  // an integer
  'c',  // a character
  true, // a boolean value
  () => "an anonymous function returning a string"
)
list.foreach(element => println(element))

val x: Long = 987654321
val y: Float = x  // 9.8765434E8
val face: Char = '☺'
val number: Int = face  // 9786
