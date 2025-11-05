package Ranks

import Jokers.IJoker
import Scores.Score
/**
 * The trait defines the basic structure of a card rank
 * The Card contains a range type, value and order
 
 */
trait Rank {
  val range_type:String
  /** range type defines if the card its odd, even or pair
   */
  val value:Int
  /** the cards have a value . It depends if its a figure or the number of the card
   */
  val order:Int
  /** the cards have a position respect the others. The order represent this
   */
  def applyScore(score:Score, j:IJoker): Score
}
