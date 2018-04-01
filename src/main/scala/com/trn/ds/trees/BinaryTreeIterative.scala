package com.trn.ds.trees

/**
  * This class will represent the node of a binary tree
  *
  * @tparam T
  */
case class Node[T](var value: T, var left: Node[T] = null, var right: Node[T] = null)

/**
  * this class will represent the binary tree
  */
class BinaryTreeIterative[T <: Int](var root: Node[T] = null) {

  /**
    * This method will find the item in the tree using iterative approach
    */
  def find(item: T): Node[T] = {

    var current = root

    while (current.value != item) {

      if (item < current.value) {
        current = current.left
      } else if (item > current.value) {
        current = current.right
      }

      if (current == null) {
        return null
      }
    }

    return current
  }


  /**
    * This method will insert node into the tree, it will also insert duplicate nodes
    */
  def add(item: T): Boolean = {
    /**
      * create a new node
      */
    val newNode = Node(item)

    // start a root node
    if (root == null) {
      //no node exists, first node
      root = newNode
      return true

    } else {
      // root is occupied, hence start normally
      var current = root
      var parent: Node[T] = null
      while (true) {
        parent = current

        if (item < current.value) { // go left
          current = current.left

          // as we have now assigned the child to current pointer, which could be null implying that it is the place to be inserted
          if (current == null) {
            parent.left = newNode
            return true
          }
        }
        else {
          current = current.right

          if (current == null) {
            parent.right = newNode
            return true
          }
        }

      }

      return true
    }


  }

  /**
    * This method will traverse the tree in-order
    */
  def inOrderTraversal(node: Node[T]): Unit = {
    if(node != null){
      inOrderTraversal(node.left)

      print(" "+node.value)

      inOrderTraversal(node.right)
    }
  }


  /**
    * This method will traverse the tree pre-order
    */
  def preOrderTraversal(node: Node[T]): Unit = {
    if(node != null){


      print(" "+node.value)

      inOrderTraversal(node.left)

      inOrderTraversal(node.right)
    }
  }

  /**
    * This method will traverse the tree post-order
    */
  def postOrderTraversal(node: Node[T]): Unit = {
    if(node != null){

      inOrderTraversal(node.left)

      inOrderTraversal(node.right)

      print(" "+node.value)
    }
  }

  /**
    * finding minimum - as the Binary search tree would always store the minimum value in the leftmost bottom part
    */
  def min: Node[T] = {
    var last = root
    var current = root

    while(current != null){
      last = current
      current = current.left
    }

    last
  }

  /**
    * finding maximum - as the Binary search tree would always store the minimum value in the rightmost bottom part
    */
  def max: Node[T] = {
    var last = root
    var current = root

    while(current != null){
      last = current
      current = current.right
    }

    last
  }

  /**
    * delete item
    * @param item
    */
  def delete(item: T): Boolean = {

    if(root == null){
      // no node in the tree
      return false
    } else {
      var current = root
      var parent = current
      while(current.value != item){
        parent = current

        if(item < current.value){
          current = current.left
        } else if(item > current.value) {
          current = current.right
        }

        if(current == null){
          return false // didn't find it
        }
      }

      // node found

      /**
        * if this is a leaf node
        */
      if(current.left == null && current.right == null){
        if(current == root){
          root = null
          return true
        }
        else if(parent.left.value == item){
          parent.left = null
          return true
        } else {
          parent.right = null
          return true
        }
      }

      return true

    }
  }

}


object BinaryTreeIterative extends App {
  val binaryTree = new BinaryTreeIterative[Int]()

  binaryTree.add(5)
  binaryTree.add(10)
  binaryTree.add(1)
  binaryTree.add(2)
  binaryTree.add(6)
  binaryTree.add(8)
  binaryTree.add(40)
  binaryTree.add(30)


  println(binaryTree.root)

  println(binaryTree.find(4))
  println(binaryTree.find(2))
  println(binaryTree.find(40))
  println(binaryTree.find(33))

  binaryTree.inOrderTraversal(binaryTree.root)
  println()
  binaryTree.preOrderTraversal(binaryTree.root)
  println()
  binaryTree.postOrderTraversal(binaryTree.root)

  println()
  println(binaryTree.min)

  println()
  println(binaryTree.max)

  binaryTree.delete(30)

  binaryTree.inOrderTraversal(binaryTree.root)

}
