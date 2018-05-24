/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;


/**
 *
 * @author DroKaN
 */
public class Grabador{
    File audio; //archivo creado
    private AudioFileFormat.Type aFF_T ;//2.Parametros de Grabacion
    private AudioFormat aF ;//3.entrada de informacion por micro
    private TargetDataLine tD;//4.  (Sobreescribir un archivo)
    
    
    public File getAudio(){
        return audio;
    }
    //grabar la voz y lo guarda en un directorio de proyecto, el metodo retorna AudioGrabado
    public  void grabarVoz(String nombre){
        String URL = "rec.wav";
        aFF_T = AudioFileFormat.Type.WAVE;
        aF = new AudioFormat(8000.0F, 16, 1, true, false);
        if(!nombre.equals(""))
            URL = "src/grabaciones/"+nombre+".wav";
        audio=new File(URL);
        try {
            DataLine.Info dLl=new DataLine.Info(TargetDataLine.class, aF);
            tD=(TargetDataLine)AudioSystem.getLine(dLl);
            new hilo(audio).start();

         } catch (Exception e) {
         }
    }
   
    public void finalizar(){
        tD.close();
    }
    
    //reproducio dado un audio
    public void reproducir(File audio){
       try {
           Clip clip = AudioSystem.getClip();
           clip.open(AudioSystem.getAudioInputStream(audio));
           clip.start();
       } catch (Exception ex) {
       }
    }
     
     //obtiene la muestra de un audio 
    public double[] muestraDeAudio(File audio){
        try{
        AudioInputStream ai = AudioSystem.getAudioInputStream(audio);
        byte[] buffer = new byte[ai.available()];
        ai.read(buffer);
        int N = buffer.length;  
        double[] d = new double[N/2];
        for (int i = 0; i < N/2; i++) {
            d[i] = ((short) (((buffer[2*i+1] & 0xFF) << 8) + (buffer[2*i] & 0xFF)))/32768.0 ;
        }
        return recortarMuestra(d,.3, 8000);
        } catch (Exception e){}
        return new double[0];   
    }
    
   
    //elimina los espacios vacios reduciendo el tamaño de la muestra en un porcentaje(pad)
     public double[] recortarMuestra(double[] a,double pad,int fr){
        double[] res;
        int n = (int)(pad*fr);
        double umbral = 0.33*max(a);
        ArrayList<Integer> sobreUmbral= muestrasM(a,umbral);
        int[] limts = {sobreUmbral.get(0),sobreUmbral.get(sobreUmbral.size()-1)};
        int min = (int)maximo(limts[0]-n,1);
        int max = (int)minimo(limts[1]+n,a.length);
        if(min == 1 || max==a.length){
            return  new double[0];
        }else{
            res = nuevaMuestra(a,min,max);
            
            //return res;
            return filtrarMuesta(res, 0.97);
        }
    }
     
     //filtra la muestra para que sea mas lineal la muestra
        public double[] filtrarMuesta(double[] m, double filtro){
            double[] res = new double[m.length];
            res[0] = m[0];
            for(int i = 1; i < res.length ; i++){
              res[i] =  m[i] - filtro*m[i-1]; 
            }
            return res;
        }
     
   //busca todas las muestra que sean mayores al umbral
     private ArrayList<Integer> muestrasM(double[]a,double um){
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0 ; i<a.length ;i++){
            if(a[i]>um){
                res.add(i);
            }

        }
        return res;
    }
   
     public double minimo(double n,double m){
       if(n<m)
           return n;
       else
           return m;
   }
   
    private double maximo(double n,double m){
       if(n<m)
           return m;
       else
           return n;
   }
   //reduce la muestra hasta un minimo y un maximo donde no hay espacios vacios
    public double[] nuevaMuestra(double[] a,int min,int max){
        double[] res = new double[max-min+1];
        for(int i=0 ; i<res.length ;i++){
            res[i]=a[i+min];
        }
        return res;
    }
    public double max(double[] a){
        double b,res=0;
        for(int i=0 ; i<a.length ;i++){
            b = a[i];
            if(maximo(res, b)==b)
                res = b;
        }
        return res;
    }
    
    class hilo extends Thread{
        public hilo(File audio){

        }
        public void run(){
            try {
                tD.open(aF);//abre la entrada de informacion del microfono
                tD.start();
                
               AudioSystem.write(new AudioInputStream(tD), aFF_T, audio);
               /*
                - obtener un flujo de entrada de audio -> AFF_T
                - escribir un archivo externo -> tD
                - convertir una secuencia de entrada de audio a un formato de audio
               */
            } catch (Exception e) {
            }
        }
    }
}

