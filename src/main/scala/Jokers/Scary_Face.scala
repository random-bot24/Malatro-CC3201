package Jokers
import Scores.Score
import Ranks.Rank
import Suits.Suit
import combinations.{AbstractCombinations, ICombinations}
/**
 * This class represents the Scary Face Joker
 */
class Scary_Face extends IJoker{
  override def applyScore(score:Score,comb:AbstractCombinations):Score={
    score

  }
  override def applyScore(score:Score,rank:Rank): Score={
    if (rank.range_type=="figure"){
      score.chips+=30
      score
    }
    else{
      score
    }
  }
  override def applyScore(score:Score,pint:Suit): Score={
      score
  }


}
