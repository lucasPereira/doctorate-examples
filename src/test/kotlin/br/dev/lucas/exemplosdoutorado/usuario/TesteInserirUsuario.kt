package br.dev.lucas.exemplosdoutorado.usuario

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TesteInserirUsuario {
  @Test
  fun inserirUsuario() {
    val joao = Usuario()
    joao.fixarNome("João da Silva")
    joao.fixarProfissao("Programador")
    val repositorioDeUsuario = RepositorioDeUsuario()
    val identificador = repositorioDeUsuario.inserir(joao)
    assertEquals(identificador, joao.obterIdentificador())
  }
}
