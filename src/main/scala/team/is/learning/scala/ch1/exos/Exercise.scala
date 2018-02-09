package team.is.learning.scala.ch1.exos

import java.lang.Exception

import scala.annotation.tailrec

object Exercise {


  def main(args: Array[String]) {
    //infinite("Hello scala")
    //repeat(3)
    //println(sum(List(1, 2, 3)))
    //println(replicate(3, "hey jojax"))
    //println(maximum(List(1,1,1,4)))
    //println(reverse(List("1", "2", "3", "4")))
    //println(contains(List("1", "1", "1", "4"), "24"))
    //println(take(5, List("1", "1", "1", "4")))

  }

  //infinite println
  def infinite(msg: String): Unit = {
    println(msg)
    infinite(msg)
  }

  //Infinite repeat of x
  def repeat(x: Int): Unit = {
    infinite(s"$x")
  }

  // sum
  def sum(xs: List[Int]): Int = {
    def loop(acc: Int, ys: List[Int]): Int = {
      xs match {
        case h :: tail => loop(acc + h, tail)
        case Nil => acc
      }
    }

    loop(0, xs)
  }

  //replicate msg n times
  def replicate(n: Int, msg: String): List[String] = {
    def loop(counter: Int, seq: List[String]): List[String] = {
      if (counter != n) {
        loop(counter + 1, msg :: seq)
      } else {
        seq
      }
    }

    loop(0, List())
  }

  def maximum(xs: List[Int]): Int = {
    def loop(max: Int, values: List[Int]): Int = {
      values match {
        case h :: tail if h >= max => loop(h, tail)
        case h :: tail if h < max => loop(max, tail)
        case Nil => max
      }
    }

    loop(xs.head, xs.tail)
  }

  def reverse(xs: List[String]): List[String] = {
    def loop(values: List[String], reversed: List[String]): List[String] = {
      values match {
        case h :: tail => loop(tail, h :: reversed)
        case Nil => reversed
      }
    }

    loop(xs, List())
  }

  def contains(xs: List[String], elem: String): Boolean = {
    def loop(values: List[String], value: String): Boolean = {
      values match {
        case h :: tail if h == value => true
        case h :: tail if h != value => loop(tail, elem)
        case Nil => false
      }
    }

    loop(xs, elem)
  }

  //take n first elems from xs
  def take(n: Int, xs: List[String]): List[String] = {
    def loop(acc: Int, ordered: List[String], reversed: List[String]): List[String] = {
      ordered match {
        case h :: tail if acc != n => loop(acc + 1, tail, h :: reversed)
        case _ => reversed
      }
    }

    loop(0, xs, List())
  }


}
