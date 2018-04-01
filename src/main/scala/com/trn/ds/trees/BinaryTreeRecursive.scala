package com.trn.ds.trees

/**
  * This class will represent the node of a binary tree
  * @tparam T
  */
/*case class Node[T](var value: T, var left: Node[T] = null, var right: Node[T] = null)*/

/**
  * this class will represent the binary tree
  */
class BinaryTreeRecursive[T <: Int](var root: Node[T] = null) {

  /**
    * This method will add the value in the given binary tree
    */
  def add(item: T) = {
    root = addRecursive(root, item)
  }

  /**
    * This method will actually do the heavy lifting of comparing elements against nodes, then going down further in the tree to find the appropritate
    * place. This method is recursive in nature.
    *
    * It requires two params, as any action will start from the root node, so the very first iteration to this method will be passed as root node,
    * then this method itself will decide if to go further in the left subtree or right subtree
    */
 private def addRecursive(current : Node[T], item: T): Node[T] = {

    if(current == null){
      // we can add the value here
      return new Node(item)
    }

    if(item < current.value){
        // follow left subtree
      current.left = addRecursive(current.left, item)
    } else if(item > current.value){
      // follow right subtree
      current.right = addRecursive(current.right, item)
    } else {
      return current
    }

   return current
  }


  /**
    * finding an element
    */
  def contains(item : T) = {
    containsRecursive(root, item)
  }

  /**
    * recursive implementation of finding
    */
  def containsRecursive(current: Node[T], item: T): Boolean = {
    if(current == null){
      return false
    }

    if(current.value == item){
      return true
    } else if(item < current.value) {
      containsRecursive(current.left, item)
    } else {
      containsRecursive(current.right, item)
    }
  }


  /**
    * Delete a node
    */
  def delete(item: T) = {

  }

  /**
    * recursive delete
    */
  def deleteRecursive(current: Node[T], item: T): Node[T] = {
    if(current == null){
      //item doesn't exist , nothing to delete
    }

    if(item == current.value){

      // actual delete code
      /**
        * if we are deleting a node, there may be three cases :
        * 1. The node is a leaf node... i.e. there are no children. In this case, just return null, as the null will get assigned to
        *   current.XXXX from its previous iteration of recursion
        * 2. The node has one child
        * 3. The node has two children
        */

      /**
        * case 1: The node is a leaf node
        */
      if(current.left == null && current.right == null){
        return null // this will ensure that, instead of current node, the null is being sent, and hence on the previous iteration of recursion the null being is assigned
      }

      if(current.right == null){
        return current.left
      }
      if(current.left == null){
        return current.right
      }



    } else if(item < current.value){
      current.left = deleteRecursive(current.left, item)
    } else {
      current.right = deleteRecursive(current.right, item)
    }

    return current
  }


}



object BinaryTreeRecursive extends App {
  val binaryTree = new BinaryTreeRecursive[Int]()
  binaryTree.add(5)
  binaryTree.add(7)
  binaryTree.add(9)
  binaryTree.add(3)

  println(binaryTree.contains(4))
  println(binaryTree.contains(9))
  println(binaryTree.contains(3))
  println(binaryTree.contains(7))
  println(binaryTree.contains(5))
  println(binaryTree.contains(8))

  println(binaryTree.root)


}
