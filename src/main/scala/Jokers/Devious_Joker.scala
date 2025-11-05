package Jokers

import Scores.Score
import combinations.ICombinations
import Ranks.Rank
import combinations.AbstractCombinations
import Suits.Suit
import scala.collection.mutable.ArrayBuffer
import Cards.Card
import Hands.Hand
/**
 * This class represents the Devious Joker
 */
class Devious_Joker extends IJoker{

  override def applyScore(score: Score, comb: AbstractCombinations): Score = {
     val a:String=comb.verify()
     if (a =="The highest hand its a Straight"){
       score.chips+=100
       score
     }
     else{
       score
     }
  }

  override def applyScore(score: Score, rank: Rank): Score = {
     score
  }

  override def applyScore(score: Score, suit: Suit): Score = {
     score
  }
}
