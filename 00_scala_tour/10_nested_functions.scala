def factorial(x: Int): Int = {
  def factorial(x: Int, accumulator: Int): Int = {
    if (x <= 1) accumulator
    else factorial(x - 1, x * accumulator)
  }
  factorial(x, 1)
 }

println("Factorial of 2: " + factorial(2))
println("Factorial of 3: " + factorial(3))