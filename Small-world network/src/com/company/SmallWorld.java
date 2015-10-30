package com.company;

/**
 * Created by ayrat on 10/30/15.
 */
public class SmallWorld {

    int n;
    int[][] graph;
    int[][] path;
    double avePath;
    double aveHarmPath;
    int infinity;

    public SmallWorld (int[][] graph, int n, int infinity){
        this.n = n;
        this.graph = graph;
        this.infinity = infinity;

    }

    public void floydwarshall(){
        path = new int[n][n];
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    path[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                }
            }
        }
    }

    public void printPath(){
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(String.valueOf(path[i][j]) + ' ');
            }
            System.out.println();
        }

    }

    public void averagePath(){
        avePath = 0;
       for (int i=0; i<n;i++){
           for (int j=0; j<n; j++){
               if ((i!=j) && (path[i][j]!=infinity)) {
                   avePath = avePath + path[i][j];
               }
           }
       }
        avePath = avePath/(n*(n-1)*0.5);
    }

    public void averageHarmonicPath(){
        aveHarmPath = 0;
        for (int i=0; i<n;i++){
            for (int j=0; j<n; j++){
                if ((i!=j) && (path[i][j]!=infinity)) {
                    aveHarmPath = 1/((double)path[i][j]);
                }
            }
        }
        aveHarmPath = n/aveHarmPath;
    }

    public int[][] getPath(){
        return path;
    }

    public double getAvePath(){
        return avePath;
    }

    public double getAveHarmPath(){
        return aveHarmPath;
    }
}
