package Cards

import Suits.Suit
import Ranks.Rank
import Scores.Score
import Jokers.IJoker
import scala.collection.mutable.ArrayBuffer
/**
 * The trait  represents a card
 * The Hard have a Rank and a suit to represent the card
 * For example the card As of Spades: card=new Card(new As, new Spades)
 */
class Card(val rank:Rank, val pint:Suit) {
  def getRank: Rank=rank
  def getSuit: Suit=pint
  def applyScore(score:Score,listJ:ArrayBuffer[IJoker]): Score={
    for (i <-listJ){
      i.applyScore(score,rank)
      i.applyScore(score,pint)
    }
    score
  }
}
