package br.dev.lucas.exemplosdoutorado.usuario

import br.dev.lucas.br.dev.lucas.exemplosdoutorado.usuario.Usuario
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class TesteCriarUsuario {
  @Test
  fun criarUsuario() {
    val joao = Usuario()
    joao.fixarNome("João da Silva")
    joao.fixarProfissao("Programador")
    assertNull(joao.obterIdentificador())
    assertEquals("João da Silva", joao.obterNome())
    assertEquals("Programador", joao.obterProfissao())
  }
}
