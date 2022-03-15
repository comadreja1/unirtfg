/**
 * Clase que contiene el método main que ejecuta el programa.
 */


package tenis;

import controllers.ControllerMain;
import models.ModelMain;
import views.ViewMain;

// el nombre de la clase y paquete es el nombre del programa/aplicación
public class Tenis {   

   
    public static void main(String[] args) {
        ModelMain modelo = new ModelMain();
	ViewMain vista = new ViewMain();
	ControllerMain controlador = new ControllerMain(modelo, vista);
	
        
    } //fin main
    
} //fin clase