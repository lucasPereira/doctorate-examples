package br.dev.lucas.exemplosdoutorado.calculadora

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TesteCalculadoraComAcessorioPersistenteColetivo {
  companion object {
    @JvmStatic
    private val calculadora = Calculadora()
  }

  @Test
  fun somarInteirosPositivos() {
    val resultado = calculadora.somar(1, 2)
    assertEquals(3, resultado)
  }

  @Test
  fun somarInteiroPositivoComNegativo() {
    val resultado = calculadora.somar(1, -2)
    assertEquals(-1, resultado)
  }
}
