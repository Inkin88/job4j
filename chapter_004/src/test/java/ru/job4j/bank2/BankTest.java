package ru.job4j.bank2;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;


public class BankTest {
    Bank bank;
    User user1 = new User("Airat", "123456");
    User user2 = new User("Marat", "654321");
    List<Account> accounts;

    @Before
    public void addSomeUsers() {
        bank = new Bank();
        accounts = new ArrayList<>();
        bank.addUser(user1);
        bank.addUser(user2);
        accounts.add(new Account(150, "11111"));
        accounts.add(new Account(500, "2222"));
        bank.addAccountToUser(user1.getPassport(), accounts.get(0));
        bank.addAccountToUser(user2.getPassport(), accounts.get(1));

    }
    @Test
    public void addUserAndAccount() {
        List<Account> userAccount = bank.getUserAccounts(user1.getPassport());
        List<Account> userAccount2 = bank.getUserAccounts(user2.getPassport());
        List<Account> result = new ArrayList<>();
        result.addAll(userAccount);
        result.addAll(userAccount2);
        assertThat(result, is(accounts));
    }
    @Test
    public void deleteUser() {
        bank.deleteUser(user1);
        List<Account> result = bank.getUserAccounts(user1.getPassport());
        assertThat(result, is(nullValue()));
    }
    @Test
    public void deleteAccountThenNull() {
        bank.deleteAccountFromUser(user2.getPassport(), accounts.get(1));
        List<Account> result = bank.getUserAccounts(user2.getPassport());
        List<Account> expected = new ArrayList<>();
        assertThat(result, is(expected));
    }
    @Test
    public void whenNoMoneyToTransferThenFalse() {
        boolean result = bank.transferMoney(user1.getPassport(), accounts.get(0).getRequisites(),
                user2.getPassport(), accounts.get(1).getRequisites(), 200);
        assertThat(result, is(false));
    }
    @Test
    public void whenMoneyToTransferThenTrue() {
        boolean result = bank.transferMoney(user1.getPassport(), accounts.get(0).getRequisites(),
                user2.getPassport(), accounts.get(1).getRequisites(), 10);
        assertThat(result, is(true));
    }
    @Test
    public void transfer100FromUser1ToUser2() {
        bank.transferMoney(user1.getPassport(), accounts.get(0).getRequisites(),
                user2.getPassport(), accounts.get(1).getRequisites(), 100);
        double[] result = {
                bank.getUserAccounts(user1.getPassport()).get(0).getAmount(),
                bank.getUserAccounts(user2.getPassport()).get(0).getAmount()
        };
        double[] expected = {50, 600};
        assertThat(result, is(expected));
    }
}
