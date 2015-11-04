package com.company;

import Jama.Matrix;

import java.util.Random;

public class Main {
    static int n =3;


    public static void main(String[] args) {
        double p =0.5;

        Matrix a = new Matrix(n, n);
        Matrix b = createB();
        a = createRandomGraph(a, p);
        Matrix c = createC(a,b);
        System.out.println(c.rank());



    }

    public static Matrix createRandomGraph (Matrix m, double p){
        Random rn = new Random();
        for (int i=0; i<m.getColumnDimension(); i++){
            for (int j=0; j<m.getRowDimension(); j++){
                if (rn.nextDouble()<p){
                    m.set(i,j,1);
                }

            }
        }

        return m;

    }

    public static Matrix createB (){
        Matrix b = new Matrix(n,2);
        b.set(0,0,7);
        b.set(2,1,200);

        return b;

    }

    public static Matrix createC (Matrix A, Matrix B){
        Matrix C=null;
        Matrix temp =B;
        for (int i=0; i<A.getColumnDimension();i++){
            for (int j=0; j< i;j++){
                A=A.times(A);
            }

            Matrix mult  = A.times(B);
            C = mergeMatrices(temp, mult);

            temp = C;


        }

        return C;

    }

    public static Matrix mergeMatrices(Matrix A, Matrix B){
        double[][] c = new double[A.getRowDimension()][A.getColumnDimension()+B.getColumnDimension()];

        for (int i=0; i<A.getRowDimension();i++) {
            for (int j = 0; j < A.getColumnDimension() + B.getColumnDimension(); j++) {
                if (j < A.getColumnDimension()) {
                    c[i][j] = A.get(i,j);
                }
                else{
                    c[i][j] = B.get(i,j-A.getColumnDimension());
                }
                if (Double.isNaN( c[i][j])){
                    c[i][j] = 0;
                }

            }

        }
        Matrix C = new Matrix(c);
        return C;
    }

}
