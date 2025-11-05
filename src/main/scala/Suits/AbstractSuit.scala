package Suits

import Jokers.IJoker
import Scores.Score
abstract class AbstractSuit extends Suit{
  def applyScore(score:Score,j:IJoker):Score=j.applyScore(score,this)
}
