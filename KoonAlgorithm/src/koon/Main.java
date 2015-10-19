package koon;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int k =5;
        int n =5;
        double p = 0.75;
        int[][] graph = generateGraph(k,n,p);


        Evaluator eval = new Evaluator(n,k,graph);
        int[] res = eval.evaluate();

        System.out.println(graph);

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
