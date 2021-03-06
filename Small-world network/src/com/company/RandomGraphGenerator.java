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

        generateRandomGraph(max_cost, min_cost);
        //checkIntegrity(max_cost, min_cost);


    }

    private void generateRandomGraph(int max_cost, int min_cost){

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (Math.random()<p){
                    int cost = 1;
                    graph[i][j]  = cost;

                }
                else {
                    graph[i][j]  = infinity;
                }
                if (i==j){
                    graph[i][j]  = 0;

                }

            }
        }
    }

    private void checkIntegrity(int max_cost, int min_cost){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (i!=j){
                    if ((graph[i][j]==infinity) && (graph[j][i]==infinity)){
                        int cost = 1;
                        graph[i][j]  = cost;
                    }
                }
            }
        }
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
