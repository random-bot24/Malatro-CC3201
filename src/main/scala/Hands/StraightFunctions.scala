package Hands

import scala.collection.mutable.ArrayBuffer
/**
 * function to check if the hand have a straight(compares Int Type)
 */
object StraightFunctions {
  def checkOrder(list: ArrayBuffer[Int]): Boolean = { 
    val a=list.length
    for (i <- 0 until a - 1) {
      if ((list(i)+1)!=list(i+1))
        return false
    }
    true
  }
}