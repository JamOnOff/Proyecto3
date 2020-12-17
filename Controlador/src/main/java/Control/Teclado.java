/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Patatina
 */
public class Teclado implements KeyListener{
    
    private final static int numeroTeclas= 120;
    private boolean[]teclas= new boolean[numeroTeclas];
    
    public boolean arriba;
    public boolean abajo;
    public boolean izquierda;
    public boolean derecha;
    public boolean acción;
    
    public void actualizar(){
        arriba= teclas[KeyEvent.VK_UP];
        abajo= teclas[KeyEvent.VK_DOWN];
        izquierda= teclas[KeyEvent.VK_LEFT];
        derecha= teclas[KeyEvent.VK_RIGHT];
        acción= teclas[KeyEvent.VK_SPACE];
    }
    

   @Override
    public void keyTyped(KeyEvent e) {
        teclas[e.getKeyCode()] = true;
    }

    
    @Override
    public void keyPressed(KeyEvent e) {
        teclas[e.getKeyCode()] = false;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
