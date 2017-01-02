package funsets

object Main extends App {
  //println(contains(singletonSet(1), 1))
  //contains(i=>i>0, 4)
  val f: Set = i => i < 0
  val f4: Set = singletonSet(-4)
  val f5: Set = singletonSet(5)
  val f51: Set = singletonSet(5)
  println(contains(f4, 4))
  println(contains(f4, -4))

  println("*** Union ***")
  println(union(f4, f5)(5))
  println(union(f4, f5)(-4))
  println(union(f4, f5)(2))

  println("*** Intersect ***")
  println(intersect(f51, f5)(5))
  println(intersect(f51, f5)(-4))
  println(intersect(f51, f5)(2))

  println("*** Diff ***")
  println(diff(f51, f4)(5))
  println(diff(f51, f4)(-4))
  println(diff(f51, f51)(2))

  println("*** Filter ***")
  println(filter(f5, i => i > 0)(5))
  println(filter(f5, i => i > 0)(-4))
  println(filter(f5, i => true)(2))
}
