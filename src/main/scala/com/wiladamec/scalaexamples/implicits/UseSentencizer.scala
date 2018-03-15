package com.wiladamec.scalaexamples.implicits

object UseSentencizer {

  // This method accepts an explicit parameter 'words' and an implicit parameter of
  // type Sentencizer. Notice how the implicit argument is separated from the others.
  def makeSentences(words: Seq[String])
                   (implicit sentencizer: Sentencizer): Seq[String] = {
    words.map(sentencizer.makeSentence)
  }

  // This method accepts an implicit Sentencizer. The Sentencizer passed to this
  // method is also passed into the makeSentences() call inside.
  def makeParagraph(words: Seq[String])
                   (implicit sentencizer: Sentencizer): String = {
    makeSentences(words).mkString(" ")
  }

  def main(args: Array[String]): Unit = {

    // Here we instantiate an implicit NormalSentencizer using the implicit modifier.
    implicit val mySentencizer = new NormalSentencizer

    val words = List("ball", "tree", "cat", "raccoon")

    // If we don't specify a Sentencizer, our implicit mySentencizer is used.
    // It will be used in all calls where an implicit Sentencizer is needed.
    val normalSentences = makeSentences(words)
    val paragraph = makeParagraph(words)

    // We can also explicity specify a Sentencizer if we choose to. Having two
    // implicit vals of the same type (Sentencizer) in the same scope causes
    // ambiguity, so sometime's it's necessary to be explicit.
    val loudSentences = makeSentences(words)(new ExcitedSentencizer)

    normalSentences.foreach(println)
    println("")
    println(paragraph)
    println("")
    loudSentences.foreach(println)
  }
}