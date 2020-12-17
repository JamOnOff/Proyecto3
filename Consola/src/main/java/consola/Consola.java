/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consola;

import clases.Archivo;
import juegos.Gato;
import juegos.Juego;
import sockets.Cliente;

/**
 *
 * @author Josué Alvarez M
 */
public class Consola{
    public static final Cliente cliente = new Cliente(9000);
    public static final Entradas entradas = new Entradas(cliente);
    
    public static final String dirImagenes = (new Archivo("imagenes.txt")).getDireccion() + "/" + (new Archivo("imagenes.txt")).getNombre().replaceFirst(".txt", "") + "/";
    private final Juego juego;
    
    public Consola() {
        
        juego = new Gato();
    }
    
    public static void enviarString(String mensaje){
        try {
            cliente.getSalida().writeUTF(mensaje);
        } catch (Exception e) {}
    }
    
    public static String getRespuesta(){
        while(cliente.getDatos().isEmpty()){
        }
        
        return cliente.getDatos().remove(0);
    }
    
    
}
