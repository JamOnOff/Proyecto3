/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import sockets.Servidor;

/**
 *
 * @author Josué Alvarez M
 */
public class Controlador extends Thread implements KeyListener{
    private final Servidor servidor;
    private final ArrayList<String> entrada = new ArrayList();
    private final Ventana ventana;
    
    public Controlador() {
        this.servidor = new Servidor(9000);
        this.ventana = new Ventana();
        
        this.ventana.addKeyListener(this);
        
        this.ventana.setVisible(true);
        start();
    }
    
    @Override
    public void run(){
        while(true){
            try{if(!servidor.getCliente(0).getDatos().isEmpty()){
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

    @Override
    public void keyTyped(KeyEvent e) {
        String t = String.valueOf(e.getKeyChar());
        
        if("w".equals(t) || "a".equals(t) || "s".equals(t) || "d".equals(t) || " ".equals(t) ){
            entrada.add(t);
            try {
                servidor.getCliente(1).getSalida().writeUTF(t);
            } catch (Exception ex) {
            }
            System.out.println(t);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
}
