package uk.rajesh.avoidmutable
//Week 4 Objects - Peano numbers
abstract class Nat {
  def isZero : Boolean
  def predecessor : Nat
  def successor : Nat = new Succ(this)
  def + (that: Nat) : Nat
  def - (that: Nat) : Nat
}

object Zero extends Nat {
  override def isZero: Boolean = true

  override def +(that: Nat): Nat = that

  override def -(that: Nat): Nat = if (that.isZero) this else throw new IndexOutOfBoundsException("negative number reached")

  override def predecessor: Nothing = throw new IndexOutOfBoundsException
}

class Succ(elem: Nat) extends Nat {
  override def isZero: Boolean = false

  override def +(that: Nat): Nat = ???

  override def -(that: Nat): Nat = if (that.isZero) this else elem - that.predecessor

  override def predecessor: Nat = elem
}
