package br.dev.lucas.exemplosdoutorado.sistemabancario

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TesteCriarBancoComConfiguracaoImplicita {
  private lateinit var bb: Banco

  @BeforeEach
  fun configurar() {
    val sistemaBancario = SistemaBancario()
    bb = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL)
  }

  @Test
  fun criarBanco() {
    assertEquals("Banco do Brasil", bb.obterNome())
    assertEquals(Moeda.BRL, bb.obterMoeda())
  }
}
