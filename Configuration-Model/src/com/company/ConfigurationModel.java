package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ayrat on 11/2/15.
 */
public class ConfigurationModel {

    private int n;
    private int[] d;
    private int[][] configModel;

    public ConfigurationModel(int n, int[] d){
        this.n = n;
        this.d = d;

        if (isEven() || d.length!=n){
            System.out.println("Wrong parameters!!!");
        }

    }

    public void generateConfigurationModel(){
        ArrayList<Integer> exclude = new ArrayList<>();
        boolean[][] used = new boolean[n][];
        configModel = new int[n][];
        for (int i =0; i<n;i++){
            used[] =false
            configModel[i]=new int[d[i]];
            for (int j=0; j<d[i];i++){
                configModel[i][j] = -1;
            }
        }
        Random rnd = new Random();

        for (int i=0; i<n; i++){
            for (int j=0; j<d[i];j++){
                int num =getRandomWithExclusion(rnd, 0, n, convertIntegers(exclude));
                for (int k=0; k<d[i];k++){

                    
                }

            }


        }
    }

    private boolean isEven(){
        int sum = 0;
        for (int i=0; i<d.length;i++){
            sum =sum + d[i];
        }
        if (sum%2==0){
            return true;
        }
        else{
            return false;
        }
    }

    private int getRandomWithExclusion(Random rnd, int start, int end, int... exclude) {
        int random = start + rnd.nextInt(end - start + 1 - exclude.length);
        for (int ex : exclude) {
            if (random < ex) {
                break;
            }
            random++;
        }
        return random;
    }

    private static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

}
