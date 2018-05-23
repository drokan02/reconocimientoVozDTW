/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author DroKaN
 */
public class DTW2 {
    
    
    
    public double matrizAcumulada(double[] s1,double[] s2){
        int x,y;
        int step = 40;
        int wdw = 80;
        double res;
        ArrayList<Double[]> mA = new ArrayList<>();
        matrizDistancia(s1, s2,mA);
        //x=Math.abs((s1.length-wdw)/step);
        //y=Math.abs((s2.length-wdw)/step);
         x = s1.length; 
         y = s2.length;
        if(mA.size() > 0){
            for(int i = 1 ; i < x ; i++){
               mA.get(0)[i] += mA.get(0)[i-1];
            }
            
            for(int i = 1 ; i < y ; i++){
                mA.get(i)[0] += mA.get(i-1)[0];
            }
            
            for(int i = 1 ; i < x ; i++){
                 for(int j = 1 ; j < y ; j++){
                   mA.get(j)[i] += minimo(mA.get(j)[i-1],minimo(mA.get(j-1)[i],mA.get(j-1)[i-1]));
                }
            }

        }
        System.out.println( mA.get(y-1)[x-1]/(x+y));
        return mA.get(y-1)[x-1]/(x+y);
    }
    //calcula la distancia que existe entre ambas señales
    private void matrizDistancia(double[] s1,double[] s2, ArrayList<Double[]> mA ){
        int x = s1.length, y=s2.length;
        
        if(x > 0 && y > 0){
            
            for(int j = 0 ; j < y ; j++){
                Double[] fila = new Double[x];
                 for(int i = 0 ; i < x ; i++){
                   fila[i] = Math.abs(s1[i] - s2[j]);
                }
                mA.add(fila);
            }
           
        }
   
    }
    
    private double minimo(Double n,Double m){
        if(n<m)
            return n;
        else 
            return m;
    }

}
