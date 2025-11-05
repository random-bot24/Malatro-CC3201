package Jokers

import Scores.Score
import combinations.{AbstractCombinations, ICombinations}
import Ranks.Rank
import Suits.Suit
/**
 * This class represents the evenSteven Joker
 */
class Even_Steven extends IJoker {
  override def applyScore(score: Score, comb: AbstractCombinations): Score = {
      score
  }

  override def applyScore(score: Score, rank: Rank): Score = {
      if (rank.range_type=="even") {
        score.mult += 4
        score
      }
      else{
        score
      }
  }

  override def applyScore(score: Score, pint: Suit): Score = {
      score
  }

}
