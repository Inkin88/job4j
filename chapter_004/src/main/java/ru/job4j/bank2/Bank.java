package ru.job4j.bank2;

import java.util.*;

/**
 * @author Airat Muzafarov.
 * @version 0.1
 * @since 16/04/2019
 */
public class Bank {
    private Map<User, List<Account>> clients = new HashMap<>();

    private Optional<User> getUser(String passport) {
        return clients.keySet().stream().filter(user -> user.getPassport().equals(passport)).findFirst();
    }
    private Optional<Account> getAccount(String passport, String requisites) {
        return getUserAccounts(passport).stream().filter(account -> account.getRequisites().equals(requisites)).findFirst();
    }
    /**
     * add User to clients
     * @param user user
     */
    public void addUser(User user) {
        clients.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * delete User from clients
     * @param user user
     */
    public void deleteUser(User user) {
        clients.remove(user);
    }

    /**
     * Add account to User
     * @param passport users passport
     * @param account account
     */

    public void addAccountToUser(String passport, Account account) {
        getUser(passport).ifPresent(user -> {
            final List<Account> accounts = clients.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        });
    }

    /**
     * Delete one of users account
     * @param passport users passport
     * @param account account to delete
     */
    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> accounts = getUserAccounts(passport);
        if (accounts != null) {
            accounts.removeIf(account1 -> account1.getRequisites().equals(account.getRequisites()));
        }
    }

    /**
     * Get Users accounts.
     * @param passport User passport.
     * @return accounts.
     */
    public List<Account> getUserAccounts(String passport) {
        Optional<User> user = getUser(passport);
        List<Account> accounts = null;
        if (user.isPresent()) {
            User u = user.get();
            accounts = clients.get(u);
        }
        return accounts;

    }

    /**
     * transfer money from user to user.
     * @param srcPassport the passport of the sender.
     * @param srcRequisite the requisite of the sender
     * @param destPassport beneficiary's passport
     * @param destRequisite beneficiary's requisite
     * @param amount money to transfer
     * @return true if all ok.
     */
    public boolean transferMoney(String srcPassport,
                                 String srcRequisite,
                                 String destPassport,
                                 String destRequisite,
                                 double amount) {
        Optional<Account> scrAccount = getAccount(srcPassport, srcRequisite);
        Account scr = null;
        if (scrAccount.isPresent()) {
            scr = scrAccount.get();
        }
        Optional<Account> destAccount = getAccount(destPassport, destRequisite);
        Account dest = null;
        if (destAccount.isPresent()) {
            dest = destAccount.get();
        }
        boolean result = false;
        if (scr != null && dest != null && amount <= scr.getAmount()) {
            scr.sendAmount(amount);
            dest.reciveAmount(amount);
            result = true;
        }
        return result;
    }
}
