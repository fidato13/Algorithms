package com.trn.solutions

object DuplicateELementsInArray extends App {

  // find the only missing number from the array 1 - 100
  val arrNum: Array[Int] = 1 to 100 toArray

  //arrNum(50) = arrNum(49)

  arrNum.foreach(println(_))

  val setFromArray = arrNum.toSet

  val duplicateELementsInArray = if(setFromArray.size < arrNum.size) true else false

  println(duplicateELementsInArray)
}
