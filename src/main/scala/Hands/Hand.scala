package Hands

import FlushCheck._
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import Cards.Card
import Jokers.IJoker
import Order._
import StraightFunctions._
import Exceptions._
/**
 * The class represents a hand. The Hand have a list of Cards and a list of Jokers.
 * @param cards We use the list of hands for check the type of hand to play
 * @param jokers We use a list of jokers to calculate the method playHand and the score
 * This class has a method to play Hand and remove cards and add cards of the list
 * And have the method of remove Jokers(depends on the index) and add Jokers of the joker List
 */

class Hand (cards:ArrayBuffer[Card], jokers:ArrayBuffer[IJoker]){
 
  private var counterPlayHand: Int = 0
  private var counterDiscard: Int = 0
  private val stringList: ArrayBuffer[String] = ArrayBuffer[String]()
  private val straightCheck: ArrayBuffer[Int] = ArrayBuffer[Int]()
  private val counter: mutable.Map[Int, Int] = mutable.Map()
  private val counter2: mutable.Map[String, Int] = mutable.Map()

  def check(hand: ArrayBuffer[Card]): String = {
    val emptyHand = ArrayBuffer[Card]()
    if (hand == emptyHand) {
      return "The hand its empty"
    }

    //this "for" add features of the hand
    for (card <- hand) {
      stringList += card.pint.toString // we add a method to compare if the hand have a flush
      straightCheck += card.rank.order //we add the order in a list to compare if the hand have a straight
      if (counter.contains(card.rank.order)) {
        counter(card.rank.order) += 1 // if exists , add 1
      } else {
        counter(card.rank.order) = 1 // If not exists, it's added with valor 1
      }
    }
    //we got the card with more repeats
    val (maxRank, count) = counter.maxBy(_._2)
    //we remove it to renew the process
    counter.remove(maxRank)
    //with this info, we make the revision
    val (secondMax, secondCount) = counter.maxBy(_._2)
    sortArrayBuffer(straightCheck) //function to sort the list with the orders of a cards
    if (checkFlush(stringList) && checkOrder(straightCheck)) {
      "The highest hand its a Straight Flush"
    }
    else if (count == 4) {
      f"The highest hand its a Poker of $maxRank"
    }
    else if (count == 2 && secondCount == 2) {
      f"Two Pairs of $maxRank and $secondMax"
    }
    else if ((secondCount == 2 && count == 3) || (secondCount == 3 && count == 2)) {
      f"Full house of $maxRank and $secondMax"
    }
    else if (checkFlush(stringList)) {
      "The highest hand its a Flush"
    }
    else if (checkOrder(straightCheck)) {
      "The highest hand its a Straight"
    }
    else if (count == 3) {
      f"The highest hand its a Three of Kind of $maxRank"
    }
    else if (count == 2) {
      f"The highest hand its a Pair of $maxRank"
    }
    else {
      "The highest hand its a High Card"
    }
  }
  //we add a card to the hand
  def addCard(card:Card): Unit = {
    if (cards.size>=8) {
      throw new MaxCardsSizeException("You cant have more than 8 cards")
    }
    cards+=card
  }
//we remove a card to the hand
  def removeCard(n:Int): Unit = {
      if (n>(cards.length-1)){
        throw new RemoveIllegalIndexCard()
      }
      val element = cards(n)
      cards -= element
  }
//we add a joker to the joker list
  def addJoker(joker:IJoker) : Unit ={
    if (jokers.length>2) {
       throw new MaxJokersSizeExceptions()

    }
    jokers+=joker
  }
//we remove a joker to the joker list, we need a index to remove it
  def removeJoker(n:Int) : Unit ={
      val len = cards.length -1
      if (n>len){
        throw new RemoveIllegalIndexJoker()
      }
      val element_2 = jokers(n)
      jokers-= element_2
  }

//method to play a hand,
  def playHand(list:ArrayBuffer[Int]) : ArrayBuffer[Card]={
    if (list.isEmpty) {
      throw new MinPlayCardsException()
    }
    sortArrayBuffer(list)
    val ult = list(list.length - 1)
    if (counterPlayHand==3){
      throw new MaxTimesOfPlayHand()
    }
    else if (list.length >5){
      throw new MaxPlayCardsException()
    }
    else if (ult>cards.length){
      throw new PlayIllegalIndexHand()
    }
    else {
      val b = ArrayBuffer[Card]()
      for (i <- list) {
        val c = cards(i)
        b += c
      }
      for (i <- list.sorted(Ordering[Int].reverse)) {
        cards.remove(i)
      }
      counterPlayHand += 1
      b
    }
  }
  def discardCards(indexList:ArrayBuffer[Int],cards_2:ArrayBuffer[Card]): ArrayBuffer[Card] ={
    if (indexList.isEmpty) {
      throw new MinNumberOfDiscardCards()
    }
    sortArrayBuffer(indexList)
    val ult_2=indexList(indexList.length-1)
    if (counterDiscard==3){
      throw new MaxTimesOfDiscardCard()
    }
    else if (ult_2>cards.length){
      throw new IllegalDiscardIndex()
    }
    else if (indexList.length>=5) {
      throw new MaxNumberOfDiscardCards()
    }
    else if (indexList.length<1){
      throw new MinNumberOfDiscardCards()
    }
    else {
      for (i <- indexList.sorted(Ordering[Int].reverse)) {
        cards.remove(i)
      }
      for (card <- cards_2) {
        addCard(card)
      }
      counterDiscard += 1
      cards
    }
  }

}
