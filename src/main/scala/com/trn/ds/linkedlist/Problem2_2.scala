package com.trn.ds.linkedlist

object Problem2_2 extends App {
  /**
    * Problem :
    * find the kth element from the last in a SinglyLinkedList
    *
    * Solution :
    * "Runner" technique, Implement two pointers, one to be started when k elements have passed for the first pointer, thus the distance
    * between them would always be 3. so when the first pointer would be at last node, the second pointer will be at location kth from the last
    */

  val linkedList = new LinkedList[Int](null)
  linkedList.insertEnd(5)
  linkedList.insertEnd(10)
  linkedList.insertEnd(15)
  linkedList.insertEnd(20)
  linkedList.insertEnd(25)
  linkedList.insertEnd(30)
  linkedList.insertEnd(35)
  linkedList.insertEnd(40)

//suppose k being 3 for this question
var k = 3
  var forward = linkedList.head
  var back = linkedList.head
  var i = 0
  while(forward.next != null){
    i+=1
    if(i==k){
      back = linkedList.head
    }
    forward = forward.next
    back = back.next

  }

  linkedList.printAll()

  println(back.data)
}
