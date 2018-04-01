package com.trn.solutions

import scala.annotation.tailrec

object Palindrome extends App {


  def isPalindrome(str: String): Boolean = {

    @tailrec
    def internalPalindrom(rem: List[Char]): Boolean = {


      rem.size match {
        case f if f <= 1 => true
        case _ =>
          rem.last match {
            case f if (f != rem.head) => false
            case z if z == rem.head => {
              val nextRemTail: List[Char] = rem.tail
              val finalRem: List[Char] = nextRemTail.reverse.tail
              internalPalindrom(finalRem)
            }

          }

      }



    }

    internalPalindrom(str.toList)

  }



  def longestPalindrome(str: String): String = {

    // basically the idea is very simple... string and it's reverse string , would have some part matching when projected over each other if they have a substring which is plaindrome
    // TREEYESORNO
    // ONROSEYEERT

    val revStr = str.reverse
    val stringLength = str.length

    var prevMatch = ""

    for(i <- 0 until stringLength){

      for (j <- i + 1 to stringLength){
        val subStr = str.substring(i,j)
        revStr.contains(subStr) match {
          case true if (subStr.length > prevMatch.length) => prevMatch = subStr
          case true => prevMatch = prevMatch
          case false => prevMatch = prevMatch // do nothing
        }
      }
    }

    prevMatch

  }

  println(isPalindrome("ABCDEEDCBA"))
  println(longestPalindrome("TREEYESORNO"))
  println(longestPalindrome("345345ABCDEabcde edcbaDEABC12312123"))
  println(longestPalindrome("abcdefghijklmnopqrstuvwxyzzyxwvutsrqponmlkjihgfedcba"))
  println(longestPalindrome("abcababac"))
}
