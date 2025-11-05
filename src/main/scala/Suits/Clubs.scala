package Suits

class Clubs extends AbstractSuit{
  override def toString:String = "club"
  def equals(suit: Suit): Boolean = {
    if (suit.isInstanceOf[Clubs]) {
      return true
    }
    false
  }
  
}
