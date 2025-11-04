package br.dev.lucas.exemplosdoutorado.sistemabancario

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TesteCriarBancoComConfiguracaoDelegada {
  @Test
  fun criarBanco() {
    val bb = Auxiliar.criarBancoDoBrasil()
    assertEquals("Banco do Brasil", bb.obterNome())
    assertEquals(Moeda.BRL, bb.obterMoeda())
  }

  /** Em Kotlin um singleton pode ser construído por uma
  sintaxe especial usando palavra reservada object. */
  object Auxiliar {
    fun criarBancoDoBrasil(): Banco {
      val sistemaBancario = SistemaBancario()
      return sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL)
    }
  }
}
