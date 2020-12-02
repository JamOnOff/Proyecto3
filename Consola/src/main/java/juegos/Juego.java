/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos;

import java.util.ArrayList;

/**
 *
 * @author Josué Alvarez M
 */
public abstract class Juego extends Thread{
    protected final ArrayList<ImagenPuntos> imagenes = new ArrayList();

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
