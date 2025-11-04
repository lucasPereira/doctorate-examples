package br.dev.lucas.exemplosdoutorado.sistemabancario

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TesteSacarDeChequeEspecial {
  @Test
  fun sacarDeChequeEspecial() {
    val casaDaMoeda = CasaDaMoeda(Moeda.BRL)
    val sistemaBancario = SistemaBancario()
    val bb = sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL)
    val trindade = bb.criarAgencia("Trindade")
    val maria = trindade.criarConta("Maria", "000.000.000-00")
    val dezReais = casaDaMoeda.emitir(10)
    maria.fixarLimiteDeChequeEspecial(dezReais)
    val cincoReais = casaDaMoeda.emitir(5)
    val saque = maria.sacar(cincoReais)
    assertTrue(saque.sucesso())
    assertEquals(casaDaMoeda.zero(), maria.calcularSaldo())
    assertEquals(cincoReais, maria.calcularSaldoDeChequeEspecial())
  }
}
