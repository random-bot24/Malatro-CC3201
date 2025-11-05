package Suits

class Diamonds extends AbstractSuit {
  override def toString: String="diamond"
  def equals(suit: Suit): Boolean = {
    if (suit.isInstanceOf[Diamonds]) {
      return true
    }
    false
  }
}
