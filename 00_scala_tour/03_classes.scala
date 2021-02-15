class User
val jack = new User


class Point(var x: Int = 0, var y: Int = 0) {
  def move(dx: Int, dy: Int): Unit = {
    x += dx
    y += dy
  }

  override def toString(): String = s"($x, $y)"
}
val p = new Point(1, 2)
p.move(5, -3)
println(p.toString()) // (6, -1)
val d = new Point()
println(d.toString()) // (0, 0)
val sx = new Point(5)
println(sx) // (5, 0)
val sy = new Point(y=2)
println(sy) // (0, 2)


class PrivatePoint {
  private var _x = 0
  private var _y = 0
  private val bound = 100

  def x = _x
  def x_= (newValue: Int): Unit = {
    if (newValue < bound) _x = newValue else printWarning
  }
  def y = _y
  def y_= (newValue: Int): Unit = {
    if (newValue < bound) _y = newValue else printWarning
  }

  private def printWarning = println("WARNING: Out of bounds")
}

val point = new PrivatePoint
point.x = 99
point.y = 101