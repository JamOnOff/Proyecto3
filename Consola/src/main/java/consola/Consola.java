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
    private static final Cliente cliente = new Cliente(9000);
    private Juego juego = new Gato();
    public static final String dirImagenes = (new Archivo("imagenes.txt")).getDireccion() + "/" + (new Archivo("imagenes.txt")).getNombre().replaceFirst(".txt", "") + "/";
    
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

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
        juego.start();
    }
    
    
}
