/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author DroKaN
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    /*  DTW2 dtw =  new DTW2();
       double[] a ={1.0,3.0,4.0,9.0,8.0,2.0,1.0,5.0,7.0,3.0};
       double[] b = {1.0,6.0,2.0,3.0,0.0,9.0,4.0,3.0,6.0,3.0};
       double res = dtw.matrizAcumulada(b, a);
        System.err.println(res);
       Grabador g =  new Grabador();
       g.max(a);
       DecimalFormat formato1 = new DecimalFormat("#.0000");
       double p = Double.parseDouble(formato1.format(11.2143843).replaceAll(",", "."));
       p = Math.ceil(p*10000);
       p = p/10000;
       System.out.println(p);

     ArrayList<Double[]> m = new ArrayList<>();
     Double[] a ={1.0,3.0,4.0,9.0,8.0,2.0,1.0,5.0,7.0,3.0};
     m.add(a);
     m.get(0)[0] = 100.5;
     System.out.println(m.get(0)[0]);
  */  
    
    
    File datos = new File("src/Modelo/datos.txt");
    Grabador g =  new Grabador();
    BufferedReader read;
        double[] d = new double[32000];
        double[] n;
        double[] f;
        int i = 0;
        
       

        try {
            read = new BufferedReader(new FileReader(datos));
            while(read.ready()){
                String linea = read.readLine();
                d[i]=Double.parseDouble(linea);
                i++;
            }
            n = g.recortarMuestra(d, 0.3, 8000);
            System.out.println(n.length);
            f = g.filtrarMuesta(n, 0.97);
            for(int j = 0 ; j < n.length ; j++){
                System.out.println(n[j]+"     "+f[j]);
            }
        } catch (Exception ex) {
        }
    
    }
    
}
