/**
 * Clase que implementa los datos que componen la tupla de características
 * a considerar para efectuar cálculos.
 */

package models;

public class TuplaCaracteristicas {
    
    // campos - variables
    
    private int rankingATP;
    private int racha;
    private int enfrentamientos;
    private int victoria;
    
    
    // constructores
    
    public TuplaCaracteristicas(int rank, int racha, int enf, int vic){
        setRanking(rank);
        setRacha(racha);
        setEnfrentamientos(enf);
        setVictoria(vic);
    }
    
    
    // métodos - funciones
    
    /**
     * Método que devuelve la característica correspondiente al ranking ATP/WTA
     * @return devuelve un entero
     */
    public int getRanking(){
        return this.rankingATP;
    }
    
    /**
     * Método que establece la característica correspondiente al ranking ATP/WTA
     * @param rank - un entero que será la característica ranking ATP/WTA
     */
    public void setRanking(int rank){
        this.rankingATP = rank;
    }
    
    /**
     * Método que devuelve la característica correspondiente a la racha
     * @return devuelve un entero
     */
    public int getRacha(){
        return this.racha;
    }
    
    /**
     * Método que establece la característica correspondiente a la racha
     * @param racha - un entero que será la característica racha
     */
    public void setRacha(int racha){
        this.racha = racha;
    }
    
    /**
     * Método que devuelve la característica correspondiente a enfrentamientos
     * @return - un entero 
     */
    public int getEnfrentamientos(){
        return this.enfrentamientos;
    }
    
    /**
     * Método que establece la característica correspondiente a enfrentamientos
     * @param enf - entero que corresponde a enfrentamientos
     */
    public void setEnfrentamientos(int enf){
        this.enfrentamientos = enf;
    }
    
    /**
     * Método que devuelve el resultado acontecido en dicho partido de tenis
     * @return - un entero que corresponde a la victoria del primer o segundo tenista
     */
    public int getVictoria(){
        return this.victoria;
    }
    
    /**
     * Método que establece el resultado acontecido en dicho partido de tenis
     * @param vic - un entero que corresponde a la victoria del primer o segundo tenista
     */
    public void setVictoria(int vic){
        this.victoria = vic;
    }
    
    /**
     * Método sobreescrito para representar correctamente los valores de la tupla
     * correspondientes a un partido de tenis
     * @return un objeto String
     */
    @Override
    public String toString(){
        String s="                  ";
        String str = "" + getRanking() + s + getRacha() + s + getEnfrentamientos() + s + getVictoria();
        return str;
    }
    
} // fin clase
