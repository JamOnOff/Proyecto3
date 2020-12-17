/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos;

import java.util.ArrayList;
import sprite.Imagen;

/**
 *
 * @author Josué Alvarez M
 */
public abstract class Juego extends Thread{
    protected Imagen portada;
    protected boolean iniciado = false;
    protected final ArrayList<ImagenPuntos> imagenes = new ArrayList();

    public Juego(Imagen portada) {
        this.portada = portada;
    }
    
    public void iniciarJuego(){
        iniciado = false;
        
        try {
            sleep(250);
        } catch (Exception ex) {}
        
        iniciado = true;
    }
    
    public void pararJuego(){
        iniciado = false;
    }
    
    public Imagen getPortada() {
        return portada;
    }
    
    public ArrayList<ImagenPuntos> getImagenes() {
        return imagenes;
    }
    
    public ImagenPuntos getImagenes(String ID){
        for (ImagenPuntos im : imagenes) {
            if(im.ID == ID)
                return im;
        }
        
        return null;
    }
    
    @Override
    public abstract void run();
}
