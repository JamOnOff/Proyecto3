/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantalla;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

/**
 *
 * @author Josué Alvarez M
 */
public class Pantalla {
    private final Ventana ventana;
    private final Pixel[][] pixeles;
    private int ancho = 50;
    private int alto = 50;
    
    public Pantalla() {
        this.ventana = new Ventana();
        
        this.pixeles = new Pixel[alto][ancho];
        
        iniciarVentana();
        iniciarPixeles();
        
        this.ventana.setVisible(true);
    }
    
    private void iniciarVentana(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int ancho = (int) screenSize.getWidth();
        int alto = (int) screenSize.getHeight();
        this.ventana.setSize(ancho - 64, alto - 64);
        this.ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void iniciarPixeles(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        int tam;
        if(screenSize.getHeight() / alto < screenSize.getWidth() / ancho)
            tam = (int) screenSize.getHeight() / alto;
        else
            tam = (int) screenSize.getWidth() / ancho;
        
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                pixeles[i][j] = new Pixel(tam);
                pixeles[i][j].getJLabel().setLocation(tam * j, tam * i);
                this.ventana.panelPrincipal.add(pixeles[i][j].getJLabel());
            }
        }
    }
}
