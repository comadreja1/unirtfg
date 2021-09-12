/**
 * La clase ModelMain es la clase de modelo principal
 * Las clases del paquete models son las encargadas de la lógica del negocio y de almacenar
 * y actualizar datos
 * Las solicitudes de envio y actualización de datos le llegan desde un controlador, no directamente 
 * desde la vista.
 */

package models;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ModelMain {
	
//campos - variables de instancia
    
    private ArrayList<TuplaCaracteristicas> listaTuplas;
    private LectorEscritorArchivoTexto lectorEscritor;
	
//constructores
    public ModelMain(){
	this.listaTuplas = null;
        lectorEscritor = new LectorEscritorArchivoTexto();
        cargarDatos();
    }

	
//métodos - funciones
	
    /**
     * Método que lee datos desde el archivo usado para base de datos y los carga en
     * en un ArrayList que es la contenedora de la base de datos en memoria.
     */
    public void cargarDatos(){
        this.listaTuplas = lectorEscritor.lectorBufferedReader();
    }
    
    /**
     * Método que devuelve el ArrayList contenedor de la base de datos.
     */
    public ArrayList<TuplaCaracteristicas> getListaTuplas(){
        return this.listaTuplas;
    }
    
    /**
     * Método que se encarga de escribir un nuevo registro en la base de datos.
     */
    public void anadirRegistro(int[] n){
        lectorEscritor.escritorBufferedWriterAppend(n);
        cargarDatos();
    }
    
    /**
     * Método que efectúa cálculos para una predicción con la técnica Naive Bayes
     * devuelve un entero que es el resultado a mostrar.
     */
    public int generarPrediccionNaiveBayes(int[] n){
        //System.out.println("NaiveBayes: " + n[0] + n[1] + n[2]);
        int nTotP = listaTuplas.size();     // nº total de partidos
        int vic1 = 0;
        int vic2 = 0;
        int atp1c1 = 0;
        int rac1c2 = 0;
        int enf1c3 = 0;
        int atp2c1 = 0;
        int rac2c2 = 0;
        int enf2c3 = 0;
        double resultadoV1 = 0;
        double resultadoV2 = 0;
        
        for (int i = 0; i < nTotP; i++){
            TuplaCaracteristicas tupla= listaTuplas.get(i);
            if(tupla.getVictoria() == 1) { 
                vic1++; 
                if(tupla.getRanking() == n[0])         { atp1c1++; }
                if(tupla.getRacha() == n[1])           { rac1c2++; }
                if(tupla.getEnfrentamientos() == n[2]) { enf1c3++; }
            }
            if(tupla.getVictoria() == 2) { 
                vic2++; 
                if(tupla.getRanking() == n[0])         { atp2c1++; }
                if(tupla.getRacha() == n[1])           { rac2c2++; }
                if(tupla.getEnfrentamientos() == n[2]) { enf2c3++; }        
            }
            
        } //fin for(1 to n)
             
        resultadoV1 = ((double)vic1/(double)nTotP) * ((double)atp1c1/(double)vic1) * ((double)rac1c2/(double)vic1) * ((double)enf1c3/(double)vic1);
        resultadoV2 = ((double)vic2/(double)nTotP) * ((double)atp2c1/(double)vic2) * ((double)rac2c2/(double)vic2) * ((double)enf2c3/(double)vic2);
        if (resultadoV1 > resultadoV2){
            return 1;
        } else return 2;
    }
    
    /**
     * Método que efectúa el camino descendente por el árbol para hallar la solución a
     * la consulta de predicción
     * Devuelve un entero que es el resultado esperado.
     */
    public int generarPrediccionArbolDecision(int[] n){
        if(n[0] == 1){
            if(n[2] == 1){
                if     (n[1]==1) { return 1; }
                else if(n[1]==2) { return 2; }
                else if(n[1]==3) { return 1; }
            }else if (n[2]==2){
                if     (n[1]==1) { return 1; }
                else if(n[1]==2) { return 2; }
                else if(n[1]==3) { return 1; }
            }else {
                if     (n[1]==1) { return 1; }
                else if(n[1]==2) { return 2; }
                else if(n[1]==3) { return 1; }
            }
            
        }else {
            if(n[2] == 1){
                if     (n[1]==1) { return 1; }
                else if(n[1]==2) { return 2; }
                else if(n[1]==3) { return 2; }
            }else if (n[2]==2){
                if     (n[1]==1) { return 1; }
                else if(n[1]==2) { return 2; }
                else if(n[1]==3) { return 2; }
            }else {
                if     (n[1]==1) { return 1; }
                else if(n[1]==2) { return 2; }
                else if(n[1]==3) { return 2; }
            }
        } 
        return 3; // resultado incorrecto que será capturado en el método que hace llamada
    }
    
} // fin clase 
