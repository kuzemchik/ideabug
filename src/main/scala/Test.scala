/**
 * User: kuzemchik
 * Date: 3/21/14
 */
import scala.slick.driver.PostgresDriver.simple._

class A(tag:Tag) extends Table[(Int,Int,Int,Int,Int)](tag,"a") {
  def a1 = column[Int]("a1")
  def a2 = column[Int]("a2")
  def a3 = column[Int]("a3")
  def a4 = column[Int]("a4")
  def a5 = column[Int]("a5")
  def * = (a1, a2, a3, a4, a5)
}

class B(tag:Tag) extends Table[(Int,Int,Int,Int,Int)](tag,"b") {
  def b1 = column[Int]("b1")
  def b2 = column[Int]("b2")
  def b3 = column[Int]("b3")
  def b4 = column[Int]("b4")
  def b5 = column[Int]("b5")
  def * = (b1, b2, b3, b4, b5)
}

class C(tag:Tag) extends Table[(Int,Int,Int,Int,Int)](tag,"c") {
  def c1 = column[Int]("c1")
  def c2 = column[Int]("c2")
  def c3 = column[Int]("c3")
  def c4 = column[Int]("c4")
  def c5 = column[Int]("c5")
  def * = (c1, c2, c3, c4, c5)
}

class D(tag:Tag) extends Table[(Int,Int,Int,Int,Int)](tag,"d") {
  def d1 = column[Int]("d1")
  def d2 = column[Int]("d2")
  def d3 = column[Int]("d3")
  def d4 = column[Int]("d4")
  def d5 = column[Int]("d5")
  def * = (d1, d2, d3, d4, d5)
}

class E(tag:Tag) extends Table[(Int,Int,Int,Int,Int)](tag,"e") {
  def e1 = column[Int]("e1")
  def e2 = column[Int]("e2")
  def e3 = column[Int]("e3")
  def e4 = column[Int]("e4")
  def e5 = column[Int]("e5")
  def * = (e1, e2, e3, e4, e5)
}

object Test {
  val at = TableQuery[A]
  val bt = TableQuery[B]
  val ct = TableQuery[C]
  val dt = TableQuery[D]
  val et = TableQuery[E]

  at
    .innerJoin(bt)
      .on { case (a,b) => a.a1 === b.b1}
    .innerJoin(ct)
      .on { case ((a,b),c) => b.b2 === c.c2 }
    .map { case ((a,b),c) => (a,b,c) }
    .innerJoin(dt)
      .on { case ((a,b,c),d) => c.c3 === d.d3 }
    .map { case ((a,b,c),d) => (a,b,c,d) }
    .innerJoin(et)
      .on { case ((a,b,c,d),e) => d.d4 === e.e4 }
    .map { case ((a,b,c,d),e) => (a,b,c,d,e) }

}
