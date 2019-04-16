package ru.job4j.bank2;


/**
 * @author Airat Muzafarov.
 * @version 0.1
 * @since 04/04/2019
 */
public class Account {
    private double amount;
    private String requisites;
    Account(double amount, String requisites) {
        this.amount = amount;
        this.requisites = requisites;
    }

    public double getAmount() {
        return amount;
    }

    public String getRequisites() {
        return requisites;
    }
    public void sendAmount(double money) {
        amount -= money;
    }
    public void reciveAmount(double money) {
        amount += money;
    }

    @Override
    public String toString() {
        return "Account{"
                +
                "amount="
                +
                amount
                +
                ", requisites='"
                +
                requisites
                + '\''
                +
                '}';
    }
}
