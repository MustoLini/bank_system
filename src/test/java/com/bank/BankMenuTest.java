package com.bank;

import com.bank.service.BankService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.mockito.junit.MockitoJUnitRunner;

import java.util.Scanner;


import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class BankMenuTest {

    BankService bankService;
    BankAccount bankAccount;
    BankMenu bankMenu;

    @Test
    void testWithdrawMenu() {
        bankService = mock(BankService.class);
        bankAccount = new BankAccount("Dummy", "123");
        Scanner sc = mock(Scanner.class);
        bankMenu = new BankMenu(bankService, bankAccount, sc);
        double amountWithdraw = 2000.0;
        when(sc.next()).thenReturn("c", "e");
        when(sc.nextDouble()).thenReturn(2000.0);
        bankMenu.menu();
        verify(bankService, atLeast(1)).withdraw(bankAccount, amountWithdraw);
    }
}