/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegos;

import clases.Archivo;

/**
 *
 * @author Josué Alvarez M
 */
public class ImagenPuntos {
    private final Archivo archivo;
    private String puntos;
    public final String ID;
    
    private final int colorFondo;
    
    public ImagenPuntos(String ID, Archivo archivo, int colorFondo) {
        this.archivo = archivo;
        this.ID = ID;
        this.colorFondo = colorFondo;
        
        iniciarPuntos();
    }
    
    public void iniciarPuntos(){
        puntos = "";
        
        int fila = 0;
        int columna;
        
        for (String inf : archivo.getTexto().split("\n")) {
            columna = 0;
            for (String num : inf.split(";")) {
                if(colorFondo != Integer.valueOf(num)){
                    if(!"".equals(puntos))
                        puntos += "," + fila + ":" + columna + ":" + num;
                    else
                        puntos = fila + ":" + columna + ":" + num;
                }
                columna ++;
            }
            fila ++;
        }
    }
    
    public void iniciarPuntos(int fila, int columna){
        puntos = "";
        
        int columnaIni = columna;
        
        for (String inf : archivo.getTexto().split("\n")) {
            columna = columnaIni;
            for (String num : inf.split(";")) {
                if(colorFondo != Integer.valueOf(num)){
                    if(!"".equals(puntos))
                        puntos += "," + fila + ":" + columna + ":" + num;
                    else
                        puntos = fila + ":" + columna + ":" + num;
                }
                columna ++;
            }
            fila ++;
        }
    }

    public Archivo getArchivo() {
        return archivo;
    }

    public String getPuntos() {
        return puntos;
    }
    
    
}
