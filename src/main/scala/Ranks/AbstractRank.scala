package Ranks
import Scores.Score
import Jokers.IJoker
abstract class AbstractRank extends Rank {
   def applyScore(score:Score, j:IJoker): Score = j.applyScore(score,this)
}
