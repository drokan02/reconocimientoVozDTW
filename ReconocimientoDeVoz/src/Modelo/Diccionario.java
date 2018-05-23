/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DroKaN
 */
public class Diccionario {
    ArrayList<Palabra> palabras;
    BufferedReader lecturaDiccionario;
    PrintWriter escrituraDiccionario;
    File diccionario;
    public Diccionario(){
        palabras = new ArrayList<>();
        diccionario = new File("src/grabaciones/diccionario.txt");
        crearLecturaEscritura();
    }
    
    private void crearLecturaEscritura(){
        try {
            lecturaDiccionario = new BufferedReader(new FileReader(diccionario));
            escrituraDiccionario = new PrintWriter(new BufferedWriter(new FileWriter(diccionario,true)));
        } catch (IOException ex) {
            Logger.getLogger(Diccionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cargarDiccionario(){
        try {
            while(lecturaDiccionario.ready()){
                Palabra palabra = new Palabra();
                String p = lecturaDiccionario.readLine();
                File audio = new File("src/grabaciones/"+p+".wav");
                palabra.setPalabra(p);
                palabra.setAudio(audio);
                palabra.setMuestra(new Grabador().muestraDeAudio(audio));
                palabras.add(palabra);
            }
                } catch (Exception ex) {
            Logger.getLogger(Diccionario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void agregarPalabra(Palabra p){
        try {
            escrituraDiccionario.write(p.getPalabra()+"\n");
            palabras.add(p);
        } catch (Exception ex) {
            Logger.getLogger(Diccionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public Palabra buscarPalabra(String palabra){
        Palabra res = null;
        int i=0;
        while(i< palabras.size()){
            if(palabra.equals(palabras.get(i).getPalabra()))
                res = palabras.get(i);
        }
        return res;
    }
    
    public Palabra buscarPalabra(Palabra palabra){
        Palabra res=null;
        double men = 10;
        double aux ;
        int i=0;
        DTW dtw = new DTW();
        for(Palabra p: palabras){
            aux = dtw.matrizAcumulada(p.getMuestra(),palabra.getMuestra());
            System.out.println(aux+"  "+ p.getPalabra()+p.getMuestra().length+"  "+palabra.getMuestra().length);
            if(menor(men,aux) == aux){
                men = aux;
                res = p;
            }
        }
        return res;
    }
    
    public Palabra getPalabra(int indice){
        return palabras.get(indice);
    }
    public void eliminarPalabra(Palabra p){

    }
    
    public int getTamanioD(){
        return palabras.size();
    }
    private double menor(double a,double b){
        if(a < b)
            return a;
        else
            return b;
    }
}

