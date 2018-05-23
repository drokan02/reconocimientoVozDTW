/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;

/**
 *
 * @author DroKaN
 */
public class Palabra {
    String palabra;
    double[] muestra;
    File audio;

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public double[] getMuestra() {
        return muestra;
    }

    public void setMuestra(double[] muestra) {
        this.muestra = muestra;
    }

    public File getAudio() {
        return audio;
    }

    public void setAudio(File audio) {
        this.audio = audio;
    }
    
    
}
