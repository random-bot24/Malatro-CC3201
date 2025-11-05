package combinations
import Jokers.IJoker
import Scores.Score
import Hands.Hand
import Cards.Card
import scala.collection.mutable


import scala.collection.mutable.ArrayBuffer
abstract class AbstractCombinations(list_card: ArrayBuffer[Card],hand:Hand) extends ICombinations {
  def applyScore(score:Score,j:IJoker): Score = j.applyScore(score,this)
  def verify(): String= hand.check(list_card)
  
  





  }

 


