package br.dev.lucas.exemplosdoutorado.sistemabancario

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TesteSistemaBancarioComDuplicacao {
  @Test
  fun sacarValorDoSaldo() {
    val casaDaMoeda = CasaDaMoeda(Moeda.BRL)
    val sistemaBancario = SistemaBancario()
    val bb = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL)
    val trindade = bb.criarAgencia("Trindade")
    val maria = trindade.criarConta("Maria", "000.000.000-00")
    val cincoReais = casaDaMoeda.emitir(5)
    maria.depositar(cincoReais)
    val saque = maria.sacar(cincoReais)
    assertTrue(saque.sucesso())
    assertEquals(casaDaMoeda.zero(), maria.calcularSaldo())
  }

  @Test
  fun sacarMaisQueOSaldo() {
    val casaDaMoeda = CasaDaMoeda(Moeda.BRL)
    val sistemaBancario = SistemaBancario()
    val bb = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL)
    val trindade = bb.criarAgencia("Trindade")
    val maria = trindade.criarConta("Maria", "000.000.000-00")
    val cincoReais = casaDaMoeda.emitir(5)
    maria.depositar(cincoReais)
    val dezReais = casaDaMoeda.emitir(10)
    val saque = maria.sacar(dezReais)
    assertFalse(saque.sucesso())
    assertEquals(cincoReais, maria.calcularSaldo())
  }
}
