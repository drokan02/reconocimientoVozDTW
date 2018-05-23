/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.Grabacion;

/**
 *
 * @author DroKaN
 */
public class HiloGrabar extends Thread{
    private final Grabacion vgrabacion;
    private final Palabra nuevaP;
    
    public HiloGrabar(Grabacion vgrabacion,Palabra nuevaP){
        this.vgrabacion = vgrabacion;
        this.nuevaP = nuevaP;
    }
    
    public void run(){
            int cont = 0;
            int start = 3;
            int tiempG = 4;
            
            while(start>=0){
                System.out.print(start);
                vgrabacion.lbMicrof.setText(start+1+"");
                           
                if (start == 0){
                    //empezar agrabar
                    vgrabacion.lbMicrof.setText("");
                    vgrabacion.lbMicrof.setIcon(Complementos.nuevoIcono("microfono.png"));
                } else {
                    Complementos.dormirHilo(1000);
                }
                    start--;
            }
            
            while(tiempG > 0){
            
                if(cont < 4){
                    vgrabacion.lbfAnimado.setIcon(Complementos.nuevoIcono("fondo"+cont+".png"));
                }else {
                    cont = -1;
                }
                if(tiempG == 1){
                    //cerrar la ventada de grabacion
                    //parar grabacion
                }else{
                    Complementos.dormirHilo(1000);
                }
                cont++;
                tiempG--;
                
            }  
    }

}
       