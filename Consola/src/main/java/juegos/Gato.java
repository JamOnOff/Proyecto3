/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos;

import clases.Archivo;
import consola.Consola;
import sprite.Imagen;

/**
 *
 * @author Josué Alvarez M
 */
public class Gato extends Juego{
    private final String[][] matriz = new String[3][3];
    
    
    public Gato() {
        super(new Imagen(Consola.dirImagenes + "gato/portada.png"));
        imagenes.add(new ImagenPuntos("equis", new Archivo("equis.txt", Consola.dirImagenes + "gato/"), 0));
        imagenes.add(new ImagenPuntos("lineas", new Archivo("lineas.txt", Consola.dirImagenes + "gato/"), 0));
        
        start();
    }

    @Override
    public void run() {
        Consola.enviarString(getImagenes("lineas").getPuntos());
        
        while(true){
            try {
                String tecla = Consola.entradas.teclado.remove(0);
                System.out.println(tecla);
            } catch (Exception e) {
            }
        }
    }
    
    
}
