package ru.job4j.coffeemachine;

public class Coffeemachine {
    int[] coins = {10, 5, 2, 1};
    int[] coinsQty = new int[4];
    public int[] changes(int value, int price) {
        int index = 0;
        int c = value - price;
        for (int x : coins) {
            if (x <= c) {
                coinsQty[index] = c / x;
                c = c - (coinsQty[index] * x);
                index++;
            }
        }
        int sum = 0;
        for (int i = 0; i < coinsQty.length; i++) {
            sum = sum + coinsQty[i];
        }

        int[] change = new int[sum];
        for (int i = 0; i < coinsQty[0]; i++) {
            change[i] = 10;
        }
        for (int i = coinsQty[0]; i < coinsQty[0] + coinsQty[1]; i++) {
            change[i] = 5;
        }
        for (int i = coinsQty[0] + coinsQty[1]; i < coinsQty[0] + coinsQty[1] + coinsQty[2]; i++) {
            change[i] = 2;
        }
        for (int i = coinsQty[0] + coinsQty[1] + coinsQty[2]; i < sum; i++) {
            change[i] = 1;
        }
        return change;
    }
}