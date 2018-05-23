/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author DroKaN
 */
public class leerAudio {
    
    public double[] nuevaMuestra(File audio) throws UnsupportedAudioFileException, IOException {
      
        AudioInputStream flujoEntradaAudio = AudioSystem.getAudioInputStream(audio);
        int bytesPorFrame = flujoEntradaAudio.getFormat().getFrameSize();                        
        int numBytes = 1024 * bytesPorFrame; 
        byte[] audioBytes = new byte[numBytes];
        int longitudArchivoBytes=(int)flujoEntradaAudio.getFormat().getFrameSize()*(int)flujoEntradaAudio.getFrameLength();

        byte[] datosTemporal=new byte[longitudArchivoBytes];     
        int pos=0;         

        //procedimiento que lee los bytes del archivo de audio a memoria                    
  
        int numeroBytesLeidos = 0;
        int numeroFramesLeidos = 0; 
        int totalFramesLeidos = 0;

        while((numeroBytesLeidos=flujoEntradaAudio.read(audioBytes))!=-1) 
        {                      
        numeroFramesLeidos = numeroBytesLeidos/bytesPorFrame;
        totalFramesLeidos += numeroFramesLeidos;                  
        System.arraycopy(audioBytes, 0, datosTemporal,pos, numeroBytesLeidos);
        pos=pos+numeroBytesLeidos;                      
        }
      
        double[] datosVoz= convertirByteADouble(datosTemporal, true);
        return datosVoz;
    }
        
    /* ejemplo bits[2]=2 (00000010) bits[3]=3 (00000011)          
     se aplica bits[2]<<8>
     en total da 10 00000011  que es el numero 515 ,
     este es un short de 16 bits, han entrado dos bytes en uno
     (short[i]=contacenar byte[i]+byte[i+1])          
     los valores negativos estan en complemento a 2         
     */          
    public double[] convertirByteADouble(byte[] bits, boolean formato){  
       double mayor=0, menor=0; 
        double[] arrayDouble = new double[bits.length/2];                 
        if (formato==true)
        {        
            int temp = 0x00000000;        
            for (int i = 0, j = 0; j < arrayDouble.length  ;
                 j++, temp = 0x00000000) 
            {            
                temp=(int)bits[i++]<<8;            
                temp |= (int) (0x000000FF & bits[i++]);            
                arrayDouble[j]=(double)temp; 
            }
        
            return arrayDouble;
        
        }
        
        
        if(formato==false)
        {  // si el formato es littleEndian                    
            int temp = 0x00000000;        
            for (int i = 0, j = 0; j< arrayDouble.length ;
                 j++, temp = 0x00000000) 
            {                    
                temp=(int)bits[i+1]<<8;            
                temp |= (int) (0x000000FF & bits[(i)]);          
                i=i+2;                  
                arrayDouble[j]=(double)temp;        
        //calcular mayor y menor esto me servira para establecer
        //los parametros en el eje y para la grafica          
                if(mayor<arrayDouble[j])                
                    mayor=arrayDouble[j];               
                               
                if(menor>arrayDouble[j])                                                   
                    menor=arrayDouble[j];                                                  
            }
        
            return arrayDouble;        
        }                
        else
        {            
          System.out.println("orden de Bytes desconocido o no soportado");                        
        }        
    return arrayDouble;        
    }        
}
