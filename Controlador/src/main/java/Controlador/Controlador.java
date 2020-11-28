/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import sockets.Servidor;

/**
 *
 * @author Josué Alvarez M
 */
public class Controlador extends Thread{
    private final Servidor servidor;

    public Controlador() {
        this.servidor = new Servidor(9000);
        
        start();
    }
    
    @Override
    public void run(){
        while(true){
            try{
                if(!servidor.getCliente(0).getDatos().isEmpty()){
                    for (String dato : servidor.getCliente(0).getDatos()) {
                        servidor.getCliente(1).getSalida().writeUTF(dato);
                    }
                    servidor.getCliente(0).getDatos().clear();
                }
                if(!servidor.getCliente(1).getDatos().isEmpty()){
                    for (String dato : servidor.getCliente(1).getDatos()) {
                        servidor.getCliente(0).getSalida().writeUTF(dato);
                    }
                    servidor.getCliente(1).getDatos().clear();
                }
            } catch(Exception e){}
        }
    }
}
