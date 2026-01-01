package br.dev.lucas.doctorateexamples.bankingsystem

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


class BankAccountTest {
  private lateinit var janeAccount: BankAccount
  private lateinit var tenDollars: Money

  @BeforeEach
  fun setup() {
    val bankingSystem = BankingSystem()
    val unitedStatesMint = bankingSystem.createMint(Currency.USD)
    val bankOfAmerica = bankingSystem.createBank("Bank of America")
    janeAccount = bankOfAmerica.createAccount("Jane Doe")
    tenDollars = unitedStatesMint.issue(10)
    janeAccount.deposit(tenDollars)
  }

  @Test
  fun `should withdraw from account`() {
    val withdrawTransaction = janeAccount.withdraw(tenDollars)
    assertTrue(withdrawTransaction.isSuccess)
    assertTrue(janeAccount.balance.isZero)
  }

  @Test
  fun `should not allow to close an account with positive balance`() {
    val closeTransaction = janeAccount.close()
    assertFalse(closeTransaction.isSuccess)
    assertFalse(janeAccount.isClosed)
    assertEquals(tenDollars, janeAccount.balance)
  }

  @Test
  fun `should not allow to withdraw more than balance`() {
    val withdrawTransaction = janeAccount.withdraw(tenDollars)
    assertFalse(withdrawTransaction.isSuccess)
    assertEquals(tenDollars, janeAccount.balance)
  }

  @Test
  fun `should close account`() {
    val closeTransaction = janeAccount.close()
    assertTrue(closeTransaction.isSuccess)
    assertTrue(janeAccount.isClosed)
    assertTrue(janeAccount.balance.isZero)
  }
}
