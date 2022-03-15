/** 
 * La clase ViewMain es la clase de vista principal
 * Las clases del paquete views son las encargadas de mostrar en pantalla el resultado
 * de la ejecución del programa con el diseño de interfaz gráfica de usuario (GUI)
 * diseñada para ello
 * Esta clase debe disparar los eventos que serán recogidos y tratados en el controlador
 * Los eventos que no afecten a la lógica del programa serán recogidos y tratados en esta
 * vista.
 */

package views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ViewMain extends JFrame {
	
//campos - variables de instancia
   
    private int heightScreen, widthScreen;
   
    private JMenuBar barraMenu = new JMenuBar();
    private JMenu menuArchivo = new JMenu("Archivo");
    public   JMenuItem itemImprimir = new JMenuItem("Imprimir");   
    public   JMenuItem itemPropiedades = new JMenuItem("Propiedades");
    private    JMenuItem itemSalir = new JMenuItem("Salir");    
        
    private JMenu menuAyuda = new JMenu("Ayuda");
    private   JMenuItem itemAcercaDe = new JMenuItem("Acerca de");
    private   JMenuItem itemInformacion = new JMenuItem("Información");
          
    private JPanel panelMain = new JPanel(new BorderLayout());
    private JPanel panelBotonesWest = new JPanel();
    private JTextPane textPane = new JTextPane();
    private JScrollPane scrollPane = new JScrollPane(textPane);
    public JButton botonSolicitarPrevision, botonAnadirRegistro, botonBorrarTexto;
	
//constructores
    
    public ViewMain() {
	setTitle("predicción resultados de partidos de tenis");			//establece un titulo para el Frame
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //salir cuando hace clic en icono cerrar
                
	setBounds(250,150,700,400);			//establece la ubicación y tamaño del Frame
	setResizable(true);				//Frame redimensionable o no(false)
	setLocationRelativeTo(null);			//establece la ubicación del Frame centrándolo	
                                                        //e ignorando coordenadas de setBounds
                                                                
	setExtendedState(MAXIMIZED_BOTH);		//inicializa el Frame maximizado
		
	Toolkit pantalla = Toolkit.getDefaultToolkit(); //fuentes de caracteres, imagenes, impresion y parametros por pantalla
	Dimension tamanoPantalla = pantalla.getScreenSize(); //encapsula el ancho y alto de un componente
	heightScreen = tamanoPantalla.height;			
	widthScreen  = tamanoPantalla.width;
        
	setJMenuBar(barraMenu);             //fijar barra menus y menus						//menus
	barraMenu.setBorderPainted(false);

        barraMenu.add(menuArchivo); 
        menuArchivo.setMnemonic('a'); // alt+a lo despliega      
        menuArchivo.add(itemImprimir);      
        menuArchivo.add(itemPropiedades);
        menuArchivo.add(itemSalir);	               
                  
	barraMenu.add(menuAyuda);
        menuAyuda.setMnemonic('y');
        menuAyuda.add(itemAcercaDe);
        menuAyuda.add(itemInformacion);
       
        //establecer el frame con panel en disposición BorderLayout
	panelBotonesWest.setLayout(new BoxLayout(panelBotonesWest, BoxLayout.Y_AXIS));
        botonSolicitarPrevision = new JButton("Solicitar predicción");
        botonAnadirRegistro = new JButton("Añadir registro");
        botonBorrarTexto = new JButton("Borrar panel texto");      
	panelBotonesWest.add(botonSolicitarPrevision);
	panelBotonesWest.add(botonAnadirRegistro);
	panelBotonesWest.add(botonBorrarTexto);     
      
        textPane.setEditable(false);
        textPane.setEnabled(true);
	panelMain.add(panelBotonesWest, BorderLayout.WEST);         
        panelMain.add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(panelMain);       //getContentPane() para luego cambiar JPanel
       			
	anadirEventosMenu();
                
	setVisible(true);   //hace Frame visible - siempre incluirlo al final del constructor
                
    }//fin constructor
	
	
//métodos - funciones
	
    /**
     * Método que tiene por finalidad añadir eventos a los elementos del menú y del panel.
     */
    private void anadirEventosMenu(){		//añadir eventos a menus y botones
			
        itemSalir.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }   });		
       
        itemAcercaDe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FrameConPanelAcercaDe();
            }   });	 
        
        itemInformacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imprimirRetorno();
                imprimirTextoConRetorno("Aplicación para predicción de resultados de tenis.");
                imprimirTextoConRetorno("El set de datos tiene cuatro números enteros que corresponden a:");
                imprimirTextoConRetorno("1er entero   2º entero   3er entero    4º entero");
                imprimirTextoConRetorno("-----------------------------------------------------------------------------------------------");
                imprimirTextoConRetorno("ranking       racha      enfrentamientos     resultado");
                imprimirTextoConRetorno("-----------------------------------------------------------------------------------------------");
                imprimirTextoConRetorno("Ranking: expresa qué jugador tiene más puntuación ATP/WTA");
                imprimirTextoConRetorno("1-> el primero   2-> el segundo");
                imprimirTextoConRetorno("Racha: expresa qué jugador tiene mejor racha de los últimos 5 partidos:");
                imprimirTextoConRetorno("1-> el primero   2-> el segundo   3-> igualados");
                imprimirTextoConRetorno("Enfrentamientos: expresa qué jugador tiene mejores resultados entre ambos entre los últimos 5 enfrentamientos");
                imprimirTextoConRetorno("1-> el primero   2-> el segundo   3-> igualados o sin datos");
                imprimirTextoConRetorno("Resultado: expresa quién ganó el partido:");
                imprimirTextoConRetorno("1-> el primero   2-> el segundo");
                imprimirTextoConRetorno("-----------------------------------------------------------------------------------------------");
                imprimirTextoConRetorno("Cuando se solicita una predicción hay que introducir los 3 primeros datos.");
                imprimirTextoConRetorno("-----------------------------------------------------------------------------------------------");
                imprimirTextoConRetorno("Menu archivo -> imprimir: imprime la base de datos");
                imprimirTextoConRetorno("Menu archivo -> propiedades: indica cuantas entradas tiene la base de datos");
            }   });
        
        botonBorrarTexto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               borrarTextoJTextPane();
            }  });
                
   
    }//fin método anadirEventosMenu
    
    /**
     * Método que se encarga de borrar el texto del panel.
     */
    public void borrarTextoJTextPane(){
        textPane.setText("");
    }
    
    /**
     * Método que se encarga de imprimir un texto en el panel
     * @param text - recibe un obejto de tipo String que es el texto a mostrar.
     */
    public void imprimirTexto(String text){
        textPane.setText(textPane.getText() + text);
    }
    
    /**
     * Método que se encarga de imprimir texto en el panel añadiendo un retorno
     * de línea.
     * @param text - recibe un objeto de tipo String que es el texto a mostrar.
     */
    public void imprimirTextoConRetorno(String text){
        textPane.setText(textPane.getText() + text + "\n");
    }
        
    /**
     * Método que se encarga de imprimir en el panel una línea de retorno
     */
    public void imprimirRetorno(){
        textPane.setText(textPane.getText() + "\n");
    }
    
    
}// fin clase
