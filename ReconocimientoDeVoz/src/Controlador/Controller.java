/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.Grabacion;
import Vista.Grabacion;
import Vista.MuestraDeVoz;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;




/**
 *
 * @author DroKaN
 */
public class Controller implements ActionListener{
    private  MuestraDeVoz viewRec;
   // private Grabacion vgrabacion;
    private  Diccionario diccionario;
    private DefaultListModel list;
    private  Grabador grabador;
    private String estado;
    private Palabra muestra;
    private int pos;
    
    
    
    leerAudio leer;
    public Controller(){
        diccionario = new  Diccionario();
        viewRec = new MuestraDeVoz();
        //vgrabacion = new Grabacion(viewRec, true);
        grabador = new Grabador();
        list =  new DefaultListModel();
        leer = new leerAudio();
        muestra = new Palabra();
    }
    
    public void addEvent(){

        viewRec.btGrabar.addActionListener(this);
        viewRec.btPlay.addActionListener(this);
        viewRec.rbAgregar.addActionListener(this);
        viewRec.rbReconocer.addActionListener(this);
        viewRec.btComparar.addActionListener(this);
        viewRec.btPrueba.addActionListener(this);
    }  
    
    public void shoWindow(){
        viewRec.txtMuestra.setEditable(false);
        viewRec.setLocationRelativeTo(null);
        viewRec.jList.setModel(list);
        backGround();
        viewRec.setVisible(true);
        cargarLista();
    }
    
    private void cargarLista(){
        Palabra p;
        diccionario.cargarDiccionario();
        int nroP = diccionario.getTamanioD();
        System.out.println(nroP);
        for(int i = 0 ; i < nroP ; i++){
            p = diccionario.getPalabra(i);
            list.addElement(p.getPalabra());
        }
    }
    private void backGround(){
        ImageIcon img = new ImageIcon("src/Imagenes/backGround.jpg");
        Icon icon = new ImageIcon(img.getImage().getScaledInstance(viewRec.gackgron.getWidth(), viewRec.gackgron.getHeight(), Image.SCALE_DEFAULT));
        viewRec.gackgron.setIcon(icon);
    }
    private String getWord(){
        return viewRec.txtMuestra.getText();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == viewRec.btGrabar){
            if(estado.equals("nueva palabra")){
                if(!getWord().equals(""))
                    new HiloGrabar().start();
                else
                    viewRec.txtError.setText("INGRESE LA NUEVA PALABRA ");
            }else{
                    new HiloGrabar().start();
            }
           
       }  else if (e.getSource() == viewRec.btPlay){
           if(pos < diccionario.getTamanioD()){
                   grabador.reproducir(diccionario.getPalabra(pos).getAudio());
                   System.out.println(diccionario.getPalabra(pos).getMuestra().length); 
                   pos++;
            }else{
               pos = 0;
               System.out.println("----------------------------------");  
           }
       }else if(e.getSource() == viewRec.rbAgregar){
           estado = "nueva palabra";
           viewRec.txtMuestra.setEditable(true);

       }else if(e.getSource() == viewRec.rbReconocer){
           estado = "nueva muestra";
           viewRec.txtMuestra.setEditable(false);
       }else if(e.getSource() == viewRec.btComparar){
              compareVoice(muestra); 
              
       }else if(e.getSource() == viewRec.btPrueba){
           
           
              
             
             
       }
       
  
    }
    
    private Palabra nuevaPalabra(File audio) throws Exception{
        Palabra palabra = new Palabra();
        palabra.setAudio(audio);
        palabra.setPalabra(getWord());
        palabra.setMuestra(grabador.muestraDeAudio(audio)); //metodo para obetern audio en arreglo
        return palabra;
    }
    private void compareVoice(Palabra voz){
        Palabra p = diccionario.buscarPalabra(voz);
        viewRec.txtError.setText(p.getPalabra());
       
    }
    
    //hilo para realizar grabacion
    public class HiloGrabar extends Thread{

    
    public void run(){
            int cont = 0;
            int start = 3;
            int tiempG = 4;
            Palabra nuevaPalabra = new Palabra();
            nuevaPalabra.setPalabra(getWord());
            Grabacion g = new Grabacion(); 
            g.setLocationRelativeTo(null);
            g.setVisible(true);
            System.out.println(start);
            
            while(start >= 0){
                g.lbMicrof.setText(start+"");
                           
                if (start == 0){
                    grabador.grabarVoz(nuevaPalabra.getPalabra());
                } 
                start--;  
                Complementos.dormirHilo(1000);
            }
            
            while(tiempG >= 0){
            
                if(cont < 4){
                    g.lbMicrof.setText("");
                    g.lbTitulo.setText("GRABANDO");
                    g.lbMicrof.setIcon(Complementos.nuevoIcono("microfono.png"));
                    g.lbfAnimado.setIcon(Complementos.nuevoIcono("fondo"+cont+".png"));
                }else {
                    cont = -1;
                }
                if(tiempG == 0){
                   g.dispose();
                   grabador.finalizar();
                   nuevaPalabra.setAudio(grabador.getAudio());
                   nuevaPalabra.setMuestra(grabador.muestraDeAudio(nuevaPalabra.getAudio()));
                   int n = nuevaPalabra.getMuestra().length;
                   if(n > 0){
                       if(estado.equals("nueva palabra")){
                           diccionario.agregarPalabra(nuevaPalabra);
                           list.addElement(nuevaPalabra.getPalabra());
                           viewRec.txtError.setText("");
                           viewRec.txtMuestra.setText("");
                       }else{
                           muestra = nuevaPalabra;
                           System.out.println(nuevaPalabra.getMuestra().length);
                           viewRec.txtError.setText("MUESTRA OBTENIDA");
                           
                       }
                   }else
                       viewRec.txtError.setText("Lo siento no se entendio lo q dijo");
                }else{
                    Complementos.dormirHilo(1000);
                }
                cont++;
                tiempG--;  
            }  
    }

}
       
    
}
