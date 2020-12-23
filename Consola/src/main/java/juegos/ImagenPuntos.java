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
    
    public boolean verificarColicion(String puntos){
        for (String infPunto : this.puntos.split(",")) {
            String[] punto = infPunto.split(":");
            
            for (String infPunto2 : puntos.split(",")) {
                String[] punto2 = infPunto2.split(":");

                if(punto[0].equals(punto2[0]) && punto[1].equals(punto2[1]))
                    return true;
            }
        }
        
        return false;
    }
    
    public boolean verificarColicion(String puntos, int colorOmitir){
        for (String infPunto : this.puntos.split(",")) {
            String[] punto = infPunto.split(":");
            
            if(Integer.valueOf(punto[2]) == colorOmitir)
                continue;
            
            for (String infPunto2 : puntos.split(",")) {
                String[] punto2 = infPunto2.split(":");
                
                if(Integer.valueOf(punto2[2]) == colorOmitir)
                    continue;
                
                if(punto[0].equals(punto2[0]) && punto[1].equals(punto2[1]))
                    return true;
            }
        }
        
        return false;
    }
    
    /**
     * Crea el string puntos en el formato requerido a partir del contenido del archivo.
     */
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
    
    /**
     * Crea el string puntos en el formato requerido a partir del contenido del 
     * archivo definiendo la posición del pixel inicial según las entradas.
     * @param fila
     * @param columna 
     */
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
