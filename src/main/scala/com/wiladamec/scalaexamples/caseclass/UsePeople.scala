package com.wiladamec.scalaexamples.caseclass

object UsePeople {

  def main(args: Array[String]): Unit = {

    val people = List(
      Person("Alex", "Gunter", 22, Option("Student")),
      Person("Wil", "Adamec", 24, Option("Developer")),
      Person("Alex", "Guarnaschelli", 44, Option("Chef")),
      Person("Ian", "Gunter", 20, Option.empty[String])
    )

    // Print out a description of each person.
    people.foreach(println)

    println("")

    // We can pattern match to find out whose last name is Gunter.
    people.foreach {
      case Person(firstName, "Gunter", _, _) => println(s"$firstName Gunter has the last name Gunter.")
      case Person(firstName, lastName, _, _) => println(s"$firstName $lastName has a different last name.")
    }
  }
}