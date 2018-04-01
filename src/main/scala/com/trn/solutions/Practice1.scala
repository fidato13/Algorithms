package com.trn.solutions

import java.io.{BufferedWriter, File, FileWriter}

import scala.io.{BufferedSource, Source}


object Practice1 {

  def main(args: Array[String]): Unit = {

   /* //val fileContent: List[String] = Source.fromFile("").getLines().toList.map(_.split(" ")(0))
    val s = Seq("apple", "oranges", "apple", "banana", "apple", "oranges", "oranges")
    println(s.groupBy(identity).mapValues(_.size).foreach(x => ))
    val bw = new BufferedWriter(new FileWriter(file))

    val file = new File("")*/




    def traverse[A,B](a: List[A])(f: A => Option[B])/*: Option[List[B]]*/ = {

      val c: List[B] = a.flatMap{ f(_)}


      println("c => "+ c)

     val k: Option[List[B]] =  c.size match {
        case 0 => None
        case _ => Some(c)
      }

      k



    }





    println("All Nones => "+traverse(List(None,None,None)){x =>
      x match {
        case None => None
        case _ => Some(x)
      }
    })

    println("All Ints => "+traverse(List(1,2,2))(Some(_)))
    println("All => "+traverse(List())(_ => None))

    println("help => "+ List(None,None).flatMap(x => Option(x)).flatten)






  }



}
