package com.trn.solutions

import scala.annotation.tailrec

object Fibonacci {

  def fibonacci(x:Int):Int = {

    x match {
      case 0 => x
      case 1 => x
      case _ => fibonacci(x - 1) + fibonacci(x - 2)
    }
    // Write your code here. You may add a helper function as well, if necessary.
  }

  def fibTailRec(x: Int): List[Int] = {
    // if x is 5, then List(1,1,2,3,5)
    // if x is 8, then List(1,1,2,3,5,8,13,21)

    @tailrec
    def fibInternal(current: Int, list: List[Int]):List[Int] = {

      current match {
        case 0 => fibInternal(1, list :+ 1)
        case 1 => fibInternal(2, list :+ 1)
        case _ if(current >= x) => list
        case _ => {
          val last = list.last
          val secondLast = list.reverse.tail.head
          val elem = last + secondLast
          fibInternal(current + 1,  list :+ elem)
        }
      }

    }

    fibInternal(0, List.empty[Int])

  }

  def main(args: Array[String]) {
    /** This will handle the input and output**/
    //println(fibonacci(readInt()))

    println("fibonacci => "+ fibonacci(7))
    println("fibTailRec => "+ fibTailRec(11))

  }

}
