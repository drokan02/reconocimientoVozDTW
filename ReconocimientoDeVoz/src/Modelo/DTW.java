/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author DroKaN
 */
public class DTW {
   

    public double matrizAcumulada(double[] s1,double[] s2){
        int x,y;
        double res;
        double[][] mA = matrizDistancia(s1, s2);
         x = s1.length; 
         y = s2.length;
        if(mA[0].length > 0){
            
            for(int i = 1 ; i < x ; i++){
                mA[i][0] += mA[i-1][0];
            }
            
            for(int i = 1 ; i < y ; i++){
                mA[0][i] += mA[0][i-1];
            }
            
            for(int i = 1 ; i < x ; i++){
                 for(int j = 1 ; j < y ; j++){
                   mA[i][j] += minimo(mA[i-1][j],minimo(mA[i][j-1],mA[i-1][j-1]));
                }
            }

        }
        return(mA[x-1][y-1])/100;
        //return mA[x-1][y-1]/(x+y);
    }
    //calcula la distancia que existe entre ambas señales
    private double[][] matrizDistancia(double[] s1,double[] s2){
         int x = s1.length, y=s2.length;
        
        if(x > 0 && y > 0){
            double[][] mD = new double[x][y];
            
            for(int i = 0 ; i < x ; i++){
                 for(int j = 0 ; j < y ; j++){
                   mD[i][j] = Math.abs(s1[i] - s2[j]);
                }
            }
            return mD;//retornamos la matriz distancia
        }else 
            return new double[0][0];//si alguna de las señales no es valida retornamos una matriz vacia  
    }
    
    private double minimo(double n,double m){
        if(n<m)
            return n;
        else 
            return m;
    }
    
}
