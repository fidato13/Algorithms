package com.trn.ds.Graphs

import java.util
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
    * since we are using BFS and in particular adjacency list to capture edges among vertices
    *
    */

  def addEdge(first: Int, second: Int) = {
    adjacencyList(first).add(second)
  }

  def isReachable(first: Int, second: Int): Boolean = {

    /**
      * create an array to hold , if the node is visited or not ..
      */
    val visited: Array[Boolean] = Array.fill[Boolean](verticesCount)(false)

    /**
      * create a queue for BFS , i.e. for holding the nodes, this in future can also be
      * a priority queue??
      */
    val queue = new LinkedList[Int]()

    /**
      * set the first in the visited array as true , since we are going to process shortly starting from it
      */
    visited(first) = true

    /**
      * add the first vertex onto the queue
      */
    queue.add(first)

    /**
      * run a loop to process all the queue items, until the queue size becomes zero...
      */
    while(queue.size() != 0){

      /**
        * Pull the item from queue to process, since in BFS, the item which will be picked up, the nodes which are present in it's adjacency list will be visited
        */
      val vertexFromQueue = queue.poll()

      /**
        * Get the adjacency list of this vertex
        */
      val localAdjacencyList = adjacencyList(vertexFromQueue)

      /**
        * Get the list Iterator to go thru this list
        */
      val listIterator = localAdjacencyList.listIterator()

      /**
        * run a while loop to go thru this list/listIterator...this loop will be responsible for BFS, since it will visit all those node which are in it's adjacency list and only after visiting them this loop
        * will come out...and the outer while loop then will be responsible for visiting the adjacency list of those nodes which were touched in the inner while loop iteration
        */
      while(listIterator.hasNext){

        /**
          * get the item
          */
        val innerVertexItem = listIterator.next()

        /**
          * check if it matches the target node, if yes then return... that way we know that there is some way from starting node to target node
          *
          */
        if(innerVertexItem == second) return true


        /**
          * Else continue to BFS, i.e. mark this node as visited after putting them in the queue to be processed
          */
        if(!visited(innerVertexItem)){
          queue.add(innerVertexItem)
          visited(innerVertexItem) = true
        }

      }


    }

    return false

  }

}

object Graph extends App{
  val graph = new Graph(5)

  graph.addEdge(0,1)
  graph.addEdge(0,2)
  graph.addEdge(1,2)
  graph.addEdge(2,0)
  graph.addEdge(2,3)
  graph.addEdge(3,3)

  println(graph.isReachable(0,4))
}
