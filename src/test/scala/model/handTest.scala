package model

import Cards.Card
import Hands.Hand
import Suits.{Hearts,Clubs,Spades,Diamonds}
import Ranks.{As,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten,Jack,Queen,King}
import munit.FunSuite
import scala.collection.mutable.ArrayBuffer
import Jokers.IJoker
import Jokers.{Devious_Joker,Even_Steven,GreedyJoker,Scary_Face}

class handTest extends FunSuite {
  var AsP: Card = _
  var ThreeP: Card = _
  var TwoP: Card = _
  var tenD: Card = _
  var twoD: Card = _
  var carts: ArrayBuffer[Card] = _
  var hand: Hand = _
  var jokers: ArrayBuffer[IJoker] = _
  var FourP: Card= _
  var FiveP: Card= _
  var tenP:Card= _
  var AsH: Card=_
  var FiveH: Card=_
  var QueenC: Card=_
  var KingC: Card=_
  var NineH:Card=_
  var JackC:Card=_
  var EightD:Card=_
  var SevenH: Card=_
  var jokerGreedy: IJoker=_
  var jokerScary: IJoker=_
  var jokerSteven: IJoker=_
  var jokerDevious: IJoker=_
  var SixD: Card=_

  // initial setup
  override def beforeEach(context: BeforeEach): Unit = {
    AsP = new Card(new As, new Spades)
    ThreeP = new Card(new Three, new Spades)
    TwoP = new Card(new Two, new Spades)
    tenD = new Card(new Ten, new Diamonds)
    twoD = new Card(new Two, new Diamonds)
    FourP= new Card(new Four, new Spades)
    FiveP = new Card(new Five, new Spades)
    tenP = new Card(new Ten, new Spades)
    AsH = new Card(new As,new Hearts)
    FiveH = new Card(new Five, new Hearts)
    QueenC= new Card(new Queen, new Clubs)
    KingC = new Card(new King, new Clubs)
    NineH = new Card(new Nine, new Hearts)
    JackC = new Card(new Jack, new Clubs)
    EightD= new Card(new Eight, new Diamonds)
    SevenH= new Card(new Seven, new Hearts)
    SixD= new Card(new Six,new Diamonds)
    jokerGreedy= new GreedyJoker()
    jokerSteven= new Even_Steven()
    jokerDevious= new Devious_Joker()
    jokerScary= new Scary_Face()
    carts = ArrayBuffer[Card]()
    jokers= ArrayBuffer[IJoker]()

  }

  test("Check a pair") {
    carts += AsP
    carts += TwoP
    carts += tenD
    carts += twoD
    carts += ThreeP
    hand = new Hand(carts,jokers)

    assertEquals(hand.check(carts), "The highest hand its a Pair of 2")
  }

  test("Check dos pares") {
    carts += ThreeP
    carts += TwoP
    carts += TwoP
    carts += tenD
    carts += ThreeP
    hand = new Hand(carts,jokers)

    assertEquals(hand.check(carts), "Two Pairs of 2 and 3")
  }

  test("Check un trío") {
    carts += AsP
    carts += AsP
    carts += AsP
    carts += tenD
    carts += ThreeP
    hand = new Hand(carts,jokers)

    assertEquals(hand.check(carts), "The highest hand its a Three of Kind of 1")
  }

  test("Check full house") {
    carts += AsP
    carts += AsP
    carts += AsP
    carts += twoD
    carts += twoD
    hand = new Hand(carts,jokers)

    assertEquals(hand.check(carts), "Full house of 1 and 2")
  }
  test("Check a straight flush"){
    carts+= AsP
    carts += ThreeP
    carts+=TwoP
    carts+= FourP
    carts+= FiveP
    hand = new Hand(carts,jokers)
    assertEquals(hand.check(carts),"The highest hand its a Straight Flush")
  }
  test("Check a straight"){
    carts+=AsP
    carts+=ThreeP
    carts+=twoD
    carts+=FourP
    carts+=FiveP
    hand=new Hand(carts,jokers)
    assertEquals(hand.check(carts),"The highest hand its a Straight")
  }
  test("Check a flush"){
    carts+=AsP
    carts+=ThreeP
    carts+=tenP
    carts+=FiveP
    carts+=FourP
    hand=new Hand(carts,jokers)
    assertEquals(hand.check(carts),"The highest hand its a Flush")
  }
  test("Check a poker"){
    carts+=AsP
    carts+=AsP
    carts+=AsP
    carts+=AsP
    carts+=ThreeP
    hand=new Hand(carts, jokers)
    assertEquals(hand.check(carts),"The highest hand its a Poker of 1")
  }
  test("Check a High Card"){
    carts+=AsP
    carts+=tenP
    carts+=twoD
    carts+=FourP
    carts+=ThreeP
    hand=new Hand(carts,jokers)
    assertEquals(hand.check(carts),"The highest hand its a High Card")
  }
  test("Add a Joker"){
    hand=new Hand(carts,jokers)
    hand.addJoker(jokerGreedy)
    hand.addJoker(jokerScary)
    val jokers_2= ArrayBuffer[IJoker](jokerGreedy,jokerScary)
    assertEquals(jokers,jokers_2)
  }
  test("Remove Jokers"){
    hand=new Hand(carts,jokers)
    hand.addJoker(jokerSteven)
    val jokers_2=ArrayBuffer[IJoker]()
    hand.removeJoker(0)
    assertEquals(jokers,jokers_2)
  }
  test("Add Cards"){
    hand=new Hand(carts,jokers)
    hand.addCard(QueenC)
    hand.addCard(KingC)
    val carts_2=ArrayBuffer[Card](QueenC,KingC)
    assertEquals(carts,carts_2)

  }
  test("remove Cards"){
     hand=new Hand(carts,jokers)
     hand.addCard(SevenH)
     val carts_2=ArrayBuffer[Card]()
     hand.removeCard(0)
     assertEquals(carts,carts_2)
  }
  test("play hand"){
    hand=new Hand(carts, jokers)
    hand.addCard(EightD)
    hand.addCard(AsH)
    hand.addCard(KingC)
    hand.addCard(SixD)
    hand.addCard(KingC)
    var handPlay= hand.playHand(ArrayBuffer(0,1,2,3,4))
    val hand1=ArrayBuffer[Card]()
    assertEquals(carts,hand1)
  }
}
