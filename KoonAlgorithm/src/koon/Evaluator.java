package koon;

/**
 * Created by ayrat on 10/19/15.
 */
public class Evaluator {

    private int n,k;
    private boolean[] used;
    private int[] mt;
    private int[][] g;

    public Evaluator(int n, int k, int[][] g){
        this.n=n;
        this.k=k;
        this.g=g;
        mt = new int[k];
        used = new boolean[n];
        init_mt();


    }

    private void init_mt(){

        for (int i=0 ; i<k; i++){
            mt[i] = -1;
        }
    }

    public int[] evaluate(){
        for (int v=0; v<n; v++){
            init_used();
            koon (v);

        }
        return mt;
    }

    private void init_used(){
        for (int i=0 ; i<n; i++){
            used[i] = false;
        }
    }

    private boolean koon (int v){
        if (used[v]) {
            return false;
        }
        used[v] = true;
        for (int i=0; i<g[v].length; i++){
            int to = g[v][i];
            if ((mt[to] == -1) || (koon(mt[to]) )){
                mt[to] = v;
                return true;
            }
        }
        return false;
    }

}
