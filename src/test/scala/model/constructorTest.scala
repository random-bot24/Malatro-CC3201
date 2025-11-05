package model
import munit.FunSuite
import Cards.Card
import Suits.{Clubs,Diamonds}
import Ranks.{As,Jack}
class constructorTest extends FunSuite{
  var card_1=new Card(new As,new Clubs)
  var card_2=new Card(new Jack,new Diamonds)
  override def beforeEach(context:BeforeEach): Unit = {
    card_1=new Card(new As,new Clubs)
    card_2=new Card(new Jack,new Diamonds)
  }
  test("constructor test"){
    assertEquals("odd",card_1.rank.range_type)
    assertEquals(1,card_1.rank.order)
    assertEquals(11,card_1.rank.value)
  }
  test("constructor test2") {
    assertEquals("figure", card_2.rank.range_type)
    assertEquals(11, card_2.rank.order)
    assertEquals(10, card_2.rank.value)
  }



}
