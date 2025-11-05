package model
import munit.FunSuite
import Cards.Card
import Hands.Hand
import Jokers.{Devious_Joker, GreedyJoker, IJoker, Scary_Face}
import Exceptions.*

import scala.collection.mutable.ArrayBuffer
import Ranks.{As, Rank, Two}
import Suits.{Spades, Suit}
class exceptionsTest extends FunSuite {
  var deviousJoker: Devious_Joker = _
  var greedyJoker: GreedyJoker = _
  var ScaryJoker: Scary_Face=_
  var listJ: ArrayBuffer[IJoker] =_
  var hand: Hand=_
  var listC: ArrayBuffer[Card]=_
  var listI: ArrayBuffer[Int]=_
  var listC_2: ArrayBuffer[Card]=_
  override def beforeEach(context: BeforeEach): Unit = {
    deviousJoker=new Devious_Joker
    greedyJoker= new GreedyJoker
    ScaryJoker=new Scary_Face
    listJ=ArrayBuffer[IJoker]()
    listC=ArrayBuffer[Card]()
    hand= new Hand(listC,listJ)
    listI=ArrayBuffer[Int]()
    listC_2=ArrayBuffer[Card]()
  }

  test("addJokers should throw a exception") {
    hand.addJoker(deviousJoker)
    hand.addJoker(greedyJoker)
    hand.addJoker(new GreedyJoker)
    intercept[MaxJokersSizeExceptions](hand.addJoker(ScaryJoker))
  }

  test("removeJokers should throw a exception"){
    hand.addJoker(deviousJoker)
    intercept[RemoveIllegalIndexJoker](hand.removeJoker(1))
  }
  test("addCard should throw a exception"){
    hand.addCard(new Card(new As,new Spades))
    hand.addCard(new Card(new As,new Spades))
    hand.addCard(new Card(new As,new Spades))
    hand.addCard(new Card(new As,new Spades))
    hand.addCard(new Card(new As,new Spades))
    hand.addCard(new Card(new As,new Spades))
    hand.addCard(new Card(new As,new Spades))
    hand.addCard(new Card(new As,new Spades))
    intercept[MaxCardsSizeException](hand.addCard(new Card(new As,new Spades)))
  }
  test("removeCard should throw a exception"){
    hand.addCard(new Card(new Two,new Spades))
    intercept[RemoveIllegalIndexCard](hand.removeCard(1))
  }
  test("playHand should throw a exception"){
    intercept[MinPlayCardsException](hand.playHand(listI))
  }
  test("playHand should throw a exception"){
    hand.addCard(new Card(new As, new Spades))
    hand.addCard(new Card(new As, new Spades))
    hand.addCard(new Card(new As, new Spades))
    hand.addCard(new Card(new As, new Spades))
    hand.addCard(new Card(new As, new Spades))
    hand.addCard(new Card(new As, new Spades))
    hand.addCard(new Card(new As, new Spades))
    hand.addCard(new Card(new As, new Spades))
    listI= ArrayBuffer[Int](1,2,3,4,5,6)
    intercept[MaxPlayCardsException](hand.playHand(listI))
  }
  test("playHand should throw a exception"){
    hand.addCard(new Card(new As, new Spades))
    hand.addCard(new Card(new As, new Spades))
    hand.addCard(new Card(new As, new Spades))
    hand.addCard(new Card(new As, new Spades))
    listI=ArrayBuffer[Int](1)
    hand.playHand(listI)
    hand.playHand(listI)
    hand.playHand(listI)
    intercept[MaxTimesOfPlayHand](hand.playHand(listI))
  }
  test("playHand should throw a exception"){
    hand.addCard(new Card(new As, new Spades))
    listI=ArrayBuffer[Int](2)
    intercept[PlayIllegalIndexHand](hand.playHand(listI))
  }

  test("discardCard should throw a exception"){
    hand.addCard(new Card(new As, new Spades))
    listI=ArrayBuffer[Int]()
    listC_2=ArrayBuffer[Card](new Card(new As, new Spades))
    intercept[MinNumberOfDiscardCards](hand.discardCards(listI,listC_2))
  }
  test("discardCard should throw a exception"){
    hand.addCard(new Card(new As, new Spades))
    hand.addCard(new Card(new As, new Spades))
    hand.addCard(new Card(new As, new Spades))
    hand.addCard(new Card(new As, new Spades))
    hand.addCard(new Card(new As, new Spades))
    hand.addCard(new Card(new As, new Spades))
    hand.addCard(new Card(new As, new Spades))
    hand.addCard(new Card(new As, new Spades))
    listI=ArrayBuffer[Int](1,2,3,4,5,6)
    listC_2=ArrayBuffer[Card](new Card(new As, new Spades))
    intercept[MaxNumberOfDiscardCards](hand.discardCards(listI,listC_2))
  }



}