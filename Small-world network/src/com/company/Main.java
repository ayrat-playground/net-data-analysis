package com.company;

public class Main {

    public static void main(String[] args) {
        int n = 5;
        double p = 0.75;
        RandomGraphGenerator generator = new RandomGraphGenerator(n, p, -100, 100);
        generator.printGraph();

    }




}
