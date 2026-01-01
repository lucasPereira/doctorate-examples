package br.dev.lucas.doctorateexamples.university

import br.dev.lucas.br.dev.lucas.br.dev.lucas.doctorateexamples.university.Student
import br.dev.lucas.br.dev.lucas.doctorateexamples.university.Course
import br.dev.lucas.br.dev.lucas.doctorateexamples.university.University
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UniversityTest {
  private lateinit var algorithms: Course
  private lateinit var alice: Student

  @BeforeEach
  fun setUp() {
    val mit = University("MIT")
    alice = mit.admit("Alice")
    val bob = mit.hire("Bob")
    val cs = mit.createProgram("Computer Science")
    algorithms = cs.createCourse("Algorithms", bob)
    algorithms.enroll(alice)
  }

  @Test
  fun `should not enroll student twice`() {
    val success = algorithms.enroll(alice)

    assertFalse(success)
    assertEquals(listOf(alice), algorithms.students)
  }

  @Test
  fun `should cancel student enrollment`() {
    algorithms.enroll(alice)

    val success = algorithms.cancelEnrollment(alice)

    assertTrue(success)
    assertTrue(algorithms.students.isEmpty())
  }
}
