/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Grabacion;
import Vista.NewJFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author DroKaN
 */
public class Hilo extends Thread{
     private Grabacion frame;
     private Palabra pa;
       public Hilo(Grabacion f,Palabra pa){
           frame = f;
           this.pa = pa;
       }

      public void run(){
            int cont = 0;
            int start = 0;
            int tiempG = 0;
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            while(start<=3){
                if(start < 3){
                    System.out.println(start);
                    frame.lbMicrof.setText(start+1+"");
                    if(start == 1){
                        //empezar a grabar
                    }        
                }else{
                    frame.lbMicrof.setText("");
                    frame.lbMicrof.setIcon(Complementos.nuevoIcono("microfono.png"));
                }
                    Complementos.dormirHilo(1000);
                    start++;
            }
            while(tiempG < 6){
            
            if(cont < 4){
                frame.lbfAnimado.setIcon(Complementos.nuevoIcono("fondo"+cont+".png"));
            }else {
                cont = -1;
            }
            if(tiempG == 5){
                //cerrar la ventada de grabacion
                frame.dispose();
            }else{
                //parar grabacion 

            }
            cont++;
            tiempG++;
            Complementos.dormirHilo(1000);
            }
       
    }
 }