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
    private final String[][] matrizSelecion = new String[3][3];
    
    public Gato() {
        super(new Imagen(Consola.dirImagenes + "gato/portada.png"));
        imagenes.add(new ImagenPuntos("equis", new Archivo("equis.txt", Consola.dirImagenes + "gato/"), 0));
        imagenes.add(new ImagenPuntos("circulo", new Archivo("circulo.txt", Consola.dirImagenes + "gato/"), 0));
        imagenes.add(new ImagenPuntos("lineas", new Archivo("lineas.txt", Consola.dirImagenes + "gato/"), 0));
        imagenes.add(new ImagenPuntos("nada", new Archivo("nada.txt", Consola.dirImagenes + "gato/"), 1));
        imagenes.add(new ImagenPuntos("seleccionar", new Archivo("seleccionar.txt", Consola.dirImagenes + "gato/"), 0));
        
        iniciarMatriz();
        
        start();
    }
    
    private boolean juegoFinalizado(){
        for (int i = 0; i < 3; i++) { // horizontales
            if(matriz[i][0] == matriz[i][1] && matriz[i][1] == matriz[i][2] && matriz[i][2] != "")
                return true;
        }
        
        for (int i = 0; i < 3; i++) { // verticales
            if(matriz[0][i] == matriz[1][i] && matriz[1][i] == matriz[2][i] && matriz[2][i] != "")
                return true;
        }
        
        // diagonales 
        if(matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2] && matriz[2][2] != "")
                return true;
        if(matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0] && matriz[2][0] != "")
                return true;
        
        for (int i = 0; i < 3; i++) { // verifica si hay una casilla libre
            for (int j = 0; j < 3; j++) {
                if("".equals(matriz[i][j]))
                    return false;
            }
        }
        
        return true;
    }
    
    private void iniciarMatriz(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = "";
                matrizSelecion[i][j] = "";
            }
        }
        
        matrizSelecion[0][0] = "*";
    }
    
    private void refrescarImagen(){
        Consola.enviarString(getImagenes("nada").getPuntos());
        Consola.enviarString(getImagenes("lineas").getPuntos());
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String dato = matriz[i][j];
                
                if("*".equals(matrizSelecion[i][j])){
                    getImagenes("seleccionar").iniciarPuntos(18 * i, 18 * j);
                    Consola.enviarString(getImagenes("seleccionar").getPuntos());
                }
                if("x".equals(dato)){
                    getImagenes("equis").iniciarPuntos(18 * i, 18 * j);
                    Consola.enviarString(getImagenes("equis").getPuntos());
                }
                if("o".equals(dato)){
                    getImagenes("circulo").iniciarPuntos(18 * i, 18 * j);
                    Consola.enviarString(getImagenes("circulo").getPuntos());
                }
                
            }
        }
    }
    
    private void moverSeleccion(String tecla){
        for (int i = 0; i < 3; i++) {
            int cont = 0;
            for (int j = 0; j < 3; j++) {
                if("*".equals(matrizSelecion[i][j])){
                    if("w".equals(tecla) && i > 0){
                        matrizSelecion[i][j] = "";
                        matrizSelecion[i - 1][j] = "*";

                        refrescarImagen();
                        cont = 1;
                        break;
                    }
                    if("a".equals(tecla) && j > 0){
                        matrizSelecion[i][j] = "";
                        matrizSelecion[i][j - 1] = "*";
                            
                        refrescarImagen();
                        break;
                    }
                    if("s".equals(tecla) && i < 2){
                        matrizSelecion[i][j] = "";
                        matrizSelecion[i + 1][j] = "*";

                        refrescarImagen();
                        cont = 1;
                        break;
                    }
                    if("d".equals(tecla) && j < 2){
                        matrizSelecion[i][j] = "";
                        matrizSelecion[i][j + 1] = "*";

                        refrescarImagen();
                        cont = 1;
                        break;
                    }
                }
            }
            if(cont == 1)
                break;
        }
    }
    
    @Override
    public void run() {
        Consola.enviarString(getImagenes("lineas").getPuntos());
        Consola.enviarString(getImagenes("seleccionar").getPuntos());
        
        int turno = 0;
        int cont = 0;
        while(true){
            try {
                String tecla = Consola.entradas.teclado.remove(0);
                
                if("w".equals(tecla) || "a".equals(tecla) || "s".equals(tecla) || "d".equals(tecla))
                    moverSeleccion(tecla);
                else{
                    for (int i = 0; i < 3; i++) {
                        cont = 0;
                        for (int j = 0; j < 3; j++) {
                            if("*".equals(matrizSelecion[i][j])){
                                if("".equals(matriz[i][j])){
                                    if(juegoFinalizado()){
                                        iniciarMatriz();
                                        refrescarImagen();
                                        cont = 1;
                                        break;
                                    }
                                    
                                    if(turno == 0){
                                        matriz[i][j] = "x";
                                        turno = 1;
                                    }
                                    else{
                                        matriz[i][j] = "o";
                                        turno = 0;
                                    }
                                    
                                    cont = 1;
                                    refrescarImagen();
                                    break;
                                }
                                else
                                    if(juegoFinalizado()){
                                        iniciarMatriz();
                                        refrescarImagen();
                                        cont = 1;
                                        break;
                                    }
                            }
                        }
                        if(cont != 0)
                            break;
                    }
                }
                
            } catch (Exception e) {
            }
        }
    }
    
    
}
