package br.dev.lucas.doctorateexamples.bankingsystem.rozarefactoring;

import br.dev.lucas.doctorateexamples.bankingsystem.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RefactoredBankAccount2Test {
  private BankAccount janeAccount;
  private Money tenDollars;

  @BeforeEach
  public void setup() {
    BankingSystem bankingSystem = new BankingSystem();
    Mint unitedStatesMint = bankingSystem.createMint(Currency.USD);
    Bank bankOfAmerica = bankingSystem.createBank("Bank of America");
    janeAccount = bankOfAmerica.createAccount("Jane Doe");
    tenDollars = unitedStatesMint.issue(10);
  }

  @Test
  public void shouldNotAllowToCloseAnAccountWithPositiveBalance() {
    janeAccount.deposit(tenDollars);
    Transaction closeTransaction = janeAccount.close();
    assertFalse(closeTransaction.isSuccess());
    assertFalse(janeAccount.isClosed());
    assertEquals(tenDollars, janeAccount.getBalance());
  }

  @Test
  public void shouldNotAllowToWithdrawMoreThanBalance() {
    Transaction withdrawTransaction = janeAccount.withdraw(tenDollars);
    assertFalse(withdrawTransaction.isSuccess());
    assertEquals(tenDollars, janeAccount.getBalance());
  }

  @Test
  public void shouldWithdrawFromAccount() {
    janeAccount.deposit(tenDollars);
    Transaction withdrawTransaction = janeAccount.withdraw(tenDollars);
    assertTrue(withdrawTransaction.isSuccess());
    assertTrue(janeAccount.getBalance().isZero());
  }
}
