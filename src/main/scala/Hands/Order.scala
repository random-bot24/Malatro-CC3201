package Hands

import scala.collection.mutable.ArrayBuffer

/**
 * function to sort(we need it for the check the straight)
 */
object Order {
  def sortArrayBuffer(arr: ArrayBuffer[Int]): ArrayBuffer[Int] = {
    val n = arr.length
    for (i <- 0 until n - 1) {
      for (j <- 0 until n - i - 1) {
        if (arr(j) > arr(j + 1)) {
          val temp = arr(j)
          arr(j) = arr(j + 1)
          arr(j + 1) = temp
        }
      }
    }
    arr
  }
}
