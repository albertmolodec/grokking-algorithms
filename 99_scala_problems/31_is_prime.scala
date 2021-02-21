object Main extends App {
  def isPrime(n: Int): Boolean = n != 1 && (2 until n).forall(n % _ != 0)

  for {
    i <- 1 to 100
    if isPrime(i)
  } print(s"$i ")
}