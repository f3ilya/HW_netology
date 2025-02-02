package ru.netology.service;

public class CustomsService {

    public static final int RATE = 100;

    public static int calculateCustoms(int price, int weight) {
        return price / RATE + weight * RATE;
    }
}
