/**
 * La clase ControllerMain es la clase de control principal
 * Las clases del paquete controllers son las encargadas de efectuar consultas y solicitar 
 * actualizaciones a la parte que lleva los datos y la lógica de control que son las clases 
 * del modelo, en el paquete models; y de actualizar la vista, que son las clases del paquete views
 * Esta clase registra como oyente a elementos de la vista, que serán tratados en el método 
 * en el método eventHandler.
 */

package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import models.ModelMain;
import views.ViewMain;
import views.*;
import models.*;

public class ControllerMain {

//campos - variables de instancia
    private ModelMain modelo;
    private ViewMain vista;
    //private LectorEscritorArchivoTexto lectorEscritor;
  	
//constructores
    public ControllerMain(ModelMain m, ViewMain v){
	this.modelo = m;
	this.vista= v;
        eventHandler();
    } //fin constructor
	
	
//métodos - funciones
	
/** Método centralizado que trata los eventos que se implementan a través de clases internas 
 * anónimas
 * Implementa los métodos actionPerformed de las clases internas anónimas 
 * pasadas por parámetro al método .addActionListener(new ActionListener(){public void 
 * actionPerformed(ActionEvent e){...}}); que se añadirán a componentes de la GUI
 */
    public void eventHandler() {
	vista.itemImprimir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){	
                ArrayList<TuplaCaracteristicas> listaTuplas = modelo.getListaTuplas();
                vista.imprimirTextoConRetorno("Se muestra el resultado de la impresión de la base de datos:");
                vista.imprimirTextoConRetorno("----------------------------------------------------------------------------------------");
                vista.imprimirTextoConRetorno("ranking        racha        enfrentam.    victoria     registro nº");
                vista.imprimirRetorno();
                int n=0;
                for (int i=0; i<listaTuplas.size(); i++){
                    n=i+1;
                    vista.imprimirTextoConRetorno("  " +listaTuplas.get(i).toString() + "            nº: " + n);
                }
                vista.imprimirRetorno(); 
        } });        
        
        vista.itemPropiedades.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){	
                ArrayList<TuplaCaracteristicas> listaTuplas = modelo.getListaTuplas();
                int n = listaTuplas.size();
                vista.imprimirTexto("El tamaño de la base de datos es de: ");
                vista.imprimirTextoConRetorno("" + n + " registros");
                vista.imprimirRetorno();
        } });  
        
        vista.botonSolicitarPrevision.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){	
                String str="Introduzca datos del partido a predecir separado por espacios: (ej:  1 1 1)\nQue corresponden a: ranking, racha, enfrentamientos";
                String str2="1 1 1";
                String s = JOptionPane.showInputDialog(vista, str,str2);
                int i1, i2, i3;
                String cadena[];
                cadena = s.trim().split(" ");
                if(cadena.length != 3){
                    JOptionPane.showMessageDialog(vista,"Error. Ha introducido un número incorrecto de valores");      
                }else {
                    try{
                    i1 = Integer.parseInt(cadena[0]);
                    i2 = Integer.parseInt(cadena[1]);
                    i3 = Integer.parseInt(cadena[2]);
                    if( (i1>2) || (i1<1) || (i2>3) || (i2<1) || (i3>3) || (i3<1) ){
                        JOptionPane.showMessageDialog(vista,"Error. Ha introducido valor/es de rango incorrecto");      
                    }else{ 
                        //JOptionPane.showMessageDialog(vista,"Ok. Se procederá a hacer una prediccion");
                        int enteros[] = new int[]{i1,i2,i3};
                        int predNaive = modelo.generarPrediccionNaiveBayes(enteros);
                        int predArbol = modelo.generarPrediccionArbolDecision(enteros);
                        if (predArbol ==3){
                            JOptionPane.showMessageDialog(vista, "Error en el procesamiento de datos en algoritmo de Árbol de decisión");
                        } else{
                            vista.imprimirTextoConRetorno("Predicción con Árbol decisión: " + predArbol);
                        }
                        vista.imprimirTextoConRetorno("Prediccion con Naive-Bayes: " + predNaive);
                        vista.imprimirRetorno();
                    } 
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(vista,"Error. Ha introducido valor/es de tipo incorrecto");      
                        ex.printStackTrace();
                    }  
                } 
                
                
        } });  
        
        vista.botonAnadirRegistro.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){	
                String str="Introduzca datos del nuevo registro separado por espacios: (ej:  1 1 1 1)";
                String s = JOptionPane.showInputDialog(vista, str);
                int i1, i2, i3, i4;
                String cadena[];
                cadena = s.trim().split(" ");
                if(cadena.length != 4){
                    JOptionPane.showMessageDialog(vista,"Error. Ha introducido un número incorrecto de valores");      
                }else {
                    try{
                    i1 = Integer.parseInt(cadena[0]);
                    i2 = Integer.parseInt(cadena[1]);
                    i3 = Integer.parseInt(cadena[2]);
                    i4 = Integer.parseInt(cadena[3]);
                    if( (i1>2) || (i1<1) || (i2>3) || (i2<1) || (i3>3) || (i3<1) || (i4>2) || (i4<1) ){
                        JOptionPane.showMessageDialog(vista,"Error. Ha introducido valor/es de rango incorrecto");      
                    }else{ 
                        int enteros[] = new int[]{i1,i2,i3,i4};
                        modelo.anadirRegistro(enteros);
                    } 
                    }
                    catch(Exception ex){
                        JOptionPane.showMessageDialog(vista,"Error. Ha introducido valor/es de tipo incorrecto");      
                        ex.printStackTrace();
                    }  
                } 
            } });  
        
    } // fin método eventHanler
		

} // fin clase ControllerMain
