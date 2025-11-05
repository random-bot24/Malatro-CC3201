package Jokers

import Scores.Score
import combinations.ICombinations
import combinations.AbstractCombinations
import Ranks.Rank
import Suits.Suit
import Cards.Card
import Hands.Hand
import scala.collection.mutable.ArrayBuffer
/**
 * The trait  represents a joker card
 */
trait IJoker {
  def applyScore(score:Score,comb:AbstractCombinations):Score
  def applyScore(score: Score, rank: Rank): Score
  def applyScore(score:Score,pint:Suit): Score
}
