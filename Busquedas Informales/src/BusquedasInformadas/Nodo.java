
package BusquedasInformadas;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Mario R�os
 */
public class Nodo {
    private String estado;
    private Collection<Nodo> hijos;
    Nodo padre;
    
    public Nodo(String estado)
    {
        this.estado = estado;
        hijos = new ArrayList<>();
    }

    public String getEstado() {
        return estado;
    }

    public Collection<Nodo> getHijos() {
        return hijos;
    }

    //Agrega 1 Nodo hijo
    public void agregarHijos(Nodo h) {
        this.hijos.add(h);
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public Collection<String> generaHijos() {
        //|0|1|2|
        //|3|4|5|   Indices
        //|6|7|8|
    	ArrayList<String>hijosGenerados=new ArrayList<>();
        int i = estado.indexOf(" ");//Obtengo el indice del espacio
        String estadoTemp;
        switch(i)
        {
        /*
		Usar los métodos: replace, charAt
		Otra idea es pasar el String a Matriz, hacer los cambios y luego pasarlo a String... xD		
		*/
            case 0:
      
            	estadoTemp=""+estado.charAt(1)+estado.charAt(0)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);

            	estadoTemp=""+estado.charAt(3)+estado.charAt(1)+estado.charAt(2)+estado.charAt(0)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);
            	

               
                break;
            case 1:
            	estadoTemp=""+estado.charAt(1)+estado.charAt(0)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(2)+estado.charAt(1)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(4)+estado.charAt(2)+estado.charAt(3)+estado.charAt(1)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);

            
                break;
            case 2:
            	estadoTemp=""+estado.charAt(0)+estado.charAt(2)+estado.charAt(1)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(5)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(2)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);

            	
            	break;
            case 3:
            	estadoTemp=""+estado.charAt(3)+estado.charAt(1)+estado.charAt(2)+estado.charAt(0)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(4)+estado.charAt(3)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(6)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(3)+estado.charAt(7)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);

            	break;
            case 4: 
            	estadoTemp=""+estado.charAt(0)+estado.charAt(4)+estado.charAt(2)+estado.charAt(3)+estado.charAt(1)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(4)+estado.charAt(3)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(5)
            	+estado.charAt(4)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(7)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(4)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);


            	break;
            case 5:
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(5)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(2)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(5)
            	+estado.charAt(4)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(8)+estado.charAt(6)+estado.charAt(7)+estado.charAt(5);
            	hijosGenerados.add(estadoTemp);

            	break;
            case 6:
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(6)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(3)+estado.charAt(7)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(7)+estado.charAt(6)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);
            	break;
            case 7:
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(7)+estado.charAt(6)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(7)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(4)+estado.charAt(8);
            	hijosGenerados.add(estadoTemp);
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(8)+estado.charAt(7);
            	hijosGenerados.add(estadoTemp);
            	break;
            case 8:
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(8)+estado.charAt(7);
            	hijosGenerados.add(estadoTemp);
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(8)+estado.charAt(6)+estado.charAt(7)+estado.charAt(5);
            	hijosGenerados.add(estadoTemp);
            	break;
       }
        
        
        return hijosGenerados;
    }
    
    
    @Override
    public String toString() {
 	  
 	  return " |"+estado.charAt(0)+"|"+estado.charAt(1)+"|"+estado.charAt(2)+"|\n"
              +" |"+estado.charAt(3)+"|"+estado.charAt(4)+"|"+estado.charAt(5)+"|\n"
              +" |"+estado.charAt(6)+"|"+estado.charAt(7)+"|"+estado.charAt(8)+"|\n";
    }
    
    
}
