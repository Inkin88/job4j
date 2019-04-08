package ru.job4j.bank;

import java.util.*;

/**
 * @author Airat Muzafarov.
 * @version 0.1
 * @since 04/04/2019
 */
public class Bank {
    private Map<User, List<Account>> clients = new HashMap<>();

    private User getUser(String passport) {
        User result = null;
        Set<User> users = clients.keySet();
        for(User user : users) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }
    private Account getAccount(String passport, String requisites) {
        List<Account> accounts = null;
        if (getUserAccounts(passport) != null) {
            accounts = getUserAccounts(passport); }
            Account account = null;
            for (Account acc : accounts) {
                if (acc.getRequisites().equals(requisites)) {
                    account = acc;
                    break;
                }
            }
        return account;
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
        User user = getUser(passport);
        if (user != null)
            clients.get(user).add(account);
    }

    /**
     * Delete one of users account
     * @param passport users passport
     * @param account account to delete
     */
    public void deleteAccountFromUser(String passport, Account account) {
        User user = getUser(passport);
        if (user != null) {
            List<Account> accounts = clients.get(user);
            for (int index = 0; index < accounts.size(); index++) {
                if (accounts.get(index).getRequisites().equals(account.getRequisites())) {
                    accounts.remove(accounts.get(index));
                    break;
                }
            }
        }
    }

    /**
     * Get Users accounts.
     * @param passport User passport.
     * @return accounts.
     */
    public List<Account> getUserAccounts(String passport) {
        User user = getUser(passport);
        List<Account> accounts = null;
        if (user != null) {
            accounts = clients.get(user);
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
    public boolean transferMoney (String srcPassport,
                                  String srcRequisite,
                                  String destPassport,
                                  String destRequisite,
                                  double amount) {
        Account scrAccount = getAccount(srcPassport, srcRequisite);
        Account destAccount = getAccount(destPassport, destRequisite);
        boolean result = false;
        if (scrAccount != null && destAccount != null && amount <= scrAccount.getAmount()) {
            scrAccount.sendAmount(amount);
            destAccount.reciveAmount(amount);
            result = true;
        }
        return result;
    }
}
