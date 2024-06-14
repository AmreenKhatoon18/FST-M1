package com.ibm.fst_m1_jnuint_01;

import org.junit.jupiter.api.Test;
//import activityPrograms.BankAccount;
//import activityPrograms.NotEnoughFundsException;
import static org.junit.jupiter.api.Assertions.*;

public class Activity2 {
@Test
void notEnoughFunds()
{
	BankAccount account = new BankAccount(9);
	assertThrows(NotEnoughFundsException.class, () -> account.withdraw(10));
}
@Test
void enoughFunds() {
    // Create an object for BankAccount class
    BankAccount account = new BankAccount(100);
 
    // Assertion for no exceptions
    assertDoesNotThrow(() -> account.withdraw(100));
}
}
