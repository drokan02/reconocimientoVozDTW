/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
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
    private  Grabador grabador;
    private int pos;
    private  Diccionario diccionario;
    private DefaultListModel list;
    private boolean estado;
    private Palabra muestra;
    leerAudio leer;
    public Controller(){
        diccionario = new  Diccionario();
        viewRec = new MuestraDeVoz();
        grabador = new Grabador();
        list =  new DefaultListModel();
        leer = new leerAudio();
    }
    
    public void addEvent(){
        viewRec.btFinalizar.addActionListener(this);
        viewRec.btGrabar.addActionListener(this);
        viewRec.btPlay.addActionListener(this);
        viewRec.rbAgregar.addActionListener(this);
        viewRec.rbReconocer.addActionListener(this);
        viewRec.btComparar.addActionListener(this);
    }  
    
    public void shoWindow(){
        viewRec.btFinalizar.setVisible(false);
        viewRec.txtMuestra.setVisible(false);
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
           String palabra = getWord();
            if(!palabra.equals("")){
                 viewRec.txtError.setText("");
                 viewRec.btGrabar.setVisible(false);
                 viewRec.btFinalizar.setVisible(true);
                 grabador.grabarVoz(palabra);
            }else if(estado){
                viewRec.txtError.setText("Error no ingreso la muestra");
                System.out.println(viewRec.txtError.getText());

            }else{
                 viewRec.txtError.setText("");
                 viewRec.btGrabar.setVisible(false);
                 viewRec.btFinalizar.setVisible(true);
                 grabador.grabarVoz("");
            }
          
         
       } else if (e.getSource() == viewRec.btFinalizar){
           try {
               grabador.finalizar();
               Palabra word = nuevaPalabra(grabador.getAudio());
               try {
                   int n = word.getMuestra().length;
                   if(n > 0){
                       if(estado){
                           diccionario.agregarPalabra(word);
                           list.addElement(getWord());
                           viewRec.txtError.setText("");
                           viewRec.txtMuestra.setText("");
                       }else{
                           muestra = word;
                           System.out.println(word.getMuestra().length);
                           viewRec.txtError.setText("MUESTRA OBTENIDA");
                           
                       }
                   }else
                       viewRec.txtError.setText("Lo siento no se entendio lo q dijo");
               } catch (Exception ex) {
                   System.out.println(ex);
               }
               viewRec.btGrabar.setVisible(true);
               viewRec.btFinalizar.setVisible(false);
           } catch (Exception ex) {
                    
           }
       } else if (e.getSource() == viewRec.btPlay){
           if(pos < diccionario.getTamanioD()){
                   grabador.reproducir(diccionario.getPalabra(pos).getAudio());
                   System.out.println(diccionario.getPalabra(pos).getMuestra().length); 
                   pos++;
            }else{
               pos = 0;
               System.out.println("----------------------------------");  
           }
       }else if(e.getSource() == viewRec.rbAgregar){
           estado = true;
           viewRec.txtMuestra.setVisible(true);

       }else if(e.getSource() == viewRec.rbReconocer){
           estado = false;
           viewRec.txtMuestra.setVisible(false);
       }else if(e.getSource() == viewRec.btComparar){
              compareVoice(muestra); 
              
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
    
}
