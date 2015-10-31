package com.company;

public class Main {

    public static void main(String[] args) {
        int n = 100;
        double p = 0.2;
        int max = 1000;
        int min = 1;

        RandomGraphGenerator generator = new RandomGraphGenerator(n, p, max, min);
        //generator.printGraph();
        System.out.println();

        int[][] graph = generator.getGraph();

        int infinity = max + 1;
        SmallWorld world = new SmallWorld(graph, n, infinity);
        world.floydwarshall();
        //world.printPath();
        System.out.println();

        world.averagePath();
        world.averageHarmonicPath();

        double average = world.getAvePath();
        double harmAverage = world.getAveHarmPath();

        System.out.println(String.valueOf(average)); //+ ' ' + String.valueOf(harmAverage));

    }







}
