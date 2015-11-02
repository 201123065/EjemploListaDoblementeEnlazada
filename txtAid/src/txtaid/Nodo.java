
package txtaid;

public class Nodo {

    String Cadena;
    Nodo izquierda,derecha;
    
    public Nodo(String Cadena){
        this(Cadena,null,null);
    }
    
    public Nodo(String Cadena, Nodo izquierda, Nodo derecha){
        this.Cadena=Cadena;
        this.izquierda=izquierda;
        this.derecha=derecha;
    }
    
}
