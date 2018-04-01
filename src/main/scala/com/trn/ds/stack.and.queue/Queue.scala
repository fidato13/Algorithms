package com.trn.ds.stack.and.queue

case class QueueNode[T](var data: T, var next: QueueNode[T] = null)

class Queue[T](var first: QueueNode[T] = null, var last: QueueNode[T] = null) {

  def add(data: T) = {
    val newNode = new QueueNode[T](data)
   if(last != null){
     last.next = newNode
   }

    last = newNode

    if(first == null){
      first = last
    }
  }

  def remove() = {
    if (first == null){
      // exception
    }
    val item = first.data
    first = first.next
    if(first == null){
      last = null
    }
    item
  }

  def peek() = {
    if(first == null) {
      //exception
    }
    first.data
  }

  def isEmpty() = {
    first == null
  }

  def printAll() = {
    println("Starting to print queue => ")
    var temp = first
    while(temp.next != null){
      print(temp.data + ", ")
      temp = temp.next
    }
    if(temp.next == null){
      print(temp.data)
    }
    println("")
    println("Thanks for printing queue.")
  }
}

object Queue extends App {
  val queue = new Queue[Int]()

  println(queue.isEmpty())

  queue.add(5)

  queue.add(10)

  queue.add(15)

  queue.printAll()

  println(queue.remove())

  queue.printAll()

  queue.add(20)

  queue.printAll()

  println(queue.peek())

  queue.printAll()

  println(queue.isEmpty())

}
