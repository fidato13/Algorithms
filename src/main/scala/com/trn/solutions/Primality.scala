package com.trn.solutions

object Primality {

  def main(args: Array[String]) {

    val sc = new java.util.Scanner (System.in)
    val p = sc.nextInt()
    var a0 = 0
    while(a0 < p){
      val n = sc.nextInt()
      //actual logic
      println(if(!isPrime(n))"Not prime" else "Prime")
      a0+=1
    }


  }


  /**
    * Checks if n is divisible by 2 or any odd number from 3 to sqrt(n).
      The only way to improve on this is to check if n is divisible by
       all KNOWN PRIMES from 2 to sqrt(n).
    * @param num
    * @return
    */
  def isPrime(num: Int):Boolean = {

    if(num == 2 ) true
    else if(num == 1 || (num & 1) == 0) false else {
      for(i <- 3 until Math.sqrt(num).toInt by 2){
        println(s"testing for ${num} with iteration ${i}")
        if(num % i == 0){
          return false
        }


      }
      return true
    }
  }

}
