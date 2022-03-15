/**
 * clase que implementa las operaciones básicas de lectura y escritura sobre archivos
 * de caracteres(texto). 
 * 
 */

package models;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class LectorEscritorArchivoTexto {
	
    // campos (variables de instancia y/o de clase(static))
	
    private Scanner sc;
    private BufferedReader br;
    private FileReader fr;
    private File f;
    private String linea;
    private FileWriter fw;
    private BufferedWriter bw;
    
    // constructores 
	
    public LectorEscritorArchivoTexto() {
	this.sc = null;
	this.br = null;
	this.fr = null;
	this.f = null;
        this.fw = null;
        this.bw = null;
    } // fin de constructor
	
    
    // métodos (funciones y procedimientos)
	
    /**
     * Método que se encarga de leer el archivo que constituye la base de datos y los 
     * devuelve en un listado con tipo ArrayList.
     */
    public ArrayList<TuplaCaracteristicas> lectorBufferedReader() {
        ArrayList<TuplaCaracteristicas> lista = new ArrayList<>();
        try {            
            String cadenas[];
            f = new File("src/files/data/baseDatosCaracteristicasTenis.txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            while ( (linea=br.readLine()) != null) {
		//System.out.println(stringAux);
                cadenas = linea.split(" ");
                int enteros[] = new int[4];
                for (int i=0; i<4; i++){
                    enteros[i] = Integer.parseInt(cadenas[i]);                    
                }
                lista.add(new TuplaCaracteristicas(enteros[0],enteros[1],enteros[2],enteros[3]));
            } // fin while lectura
           
	} // fin try
        catch (Exception e) {
            e.printStackTrace();
	}
	finally {
            try {
                if(fr != null) {
                    fr.close();
		}
            }
            catch(Exception e) {
		e.printStackTrace();
            }
	}
         return lista;
    } // fin método
    
    
/** método que escribe datos en un archivo de texto creándolo si no existe o añadiendo
 * datos a los ya existentes si existe
 * Utiliza un buffer que hay que vaciarlo antes de cerrar el FileWriter.
 */
    
    public void escritorBufferedWriterAppend(int[] n) {
        try {
            f = new File("src/files/data/baseDatosCaracteristicasTenis.txt");
            fw = new FileWriter(f,true);
            bw = new BufferedWriter(fw);
            //bw.write("linea añadida sin descartar datos existentes");
            String s="" + n[0] + " " + n[1] + " " + n[2] + " " + n[3];
            bw.write(s);
            bw.newLine();
            bw.flush();
	}
        catch (Exception e) {
            e.printStackTrace();
	}
	finally {
            try {
                if(fw != null) {
                    fw.close();
		}
            }
            catch(Exception e) {
		e.printStackTrace();
            }
	}
        
    } // fin método
    
           
            
} // fin clase