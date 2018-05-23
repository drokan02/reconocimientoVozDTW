/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.NewJFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author DroKaN
 */
public class Complementos {
    

    public static Icon nuevoIcono(String nombreImg){
       ImageIcon i = new ImageIcon("src/pruebas/"+nombreImg);
       Icon icon = new ImageIcon(i.getImage());
       return icon;
    }
     
    public static void dormirHilo(int tiempo){
           try {
                Thread.sleep(tiempo);
              } catch (InterruptedException ex) {
                Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
              }
    }
}
