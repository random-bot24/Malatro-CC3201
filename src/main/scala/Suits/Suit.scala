package Suits

import Jokers.IJoker
import Scores.Score

/**
 * The trait that represents a suit
 * For example: Diamond, Clubs, Hearts or Spades
 */
trait Suit {
   def toString: String
   def equals(suit:Suit): Boolean
   def applyScore(score:Score,j:IJoker): Score
}
