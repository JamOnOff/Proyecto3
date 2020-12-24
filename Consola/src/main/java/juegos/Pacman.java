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
    private int puntaje = 0;
    
    public Pacman() {
        imagenes.add(new ImagenPuntos("pacman", new Archivo("pacman.txt", Consola.dirImagenes + "pacman/"), 0));
        imagenes.add(new ImagenPuntos("muros", new Archivo("muros.txt", Consola.dirImagenes + "pacman/"), 2));
        
        iniciarBolas();
        
        start();
    }
    
    private void iniciarBolas(){
        //crea los puntos
        ImagenPuntos imP;
        for (int i = 0; i < 23; i++) {
            imP = new ImagenPuntos("bola", new Archivo("bola.txt", Consola.dirImagenes + "pacman/"), 0);
            
            switch (i) {
                case 0:
                    imP.iniciarPuntos(1, 8);
                    imagenes.add(imP);
                    break;
                case 1:
                    imP.iniciarPuntos(8, 8);
                    imagenes.add(imP);
                    break;
                case 2:
                    imP.iniciarPuntos(8, 1);
                    imagenes.add(imP);
                    break;
                case 3:
                    imP.iniciarPuntos(8, 15);
                    imagenes.add(imP);
                    break;
                case 4:
                    imP.iniciarPuntos(15, 8);
                    imagenes.add(imP);
                    break;
                case 5:
                    imP.iniciarPuntos(33, 1);
                    imagenes.add(imP);
                    break;
                case 6:
                    imP.iniciarPuntos(33, 8);
                    imagenes.add(imP);
                    break;
                case 7:
                    imP.iniciarPuntos(33, 15);
                    imagenes.add(imP);
                    break;
                case 8:
                    imP.iniciarPuntos(40, 1);
                    imagenes.add(imP);
                    break;
                case 9:
                    imP.iniciarPuntos(40, 8);
                    imagenes.add(imP);
                    break;
                case 10:
                    imP.iniciarPuntos(26, 8);
                    imagenes.add(imP);
                    break;
                case 11:
                    imP.iniciarPuntos(33, 26);
                    imagenes.add(imP);
                    break;
                case 12:
                    imP.iniciarPuntos(33, 33);
                    imagenes.add(imP);
                    break;
                case 13:
                    imP.iniciarPuntos(33, 40);
                    imagenes.add(imP);
                    break;
                case 14:
                    imP.iniciarPuntos(40, 33);
                    imagenes.add(imP);
                    break;
                case 15:
                    imP.iniciarPuntos(40, 40);
                    imagenes.add(imP);
                    break;
                case 16:
                    imP.iniciarPuntos(26, 33);
                    imagenes.add(imP);
                    break;
                case 17:
                    imP.iniciarPuntos(15, 33);
                    imagenes.add(imP);
                    break;
                case 18:
                    imP.iniciarPuntos(8, 33);
                    imagenes.add(imP);
                    break;
                case 19:
                    imP.iniciarPuntos(8, 26);
                    imagenes.add(imP);
                    break;
                case 20:
                    imP.iniciarPuntos(8, 40);
                    imagenes.add(imP);
                    break;
                case 21:
                    imP.iniciarPuntos(1, 40);
                    imagenes.add(imP);
                    break;
                case 22:
                    System.out.println("1");
                    imP.iniciarPuntos(1, 33);
                    imagenes.add(imP);
                    break;
                default:
                    break;
            }
        }
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
            
            for (ImagenPuntos im : imagenes) {
                if("bola".equals(im.ID))
                    Consola.enviarString(im.getPuntos());
            }
        }
    }
    
    @Override
    public void run() {
        getImagenes("pacman").iniciarPuntos(fila, columna);
        Consola.enviarString(getImagenes("muros").getPuntos());
        Consola.enviarString(getImagenes("pacman").getPuntos());
        
        for (ImagenPuntos im : imagenes) {
                if("bola".equals(im.ID))
                    Consola.enviarString(im.getPuntos());
            }
        
        String tecla = "";
        int cont;
        while(true){
            
            if(puntaje == 23){
                puntaje = 0;
                fila = 1;
                columna = 1;
                
                imagenes.removeAll(imagenes);
                imagenes.add(new ImagenPuntos("pacman", new Archivo("pacman.txt", Consola.dirImagenes + "pacman/"), 0));
                imagenes.add(new ImagenPuntos("muros", new Archivo("muros.txt", Consola.dirImagenes + "pacman/"), 2));
                
                getImagenes("pacman").iniciarPuntos(fila, columna);
                Consola.enviarString(getImagenes("muros").getPuntos());
                Consola.enviarString(getImagenes("pacman").getPuntos());
                
                iniciarBolas();
                for (ImagenPuntos im : imagenes) {
                    if("bola".equals(im.ID))
                        Consola.enviarString(im.getPuntos());
                }
            }
            
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
            
            // colision con bola
            for (int i = 0; i < imagenes.size(); i++) {
                ImagenPuntos im = imagenes.get(i);
                if("bola".equals(im.ID))
                    if(getImagenes("pacman").verificarColicion(im.getPuntos())){
                        imagenes.remove(i);
                        puntaje ++;
                        break;
                    }
            }
            
            try {
                sleep(50);
            } catch (Exception e) {}
        }
    }
    
}
