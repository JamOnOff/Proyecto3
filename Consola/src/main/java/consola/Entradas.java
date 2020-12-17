/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consola;

import java.util.ArrayList;
import sockets.Cliente;

/**
 *
 * @author Josué Alvarez M
 */
public class Entradas extends Thread{
    private final Cliente cliente;
    
    public final ArrayList<String> pixeles = new ArrayList();
    public final ArrayList<String> teclado = new ArrayList();

    public Entradas(Cliente cliente) {
        this.cliente = cliente;
        
        start();
    }
    
    @Override
    public void run(){
        while(true){
            try{
                String dato = cliente.getDatos().remove(0);
                
                if(dato.length() == 1) 
                    teclado.add(dato);
                else if(dato.length() > 1)
                    pixeles.add(dato);
            } catch(Exception e){}
        }
    }
}
