package com.trn.ds.arrays.and.strings

object Problem1_1 extends App{

  /**
    * Problem :
    * Is Unique: Implement an algorithm to determine if a string has all unique characters. what if you cannot use additional data structures
    */


  /**
    * Solution :
    * Depending upon whether the given string is `Unicode` or `Ascii`, as these two vary in the number of bytes used and the range of chars that can be
    * expressed in Unicode(2 raiseto 21) is way more than in Ascii (0-127), so for our solution in which we are using an array to store each char of the
    * given string, the length of it would vary. But less assume for Ascii i.e. array of length 128 is only required.
    * We will iterate thru each char in the loop, storing a `true` in the value part of the array and the char would determine at which position the value
    * should be put as true
    * Next, we will also check while inserting a new value , if at that index the value already exists, if yes, we can immediately return false from the loop.
    * Next, we are also checking in the very beginning that the length of the string should not be greater than 128 (assuming it's Ascii) as then atleast
    * some of the chars would be repeated.
    *
    * For differences between Ascii vs Unicode , refer to : https://stackoverflow.com/a/19212345/5964149
    *
    * For the first part of the problem, we are using arrays
    * For the second part of the problem -> what if you cannot use additional data structures .. we can do a brute force i.e. check each char against every
    * other char , which runs in O(n*2)
    * Or we could sort and then check for each neighbour character , this would run in `n logn`
    *
    */


  def isUnique(str: String): Boolean = {
    if(str.length > 128) {
      return false
    }

    val bool = new Array[Boolean](128)

    for(i <- 0 until str.length){
      //get the value at the index
      val value = str.charAt(i)

      //if the char is already set as `true` then
      if(bool(value)){
        return false
      }

      //store the value as true if it is not already found
      bool(value) = true


    }

    return true
  }


  //test isUnique method
  println(isUnique("ABCDE12FGHIJKLMNOP"))

}
