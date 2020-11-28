/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantalla;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import sockets.Cliente;

/**
 *
 * @author Josué Alvarez M
 */
public class Pantalla extends Thread{
    private final Ventana ventana;
    private final Pixel[][] pixeles;
    private final int ancho = 50;
    private final int alto = 50;
    
    private final Cliente cliente;
    
    public Pantalla() {
        this.cliente = new Cliente(9000);
        
        this.ventana = new Ventana();
        
        this.pixeles = new Pixel[alto][ancho];
        
        iniciarVentana();
        iniciarPixeles();
        start();
        
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

    public Pixel[][] getPixeles() {
        return pixeles;
    }
    
    public Pixel getPixeles(int fila, int columna){
        return pixeles[fila][columna];
    }
    
    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }
    
    @Override
    public void run(){
        while(true){
            try{
                if(!cliente.getDatos().isEmpty()){
                    int fila, columna, color;
                    String[] punto;
                    for (String puntoInf : cliente.getDatos(0).split(",")) {
                        punto = puntoInf.split(":");
                        fila = Integer.valueOf(punto[0]);
                        columna = Integer.valueOf(punto[1]);

                        if(punto[2] != "?"){
                            color = Integer.valueOf(punto[2]);
                            getPixeles(fila, columna).setColor(color);
                        }
                        else{
                            cliente.getSalida().writeUTF(fila + ":" + columna + ":" + getPixeles(fila, columna).getColor());
                        }
                    }
                }
            } catch(Exception e){}
        }
    }
}
