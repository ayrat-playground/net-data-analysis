package koon;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int k =4;
        int n =3;
        double p = 0.5;
        int[][] graph = generateGraph(k,n,p);

        for (int i=0; i<n; i++){
            for (int j=0; j<graph[i].length; j++) {
                System.out.println(i + " " + graph[i][j]);
            }

        }

        System.out.println();


        Evaluator eval = new Evaluator(n,k,graph);
        int[] res = eval.evaluate();

        for (int i=0; i<k; i++){
            if (res[i] != -1){
                System.out.println(res[i] + " " + i);
            }
        }

    }

    public static int[][] generateGraph(int k, int n, double p){
        int graph[][] = new int[n][];

        for (int i=0; i<n; i++){
            graph[i] = generateNodes(k, p);

        }

        return graph;
    }

    public static int[] generateNodes(int k, double p){

        int[] temp = new int[k];
        int count=0;
        for (int i=0 ;i< k ;i++){
            if (Math.random()<p){
                temp[i]  = i;

            }
            else{
                temp [i] = -1;
                count++;
            }
        }

        int[] result = new int[k-count];
        int j=0;
        for (int i=0 ;i< k ;i++) {
            if (temp[i]!=-1){
                result[j] = temp[i];
                j++;
            }
        }

        return result;

    }

}
