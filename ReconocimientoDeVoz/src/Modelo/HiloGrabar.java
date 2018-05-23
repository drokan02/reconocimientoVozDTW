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
    private final Grabador grabador;
    
    public HiloGrabar(Grabacion vgrabacion,Palabra nuevaP){
        this.vgrabacion = vgrabacion;
        this.nuevaP = nuevaP;
        this.grabador = new Grabador();
    }
    
    public void run(){
            int cont = 0;
            int start = 3;
            int tiempG = 4;
            vgrabacion.setVisible(true);
            while(start>=0){
                vgrabacion.lbMicrof.setText(start+1+"");
                           
                if (start == 0){
                    grabador.grabarVoz(nuevaP.getPalabra());
                    vgrabacion.lbMicrof.setText("");
                    vgrabacion.lbTitulo.setText("GRABANDO");
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
                   vgrabacion.dispose();
                   nuevaP.setAudio(grabador.getAudio());
                   nuevaP.setMuestra(grabador.muestraDeAudio(nuevaP.getAudio()));
                }else{
                    Complementos.dormirHilo(1000);
                }
                cont++;
                tiempG--;
                
            }  
    }

}
       