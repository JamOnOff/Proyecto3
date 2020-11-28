/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consola;

import sockets.Cliente;

/**
 *
 * @author Josué Alvarez M
 */
public class Consola{
    private final Cliente cliente;

    public Consola(){
        this.cliente = new Cliente(9000);
        
        try{
            cliente.getSalida().writeUTF("0:0:?,0:1:?,1:0:?,1:1:?");
        } catch(Exception e){}
    }
}
