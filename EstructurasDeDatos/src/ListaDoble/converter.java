/*convertidor de archivos:
TEXTO A NUMERO
*/


package ListaDoble;

import ListaDoble.Nodo;
import ListaDoble.Compara;

public class converter {
    
    //esta es la condicional que define si es mayor o no
    private Compara compararSi= new Compara();
    //declarar desde el inicio como vacios los nodos
    private Nodo inicio=null,fin=null;
    //determinar si esta vacia la lista
    private Boolean estaVacia(){return inicio==null;}
    //accion publica para insertar nodo
    public boolean insertar(String Cadena){return insertar(Cadena,inicio);}
    private boolean insertar(String Cadena,Nodo tmp)
    {
        if(estaVacia()){
            inicio=fin=new Nodo(Cadena);
            return true;
        }
        else if(tmp==null){
            Nodo temporal=fin;
            fin.derecha=new Nodo(Cadena);
            fin=fin.derecha;
            fin.izquierda=temporal;
            temporal.derecha=fin;
            return true;
        }else{
            if(!Cadena.equals(tmp.Cadena))
            {
                if(compararSi.AEsMayorQueB(Cadena, tmp.Cadena)){
                    return insertar(Cadena, tmp.derecha);
                }else{
                    Nodo temporal=new Nodo(Cadena);
                    if(tmp.izquierda==null){
                        inicio.izquierda= temporal;
                        temporal=inicio;
                        inicio=inicio.izquierda;
                        inicio.derecha=temporal;
                    }else{
                        temporal.derecha=tmp;
                        temporal.izquierda=tmp.izquierda;
                        tmp.izquierda.derecha=tmp.izquierda=temporal;
                    }
                    return true;
                }
        
            }
            return false;
        }
    }
    
    public boolean Eliminar(String Cadena){
        return Eliminar(Cadena,inicio);
    }
    public boolean Eliminar(String Cadena, Nodo tmp){
        if(tmp!=null){
            if(tmp.Cadena.equals(Cadena)){
                if(tmp.izquierda==null&&tmp.derecha==null)
                {inicio=fin=null;}
                else if(tmp.izquierda!=null&&tmp.derecha==null){
                    fin=fin.izquierda;
                    fin.derecha=null;
                }else if(tmp.izquierda==null&&tmp.derecha!=null){
                    inicio=inicio.derecha;
                    inicio.izquierda=null;
                }else{
                    tmp.izquierda.derecha=tmp.derecha;
                    tmp.derecha.izquierda=tmp.izquierda;
                }
                return true;
            }else
            {
               return Eliminar(Cadena, tmp.derecha);
            }
        }        
        return false;
    }
    public boolean modificar(String antiguo, String nuevo){
        if(Eliminar(antiguo))
        {
            insertar(nuevo);
            return true;
        }else{
            return false;
        }
    }
    
    
    public Nodo retornarVal(){
        return inicio;
    }
    
    public String Listado(){
        String retorno ="";
        Nodo temporal=inicio;
        while(temporal!=null){
            retorno = (retorno.equals(""))?temporal.Cadena:retorno+"\n"+temporal.Cadena;
            temporal=temporal.derecha;
        }
        return retorno;
    }
    
}
