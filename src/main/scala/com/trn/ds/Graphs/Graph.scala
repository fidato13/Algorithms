package com.trn.ds.Graphs

import java.util._

class Graph(verticesCount: Int, var adjacencyList: Array[LinkedList[Int]] = null) {

  /**
    * this will act as constructor
    */
  adjacencyList = new Array[LinkedList[Int]](verticesCount)

  for(i <- 0 until verticesCount){
    adjacencyList(i) = new LinkedList[Int]()
  }


  /**
    * This method will add edge from first vertex to second , behind the scene ->
    * since we are using BFS and in particular adjacency list to
    */
  
}

object Graph extends App{
  val graph = new Graph(5)

  println()
}
