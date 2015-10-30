package com.company;

/**
 * Created by ayrat on 10/30/15.
 */
public class RandomGraphGenerator {
    int infinity;
    int n;
    double p;
    int[][] graph;

    public RandomGraphGenerator(int n, double p, int max_cost, int min_cost){
        this.n = n;
        this.p = p;
        this.infinity = max_cost + 1;
        initilizeGraph(max_cost, min_cost);

    }

    private void initilizeGraph(int max_cost, int min_cost){
        graph = new int[n][n];
        do {
            generateRandomGraph(max_cost, min_cost);
        }
        while (!checkIntegrity());

    }

    private void generateRandomGraph(int max_cost, int min_cost){

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (Math.random()<p){
                    int cost = min_cost + Double.valueOf(Math.random()*(max_cost-min_cost)).intValue();
                    graph[i][j]  = cost;

                }
                else {
                    graph[i][j]  = infinity;
                }

            }
        }
    }

    private boolean checkIntegrity(){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (i!=j){
                    if ((graph[i][j]==infinity) && (graph[j][i]==infinity)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int[][] getGraph(){
        return graph;

    }

    public void printGraph(){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(String.valueOf(graph[i][j]) + ' ');
            }
            System.out.println();
        }

    }
}
