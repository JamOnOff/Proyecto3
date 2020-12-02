/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos;

import clases.Archivo;
import consola.Consola;

/**
 *
 * @author Josué Alvarez M
 */
public class Gato extends Juego{

    public Gato() {
        imagenes.add(new ImagenPuntos("equis", new Archivo("equis.txt", Consola.dirImagenes + "gato/"), 0));
        
        getImagenes("equis").iniciarPuntos(5, 10);
        Consola.enviarString(getImagenes("equis").getPuntos());
    }

    @Override
    public void run() {}
    
}
