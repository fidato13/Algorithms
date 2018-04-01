package com.trn.ds.linkedlist

/**
  * This class represents a Node[T] in the linkedlist where T is the type of data value that it holds.
  * A node in a linkedlist contains two members : data & next
  * data - it represents the value that a node holds
  * next - it is generally a pointer/reference to the next node
  */
case class Node[T](var data: T, var next: Node[T])

/**
  * LinkedList class is a wrapper around Node class, the linkedList class has one member variable `head` which points to the head of linkedlist or
  * first node
  */
class LinkedList[A](var head: Node[A] = null) {


  /**
    * insert item at beginning
    */
  def insertFront(value: A) = {

    // if there is nothing yet!
    if(head == null){
      head = new Node(value, null)
    } else {
      val newNode = new Node(value, null)
      newNode.next = head
      head = newNode
    }
  }

  /**
    * insert item at end
    */
  def insertEnd(value: A) = {
    var temp = head
    if(temp == null){
      head = new Node(value, null)
    } else {
      while(temp.next != null){
        temp = temp.next
      }
      val newNode = new Node(value, null)
      temp.next = newNode
    }
  }

  def insertAfter(targetValue: A, newValue: A) = {
    if(head == null){
      head = new Node(newValue, null)
    } else {
      var temp = head
      while (temp.next != null && temp.data != targetValue ){
        temp = temp.next
      }

      // either we have traversed the whole list and reached the end, or we are at target value
      if(temp.next == null){
        temp.next = new Node(newValue, null)
      } else {
        val newNode = new Node(newValue,null)
        newNode.next = temp.next
        temp.next = newNode
      }
    }
  }

  def deleteBeginning() = {
    var temp = head
    head = head.next
    temp.next = null


  }

  def deleteEnd() = {
    var temp = head
    if(temp == null) {
      //nothing to delete
    } else if(temp.next == null) {
      // delete current
      head = null
    } else {
      while (temp.next.next != null) {
        temp = temp.next
      }

      temp.next = null
    }
  }

  def deleteSpecific(targetValue: A) = {
    if(head == null){
      //nothing to delete
    } else if(head.data == targetValue){
      //first node is target value
      var temp = head
      head = head.next
      temp.next = null
    } else {
      var temp = head
      while(temp.next != null && temp.next.data != targetValue){
        temp = temp.next
      }

      if(temp.next == null) {
        // item not present
      } else {
        var temp2 = temp.next
        temp.next = temp.next.next
        temp2.next = null
      }


    }
  }

  /**
    * print values
    */
  def printAll() = {
    println("Starting to print linkedList => ")
var temp = head
    while(temp.next != null){
      print(temp.data + ", ")
      temp = temp.next
    }
    if(temp.next == null){
      print(temp.data)
    }
    println("")
    println("Thanks for printing linkedlist.")
  }


}

object LinkedListDemo extends App{
  // create a new linkedlist
  val linkedList = new LinkedList[Int]()

  /**
    * insert item at beginning
    */

  linkedList.insertFront(5)
  linkedList.insertFront(15)
  linkedList.insertFront(52)
  linkedList.insertFront(27)



  /**
    * insert item at end
    */
  linkedList.insertEnd(6)
  linkedList.insertEnd(99)
  linkedList.insertEnd(23)

  /**
    * insert item after a specific value
    */
linkedList.insertAfter(52, 17)
  linkedList.insertAfter(33, 18)
  linkedList.insertAfter(15, 66)

  // print
  linkedList.printAll()

  /**
    * delete node from the beginning
    */
  linkedList.deleteBeginning()
  linkedList.deleteBeginning()


  /**
    * delete node from the end
    */
  linkedList.deleteEnd()

  linkedList.deleteEnd()

  /**
    * delete node after a specific node/value
    */

  linkedList.deleteSpecific(15)



  // print linkedList
  linkedList.printAll()

}
