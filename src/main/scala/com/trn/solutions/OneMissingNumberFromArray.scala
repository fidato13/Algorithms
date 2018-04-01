package com.trn.solutions

object OneMissingNumberFromArray extends App {


  // find the only missing number from the array 1 - 100
  val arrNum: Array[Int] = 1 to 100 toArray

  arrNum(56) = 0

  // the idea is to calculate the sum of continuous numbers i.e. from 1 to n is n(n + 1) / 2 . so difference in sum would be the number missing

  val idealSum = 100 * 101 / 2

  val actualSum = arrNum.fold(0){(accum, i) =>
    accum + i
  }

  println(s"Missing value is => ${idealSum - actualSum}")

  println(s"Missing index is => ${idealSum - actualSum - 1}")

}
