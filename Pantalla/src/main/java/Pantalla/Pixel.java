/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pantalla;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Josué Alvarez M
 */
public class Pixel {
    private final JLabel pixel;
    private int color;
    
    public static final int BLANCO = 0;
    public static final int AZUL = 1;
    public static final int VERDE = 2;
    public static final int CYAN = 3;
    public static final int ROJO = 4;
    public static final int MAGENTA = 5;
    public static final int CAFE = 6;
    public static final int GRIS_CLARO = 7;
    public static final int GRIS_OSCURO = 8;
    public static final int AZUL_CLARO = 9;
    public static final int VERDE_CLARO = 10;
    public static final int CYAN_CLARO = 11;
    public static final int ROJO_CLARO = 12;
    public static final int MAGENTA_CLARO = 13;
    public static final int AMARILLO = 14;
    public static final int NEGRO = 15;
    
    public Pixel(int tam) {
        pixel = new JLabel();
        pixel.setOpaque(true);
        pixel.setSize(tam, tam);
        setColor(BLANCO);
    }
    
    public void setColor(int color){
        if(color >= 0 && color < 16){
            this.color = color;
            
            switch (color) {
                case NEGRO:
                    pixel.setBackground(Color.BLACK);
                    break;
                case AZUL:
                    pixel.setBackground(Color.BLUE);
                    break;
                case VERDE:
                    pixel.setBackground(Color.decode("#008600"));
                    break;
                case CYAN:
                    pixel.setBackground(Color.decode("#00C9B0"));
                    break;
                case ROJO:
                    pixel.setBackground(Color.decode("#CD1C1C"));
                    break;
                case MAGENTA:
                    pixel.setBackground(Color.decode("#CB25A9"));
                    break;
                case CAFE:
                    pixel.setBackground(Color.decode("#5F3F26"));
                    break;
                case GRIS_CLARO:
                    pixel.setBackground(Color.LIGHT_GRAY);
                    break;
                case GRIS_OSCURO:
                    pixel.setBackground(Color.DARK_GRAY);
                    break;
                case AZUL_CLARO:
                    pixel.setBackground(Color.decode("#5D5DFF"));
                    break;
                case VERDE_CLARO:
                    pixel.setBackground(Color.GREEN);
                    break;
                case CYAN_CLARO:
                    pixel.setBackground(Color.CYAN);
                    break;
                case ROJO_CLARO:
                    pixel.setBackground(Color.RED);
                    break;
                case MAGENTA_CLARO:
                    pixel.setBackground(Color.MAGENTA);
                    break;
                case AMARILLO:
                    pixel.setBackground(Color.YELLOW);
                    break;    
                case BLANCO:
                    pixel.setBackground(Color.WHITE);
                    break;
                default:
                    pixel.setBackground(Color.WHITE);
                    break;
            }
        }
    }

    public int getColor() {
        return color;
    }

    public JLabel getJLabel() {
        return pixel;
    }
    
    
}
