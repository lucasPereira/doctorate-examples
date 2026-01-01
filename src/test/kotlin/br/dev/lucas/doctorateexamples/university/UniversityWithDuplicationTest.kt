package br.dev.lucas.doctorateexamples.university

import br.dev.lucas.br.dev.lucas.doctorateexamples.university.University
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class UniversityWithDuplicationTest {
@Test
fun `should not enroll student twice`() {
  val mit = University("MIT")
  val alice = mit.admit("Alice")
  val bob = mit.hire("Bob")
  val cs = mit.createProgram("Computer Science")
  val algorithms = cs.createCourse("Algorithms", bob)
  algorithms.enroll(alice)

  val success = algorithms.enroll(alice)

  assertFalse(success)
  assertEquals(listOf(alice), algorithms.students)
}

@Test
fun `should cancel student enrollment`() {
  val mit = University("MIT")
  val alice = mit.admit("Alice")
  val bob = mit.hire("Bob")
  val cs = mit.createProgram("Computer Science")
  val algorithms = cs.createCourse("Algorithms", bob)
  algorithms.enroll(alice)

  val success = algorithms.cancelEnrollment(alice)

  assertTrue(success)
  assertTrue(algorithms.students.isEmpty())
}

@Test
fun `should not enroll student in a closed course`() {
  val mit = University("MIT")
  val alice = mit.admit("Alice")
  val bob = mit.hire("Bob")
  val cs = mit.createProgram("Computer Science")
  val algorithms = cs.createCourse("Algorithms", bob)
  algorithms.close()

  val success = algorithms.enroll(alice)

  assertFalse(success)
  assertTrue(algorithms.students.isEmpty())
}

}
