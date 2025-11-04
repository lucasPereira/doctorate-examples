package br.dev.lucas.exemplosdoutorado.sistemabancario

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TesteCriarBancoComConfiguracaoLocal {
  @Test
  fun criarBanco() {
    val sistemaBancario = SistemaBancario()
    val bb = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL)
    assertEquals("Banco do Brasil", bb.obterNome())
    assertEquals(Moeda.BRL, bb.obterMoeda())
  }
}
