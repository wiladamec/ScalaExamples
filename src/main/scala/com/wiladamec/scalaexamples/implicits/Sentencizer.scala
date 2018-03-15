package com.wiladamec.scalaexamples.implicits

/**
  * This file declares a base trait and some implementations.
  * It's not very exciting, unfortunately.
  */

trait Sentencizer {
  def makeSentence(word: String): String
}

class NormalSentencizer extends Sentencizer {

  def makeSentence(word: String): String = {
    s"This is a normal sentence containing $word."
  }
}

class ExcitedSentencizer extends Sentencizer {

  def makeSentence(word: String): String = {
    s"THIS IS A VERY EXCITED SENTENCE CONTAINING ${word.toUpperCase}!!!"
  }
}