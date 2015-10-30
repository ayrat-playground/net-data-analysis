package com.company;

/**
 * Created by ayrat on 10/30/15.
 */
public class SmallWorld {

    int n;
    int[][] graph;
    int[][] path;
    double avePath;

    public SmallWorld (int[][] graph, int n){
        this.n = n;
        this.graph = graph;

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

//    public void averagePath(){
//        avePath = 0;
//       for (int i=0; i<n;i++){
//           for (int j=0; j<n; j++){
//               if (i!=j) {
//                   avePath = avePath + path[i]
//               }
//           }
//       }
//    }

    public int[][] getPath(){
        return path;
    }
}
