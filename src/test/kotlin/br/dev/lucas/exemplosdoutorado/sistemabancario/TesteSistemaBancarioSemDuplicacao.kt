package br.dev.lucas.exemplosdoutorado.sistemabancario

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TesteSistemaBancarioSemDuplicacao {
  private lateinit var casaDaMoeda: CasaDaMoeda
  private lateinit var cincoReais: Dinheiro
  private lateinit var maria: Conta

  @BeforeEach
  fun configurar() {
    casaDaMoeda = CasaDaMoeda(Moeda.BRL)
    val sistemaBancario = SistemaBancario()
    val bb = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL)
    val trindade = bb.criarAgencia("Trindade")
    maria = trindade.criarConta("Maria", "000.000.000-00")
    cincoReais = casaDaMoeda.emitir(5)
    maria.depositar(cincoReais)
  }

  @Test
  fun sacarValorDoSaldo() {
    val saque = maria.sacar(cincoReais)
    assertTrue(saque.sucesso())
    assertEquals(casaDaMoeda.zero(), maria.calcularSaldo())
  }

  @Test
  fun sacarMaisQueOSaldo() {
    val dezReais = casaDaMoeda.emitir(10)
    val saque = maria.sacar(dezReais)
    assertFalse(saque.sucesso())
    assertEquals(cincoReais, maria.calcularSaldo())
  }
}
