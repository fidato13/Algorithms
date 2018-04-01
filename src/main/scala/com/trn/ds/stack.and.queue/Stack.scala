package com.trn.ds.stack.and.queue

class StackNode[T](var data: T, var next: StackNode[T] = null)

class Stack[T](var top: StackNode[T] = null) {

  def pop() = {
    if(top == null){
      // exception
    }

    val item = top.data
    top = top.next
    item
  }

  def push(item: T) = {
    val newNode = new StackNode[T](item)
    newNode.next = top
    top = newNode
  }

  def peek() = {
    if(top == null){
      // exception
    }

    top.data
  }

  def isEmpty() = {
    top == null
  }


  def printAll() = {
    println("Starting to print stack => ")
    var temp = top
    while(temp.next != null){
      print(temp.data + ", ")
      temp = temp.next
    }
    if(temp.next == null){
      print(temp.data)
    }
    println("")
    println("Thanks for printing stack")
  }
}


object Stack extends App {
  val stack = new Stack[Int]()

  println(stack.isEmpty())

  stack.push(5)

  stack.push(10)

  stack.push(15)

  stack.printAll()

  println(stack.pop())

  stack.printAll()

  stack.push(20)

  stack.printAll()

  println(stack.peek())

  stack.printAll()

  println(stack.isEmpty())




}