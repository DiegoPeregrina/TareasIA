package BusquedasInformadas;

import java.util.Collection;

public class Puzzle8 {

    public static String estadoInicial = "12578 346";
    public static String estadoFinal = "12345678 ";
    
    public static void main(String[] args) {
    	
    	
        //Instanciar el arbol
        ArbolBusqueda a = new ArbolBusqueda(new Nodo(estadoInicial), estadoFinal);
        //Ejecuta la busqueda
        
        
        
        //Anchura
        long inicio = System.nanoTime();
        System.out.println("Busqueda por Anchura");
        a.busquedaPorAnchura();
        long fin = System.nanoTime();
        long Tiempo = fin - inicio;
        System.out.println("Segundos: "+(float)Tiempo/1000000000);
 
        
        //Profundidad
        long inicio2 = System.nanoTime();
        System.out.println("Busqueda por Profundidad");
        a.busquedaPorProfundidad();
        long fin2 = System.nanoTime();
        long Tiempo2 = fin2 - inicio2;
        System.out.println("Segundos: "+(float)Tiempo2/1000000000);
       
        
        //Heuristica 1
        long inicio3 = System.nanoTime();
        System.out.println("Busqueda por Heuristica 1");
        a.busquedaHeuristica();
        long fin3 = System.nanoTime();
        long Tiempo3 = fin3 - inicio3;
        System.out.println("Segundos: "+(float)Tiempo3/1000000000);
        
        
        //Heuristica 2
        long inicio4 = System.nanoTime();
        System.out.println("Busqueda por Heuristica 2");
        a.busquedaHeuristica2();
        long fin4 = System.nanoTime();
        long Tiempo4 = fin4 - inicio4;
        System.out.println("Segundos: "+(float)Tiempo4/1000000000);
        
        //Imprime movimientos
        
        System.out.println("Busqueda por Anchura");
        System.out.println("Segundos: "+(float)Tiempo/1000000000);
        System.out.println("Busqueda por Profundidad");
        System.out.println("Segundos: "+(float)Tiempo2/1000000000);
        System.out.println("Busqueda por Heuristica 1");
        System.out.println("Segundos: "+(float)Tiempo3/1000000000);
        System.out.println("Busqueda por Heuristica 2");
        System.out.println("Segundos: "+(float)Tiempo4/1000000000);
        
        
        
        /*
        Nodo n = new Nodo(estadoInicial);
        Collection<String> c = n.generaHijos();
        c = c;
        */
    }
    
    
    
    
}
