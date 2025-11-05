package model
import Scores.Score
import Suits.{Clubs, Diamonds, Hearts, Spades}
import Ranks.{As, Eight, Five, Four, Jack, King, Nine, Queen, Rank, Seven, Six, Ten, Three, Two}
import munit.FunSuite

import scala.collection.mutable.ArrayBuffer
import Jokers.IJoker
import Jokers.{Devious_Joker, Even_Steven, GreedyJoker, Scary_Face}
import Cards.Card
import Hands.Hand
import combinations.AbstractCombinations
import combinations.Straight
class applyScoreTest extends FunSuite{
  var KingS: King=_
  var KingS_1: Card=_
  var Score1: Score=_
  var Score2: Score=_
  var Score3: Score=_
  var Score4: Score=_
  var esJoker:Scary_Face=_
  var QueenD:  Card= _
  var JackH:Card=_
  var TenS:Card=_
  var NineD:Card=_
  var hand:Hand=_
  var comb:AbstractCombinations=_
  var list:ArrayBuffer[Card]=_
  var listJ:ArrayBuffer[IJoker]=_
  var devious:Devious_Joker=_
  var diamond:Diamonds=_
  var greedy:GreedyJoker=_
  var two:Rank=_
  var even:IJoker=_
  var listJ_2:ArrayBuffer[IJoker]=_
  var eightD:Card=_
  override def beforeEach(context:BeforeEach): Unit = {
    KingS= new King()
    two= new Two()
    eightD= new Card(new Eight,new Diamonds)
    diamond=new Diamonds()
    KingS_1 = new Card(new King,new Spades)
    Score1= new Score(0,0)
    Score3= new Score(0,0)
    Score4=new Score(0,0)
    QueenD= new Card(new Queen,new Diamonds)
    JackH = new Card(new Jack,new Hearts)
    TenS = new Card(new Ten, new Spades)
    NineD = new Card(new Nine,new Diamonds)
    esJoker= new Scary_Face()
    devious= new Devious_Joker
    Score2= new Score(0,0)
    list=ArrayBuffer[Card](NineD,TenS,JackH,QueenD,KingS_1)
    listJ=ArrayBuffer[IJoker](devious)
    hand= new Hand(list,listJ)
    comb=new Straight(list,hand)
    greedy=new GreedyJoker()
    even=new Even_Steven()
    listJ_2=ArrayBuffer[IJoker](greedy,esJoker)
  }
  test("check scary"){
    KingS.applyScore(Score1,esJoker)
    val a:Int=Score1.chips
    assertEquals(a,30)
  }
  test("check devious"){
    comb.applyScore(Score2,devious)
    val b:Int=Score2.chips
    assertEquals(b,100)
  }
  test("check greedy"){
    diamond.applyScore(Score3,greedy)
    val c:Int= Score3.mult
    assertEquals(c,3)
  }
  
  test("check even"){
    two.applyScore(Score4,even)
    val d:Int= Score4.mult
    assertEquals(d,4)
  }
  test("check card"){
    QueenD.applyScore(Score4,listJ_2)
    val f:Int=Score4.chips
    val g:Int=Score4.mult
    assertEquals(f,30)
    assertEquals(g,3)
  }
}
