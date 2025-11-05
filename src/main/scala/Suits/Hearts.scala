package Suits

class Hearts extends AbstractSuit {
  override def toString:String="heart"
  def equals(suit: Suit): Boolean = {
    if (suit.isInstanceOf[Hearts]) {
      return true
    }
    false
  }

}
