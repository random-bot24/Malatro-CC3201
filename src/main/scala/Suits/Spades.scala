package Suits

class Spades extends AbstractSuit{
  override def toString:String ="spades"
  def equals(suit: Suit): Boolean = {
    if (suit.isInstanceOf[Spades]) {
      return true
    }
    false
  }
}
