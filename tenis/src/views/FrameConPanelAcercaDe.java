/**
 * Archivo que implementa las clases de tipo JFrame y JPanel para mostrar un marco
 * emergente cuando se seleccione la opción -Acerca- de del marco principal.
 */


package views;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Console;
import javax.swing.*;
import java.awt.Frame;


public class FrameConPanelAcercaDe extends JFrame{

//campos
    
    PanelAcercaDe panelAcercaDe = new PanelAcercaDe();
	
	
//constructores
    public FrameConPanelAcercaDe() {
	setBounds(300,200,500,300);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setResizable(true);
	setTitle("Acerca de...");
		
	add(panelAcercaDe);
	setVisible(true);
		
    }//fin constructor

//métodos

}//fin clase FrameConPanelAyuda


class PanelAcercaDe extends JPanel{ //panel que se adjunta al Frame arriba creado
	
//campos
		
	
//constructores
    public PanelAcercaDe() {
        setBackground(Color.WHITE);		
    }
	
//métodos
	
    public void paintComponent(Graphics g) {
    super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawString("Autor: Agustín Durá Altet", 15, 20);
        g.setColor(Color.BLACK);
        g.drawString("Este software está creado como parte del Trabajo Fin de Grado", 15, 60);
	g.drawString("del Grado en Ingeniería Informática en la Universidad U.N.I.R.", 15, 80);
	g.drawString("del curso 2020/2021", 15, 100);

	
    }
}//fin clase PanelAyuda
