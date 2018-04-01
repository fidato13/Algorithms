package com.trn.ds.linkedlist

class Problem2_3[T] extends LinkedList[T] {

  def deleteNode(passedNode: Node[T]): Boolean = {
    var node = passedNode
    if(node == null || node.next == null){
      // do nothing as the last node can't be deleted, because we are on that node, copying over the data from the next node and then deleting the next
      // node, this gives us the illusion of deleting the current node, but we are actually just copying over the data
    return false;
    }

    //copy over the data from next node to passed node
    var newNode = node.next
    node.data = newNode.data
    node.next = newNode.next

    //delete the next node as that is the same as current one now
    newNode.next = null

    return true


  }

}

object Problem2_3 extends App {
  val linkedList = new Problem2_3[Int]()
  linkedList.insertEnd(5)
  linkedList.insertEnd(10)
  linkedList.insertEnd(15)
  linkedList.insertEnd(20)
  linkedList.insertEnd(25)
  linkedList.insertEnd(30)
  linkedList.insertEnd(35)
  linkedList.insertEnd(40)

  linkedList.printAll()



  linkedList.deleteNode(linkedList.head.next.next)

  linkedList.printAll()
}