package Hands

/**
 * function to check if the hand have a flush
 */
import scala.collection.mutable.ArrayBuffer
object FlushCheck {
  def checkFlush(list:ArrayBuffer[String]): Boolean={
    val a=list.length
    for (i<-0 until (a-1)){
      if (list(i)!=list(i+1))
        return false
    }
    true
  }
}
