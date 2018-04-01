package com.trn.ds.arrays.and.strings

object Problem1_2 extends App {

  /**
    * Problem :
    * checkPermutation : check if two given strings are permutation of each other.
    */

  /**
    * Solution 1:
    *
    * Sort the strings, if the have unequal lengths , then they are not , else if they have equal lengths and are .equals , then they are permutations
    * of each other
    */

  def checkPermutation1(str1: String, str2: String): Boolean = {
    def internalSort(str: String) = {
      val charArray = str.toCharArray
      java.util.Arrays.sort(charArray) // it sorts array in-place
      String.valueOf(charArray)
    }

    if(str1.length != str2.length){
      return false
    }

    if(internalSort(str1).equals(internalSort(str2))){
      return true
    } else{
      return false
    }
  }

  // test the solution
  println(checkPermutation1("help","pelh"))
  println(checkPermutation1("he3lp","pe2lh"))

  /**
    * Solution 2 :
    * check the character count of each char in both strings, if they are equal then they are permutations of each other
    */

  def checkPermutation2(str1: String, str2: String): Boolean = {
    if(str1.length != str2.length){
      return false
    }
    // assumption of it being ascii ... here we will have the index postion as the char itself
    // and the value against it being the count of how many time it appeared
    val charCount = new Array[Int](128)

    // populating the char count array
    str1.foreach(c => charCount(c) = charCount(c) + 1)

    for(c: Char <- str2){
      charCount(c) = charCount(c) - 1
      if(charCount(c) < 0){
        return false
      }
    }

    return true
  }

  // test the solution
  println(checkPermutation2("help","pelh"))
  println(checkPermutation2("he3lp","pe2lh"))

}
