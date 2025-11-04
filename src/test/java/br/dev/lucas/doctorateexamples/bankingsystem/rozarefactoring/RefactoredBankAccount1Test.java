package br.dev.lucas.doctorateexamples.bankingsystem.rozarefactoring;

import br.dev.lucas.doctorateexamples.bankingsystem.Bank;
import br.dev.lucas.doctorateexamples.bankingsystem.BankAccount;
import br.dev.lucas.doctorateexamples.bankingsystem.BankingSystem;
import br.dev.lucas.doctorateexamples.bankingsystem.Transaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RefactoredBankAccount1Test {
  @Test
  public void shouldCloseAccount() {
    BankingSystem bankingSystem = new BankingSystem();
    Bank bankOfAmerica = bankingSystem.createBank("Bank of America");
    BankAccount janeAccount = bankOfAmerica.createAccount("Jane Doe");
    Transaction closeTransaction = janeAccount.close();
    assertTrue(closeTransaction.isSuccess());
    assertTrue(janeAccount.isClosed());
    assertTrue(janeAccount.getBalance().isZero());
  }
}
