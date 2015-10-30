package com.company;

public class Main {

    public static void main(String[] args) {
        int n = 10;
        double p = 0.75;
        RandomGraphGenerator generator = new RandomGraphGenerator(n, p, 1, 1000);
        generator.printGraph();

        int[][] graph = generator.getGraph();
        SmallWorld world = new SmallWorld(graph, n);
        world.floydwarshall();
        System.out.println();
        world.printPath();

    }







}
