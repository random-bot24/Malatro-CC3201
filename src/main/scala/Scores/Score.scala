package Scores
import Hands.Hand
class Score(var chips:Int,var mult:Int) {
  def calculateScore(cards:ArrayBuffer[Card],jokers:ArrayBuffer[IJoker]):Score={
      check(cards)
      for (card <- cards)
        this.chips+=card.rank.value
        card.applyScore(this,jokers)
        
  }
}
  
