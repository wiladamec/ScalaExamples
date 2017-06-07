package com.wiladamec.scalaexamples.caseclass

case class Person(firstName: String,
                  lastName: String,
                  age: Int,
                  occupation: Option[String]) {

  /**
    * Inside the case class itself, define methods that depend
    * on the members of `this`.
    */

  def fullName: String = s"${this.firstName} ${this.lastName}"

  def isEmployed: Boolean = this.occupation.isDefined

  override def toString: String = {
    val occupationString = this.occupation.map { o => s"Their occupation is listed as $o." }.getOrElse("")

    s"${this.fullName} is ${this.age} years old. $occupationString"
  }
}

object Person {

  /**
    * The companion object of the Person case class is also
    * called Person and is located _in the same file_ as the
    * Person case class.
    */

  /**
    * We can specify additional apply() methods in the
    * companion object to act as additional constructors.
    */
  def apply(csvString: String): Person = {
    val Array(firstName, lastName, age, occupation) = csvString.split(",", 4)

    Person(firstName, lastName, age.toInt, Option(occupation))
  }

  /**
    * We can define values that pertain to all instances of
    * class Person.
    */
  val species: String = "human"

  /**
    * We can also define methods that would be considered
    * static methods in Java.
    */
  def ageFromBirthYear(birthYear: Int): Int = {
    val thisYear = java.time.LocalDate.now.getYear

    thisYear - birthYear
  }
}