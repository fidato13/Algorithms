package com.trn.ds.arrays.and.strings

object Problem1_3 extends App{


  /**
    * Problem :
    * Replace all spaces in string with '%20' , you are required to do inplace substitution and there is an extra padding given at the end
    * Also, the true length of the string is also given
    */

  /**
    * Solution :
    * We will first count the number of spaces to estimate the required extra space that we want ; thus calculating the final length of the string
    * Then we will start actually mutating the characters from end, as we don't want to overwrite , which is possible when we start from the front
    */

  def urlify(str: Array[Char], trueLength: Int): String = {

    // count spaces
    var countSpaces: Int = 0
    for(i <- 0 until trueLength){
      if(str(i) == ' '){
        countSpaces+=1
      }
    }

  // once we have the space count , we can estimate the final length of the string
    var finalLength = trueLength + countSpaces * 2 // multiplying by 2 as one space char and two other chars would make up as '%20'

    // optimization -> if the final length is greater than str.length , which means that the padding provided in the string is not enough...invalid problem

    //now start mutating from the end
    for(i <- (trueLength - 1) to 0 by -1){
      if(str(i) == ' '){
        str(finalLength - 1) = '0'
        str(finalLength - 2) = '2'
        str(finalLength - 3) = '%'
        finalLength-=3
      }
      else {
        str(finalLength - 1) = str(i)
        finalLength-=1
      }
    }

    String.valueOf(str)

  }

  println(urlify("Mr John Smith        ".toCharArray, 13))


}
