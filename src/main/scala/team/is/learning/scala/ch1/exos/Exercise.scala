package team.is.learning.scala.ch1.exos

import java.lang.Exception

import scala.annotation.tailrec

object Exercise {
  def main(args: Array[String]): Unit = {
    //infinite("Hello scala")
    println(take(10, List(1,2,3)))
  }
  
  //infinite println
  def infinite(msg: String): Unit = {
    println(msg)
    infinite(msg)
  }

  //Infinite repeat of x
  def repeat[A](x: A): List[A] = {
    @tailrec
    def loop(acc: List[A]): List[A] = loop(x :: acc)
    loop(List.empty[A])
  }

  // sum
  def sum(xs: List[Int]): Int = {
    def loop(acc: Int, ys: List[Int]): Int = ys match {
      case Nil     => acc
      case x :: zs => loop(x + acc, zs)
    }
    if (xs.isEmpty) throw new NoSuchElementException("Empty list")
    else loop(0, xs)
  }

  //replicate msg n times
  def replicate[A](n: Int, msg: A): List[A] = {
    def rec(acc: List[A], m: Int): List[A] = m match {
      case 0 => acc
      case _ => rec(msg :: acc, m - 1)
    }
    rec(List.empty[A], n)
  }

  def maximum(xs: List[Int]): Int = {
    @tailrec
    def rec(acc: Int, ys: List[Int]): Int = ys match {
      case Nil     => acc
      case y :: zs => if (acc > y) acc else rec(y, zs)
    }
    xs match {
      case Nil     => throw new NoSuchElementException("Empty List")
      case x :: ys => rec(x, ys)
    }
  }

  //a deviner
  def maximum0(xs: List[Int]): Int = ???

  def reverse[A](xs: List[A]): List[A] = {
    def rec(acc: List[A], ys: List[A]): List[A] = ys match {
      case Nil => acc
      case y::zs => rec(y::acc, zs)
    }
    rec(List.empty[A], xs)
  }

  def contains(xs: List[String], elem: String): Boolean = {
    def rec(acc: Boolean, ys: List[String]): Boolean = ys match {
      case Nil => acc
      case y::zs if y == elem => true
      case _::zs => rec(acc, zs)
    }
    rec(false, xs)
  }

  //take n first elems from xs
  def take[A](n: Int, xs: List[A]): List[A] = {
     def rec(acc: List[A], ys: List[A], m: Int): List[A] = if(m == 0) acc else ys match {
       case Nil => acc
       case y::zs => rec(acc ++ List(y), zs, m-1)
     }
     rec(List.empty[A], xs, n)
  }
}
