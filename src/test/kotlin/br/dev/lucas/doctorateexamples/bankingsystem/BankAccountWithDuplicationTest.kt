package br.dev.lucas.doctorateexamples.bankingsystem

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BankAccountWithDuplicationTest {

  @Test
  fun `should withdraw from account`() {
    val bankingSystem = BankingSystem()
    val unitedStatesMint = bankingSystem.createMint(Currency.USD)
    val bankOfAmerica = bankingSystem.createBank("Bank of America")
    val janeAccount = bankOfAmerica.createAccount("Jane Doe")
    val tenDollars = unitedStatesMint.issue(10)
    janeAccount.deposit(tenDollars)
    val withdrawTransaction = janeAccount.withdraw(tenDollars)
    assertTrue(withdrawTransaction.isSuccess)
    assertTrue(janeAccount.balance.isZero)
  }

  @Test
  fun `should not allow to close an account with positive balance`() {
    val bankingSystem = BankingSystem()
    val unitedStatesMint = bankingSystem.createMint(Currency.USD)
    val bankOfAmerica = bankingSystem.createBank("Bank of America")
    val janeAccount = bankOfAmerica.createAccount("Jane Doe")
    val tenDollars = unitedStatesMint.issue(10)
    janeAccount.deposit(tenDollars)
    val closeTransaction = janeAccount.close()
    assertFalse(closeTransaction.isSuccess)
    assertFalse(janeAccount.isClosed)
    assertEquals(tenDollars, janeAccount.balance)
  }

  @Test
  fun `should not allow to withdraw more than balance`() {
    val bankingSystem = BankingSystem()
    val unitedStatesMint = bankingSystem.createMint(Currency.USD)
    val bankOfAmerica = bankingSystem.createBank("Bank of America")
    val janeAccount = bankOfAmerica.createAccount("Jane Doe")
    val tenDollars = unitedStatesMint.issue(10)
    val withdrawTransaction = janeAccount.withdraw(tenDollars)
    assertFalse(withdrawTransaction.isSuccess)
    assertEquals(tenDollars, janeAccount.balance)
  }

  @Test
  fun `should close account`() {
    val bankingSystem = BankingSystem()
    val bankOfAmerica = bankingSystem.createBank("Bank of America")
    val janeAccount = bankOfAmerica.createAccount("Jane Doe")
    val closeTransaction = janeAccount.close()
    assertTrue(closeTransaction.isSuccess)
    assertTrue(janeAccount.isClosed)
    assertTrue(janeAccount.balance.isZero)
  }
}
