package ru.job4j.coffeemachine;

public class Coffeemachine {
    int tenCoins, fiveCoins, twoCoins, oneCoins;
    public int[] changes(int value, int price) {
        int c = value - price;
        if (c >= 10) {
            this.tenCoins = c / 10;
        }
        c = c - (tenCoins * 10);
        if (c >= 5) {
            this.fiveCoins = c / 5;
        }
        c = c - (fiveCoins * 5);
        if (c >= 2) {
            this.twoCoins = c / 2;
        }
        c = c - (twoCoins * 2);
        if (c >= 1) {
            this.oneCoins = 1;
        }
        int coins = this.fiveCoins + this.oneCoins + this.twoCoins + this.tenCoins;
        int[] change = new int[coins];
        for (int i = 0; i < this.tenCoins; i++) {
            change[i] = 10;
        }
        for (int i = this.tenCoins; i < this.tenCoins + this.fiveCoins; i++) {
            change[i] = 5;
        }
        for (int i = this.tenCoins + this.fiveCoins; i < this.tenCoins + this.fiveCoins + this.twoCoins; i++) {
            change[i] = 2;
        }
        for (int i = this.tenCoins + this.fiveCoins + this.twoCoins; i < coins; i++) {
            change[i] = 1;
        }
        return change;
    }
}