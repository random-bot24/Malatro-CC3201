package Jokers
import Scores.Score
import combinations.{AbstractCombinations, ICombinations}
import Ranks.Rank
import Suits.Suit
/**
 * This class represents the GreedyJoker
 */
class GreedyJoker extends IJoker {
  override def applyScore(score: Score, comb: AbstractCombinations): Score = {
    score
  }

  override def applyScore(score: Score, rank: Rank): Score = {
     score
  }

  override def applyScore(score: Score, pint: Suit): Score = {
    if (pint.toString=="diamond"){
      score.mult+=3
      score
    }
    else{
       score
    }
  }

}
