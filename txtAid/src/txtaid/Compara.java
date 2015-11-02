
package txtaid;
public class Compara {
    
     private String textoAEntero(String cadena){
        String valor="";
        for(int i=0;i<cadena.length();i++){
            if(Integer.toString(cadena.charAt(i)).length()==3){
                valor=valor+Integer.toString(cadena.charAt(i));
            }else if(Integer.toString(cadena.charAt(i)).length()==2){
                valor=valor+"0"+Integer.toString(cadena.charAt(i));
            }else if(Integer.toString(cadena.charAt(i)).length()==1){
                valor=valor+"00"+Integer.toString(cadena.charAt(i));
            }
        }
        return valor;
    }
     
     private boolean AesMasLargoQueB(String A, String B){
        return A.length()>B.length();
    }
     
    
    public boolean AEsMayorQueB(String  A,String B){
        String num1=textoAEntero(A);
        String num2=textoAEntero(B);
        String MENOR,MAYOR;
        if(AesMasLargoQueB(A, B)){
            MAYOR=A.substring(0,B.length());
            MENOR=B;
        }else{
            MAYOR=A;
            MENOR=B.substring(0, A.length());
        }
        for(int i=0;i<MENOR.length();i++){
            if(MAYOR.charAt(i)<MENOR.charAt(i)){
                return false;
            }else if(MAYOR.charAt(i)>MENOR.charAt(i)){
                return true;
            }
        }
        return A.length()>B.length();
    }
}
