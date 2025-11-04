package br.dev.lucas.exemplosdoutorado.calculadora

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TesteCalculadoraComAcessorioTransienteParticular {
  @Test
  fun somarInteirosPositivos() {
    val calculadora = Calculadora()
    val resultado = calculadora.somar(1, 2)
    assertEquals(3, resultado)
  }

  @Test
  fun somarInteiroPositivoComNegativo() {
    val calculadora = Calculadora()
    val resultado = calculadora.somar(1, -2)
    assertEquals(-1, resultado)
  }
}
