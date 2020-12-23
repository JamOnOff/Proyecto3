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
public class Pacman extends Juego{
    private int fila = 1;
    private int columna = 1;
    
    public Pacman() {
        imagenes.add(new ImagenPuntos("pacman", new Archivo("pacman.txt", Consola.dirImagenes + "pacman/"), 0));
        imagenes.add(new ImagenPuntos("muros", new Archivo("muros.txt", Consola.dirImagenes + "pacman/"), 2));
        
        start();
    }
    
    private void moverPacman(String tecla){
        if("w".equals(tecla)){
            getImagenes("pacman").iniciarPuntos(fila - 1, columna);
            fila --;
        }

        if("a".equals(tecla)){
            getImagenes("pacman").iniciarPuntos(fila, columna - 1);
            columna --;
        }

        if("s".equals(tecla)){
            getImagenes("pacman").iniciarPuntos(fila + 1, columna);
            fila ++;
        }

        if("d".equals(tecla)){
            getImagenes("pacman").iniciarPuntos(fila, columna + 1);
            columna ++;
        }

        if(getImagenes("pacman").verificarColicion(getImagenes("muros").getPuntos(), 15)){
            if("w".equals(tecla)){
                getImagenes("pacman").iniciarPuntos(fila + 1, columna);
                fila ++;
            }
            
            if("a".equals(tecla)){
                getImagenes("pacman").iniciarPuntos(fila, columna + 1);
                columna ++;
            }

            if("s".equals(tecla)){
                getImagenes("pacman").iniciarPuntos(fila - 1, columna);
                fila --;
            }

            if("d".equals(tecla)){
                getImagenes("pacman").iniciarPuntos(fila, columna - 1);
                columna --;
            }
        }
        else{
            Consola.enviarString(getImagenes("muros").getPuntos());
            Consola.enviarString(getImagenes("pacman").getPuntos());
        }
    }
    
    @Override
    public void run() {
        getImagenes("pacman").iniciarPuntos(1, 1);
        Consola.enviarString(getImagenes("muros").getPuntos());
        Consola.enviarString(getImagenes("pacman").getPuntos());
        
        String tecla = "";
        int cont;
        while(true){
            cont = 0;
            
            // define la tecla
            try {
                String teclaEntrante = Consola.entradas.teclado.remove(0);
                tecla = teclaEntrante;
            } catch (Exception e) {}
            
            // ejecuta el movimiento
            if(cont == 0)
                if("w".equals(tecla) || "a".equals(tecla) || "s".equals(tecla) || "d".equals(tecla))
                    moverPacman(tecla);
            //
            
            try {
                sleep(50);
            } catch (Exception e) {}
        }
    }
    
}
