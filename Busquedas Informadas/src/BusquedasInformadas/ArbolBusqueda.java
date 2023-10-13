
package BusquedasInformadas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Mario R�os
 */


public class ArbolBusqueda {
    
    Nodo raiz;
    String objetivo;
    
    public ArbolBusqueda(Nodo raiz, String objetivo)
    {
        this.raiz = raiz;
        this.objetivo = objetivo;
    }
    
    
    
    
    public int costo(String estado ) {
    	int counter=0;
    	for (int i =0 ; i<estado.length();i++) {
    		 if (estado.charAt(i)!= raiz.getEstado().charAt(i)){
    			 counter++;
    		 }
    	}  return counter;
    	
    }
    
    public Comparator<Nodo> heuristica1() {
        Comparator<Nodo> prioridad = new Comparator<Nodo>() {
            @Override
            public int compare(Nodo o1, Nodo o2) {
                if(costo(o1.getEstado()) < costo(o2.getEstado())) {
                    return -1;
                }else if(costo(o1.getEstado()) == costo(o2.getEstado())){
                    return 1;
                }else {
                    return 1;
                }
            }
        };
        return prioridad;
    }

    
    
    
    
    
    
    public Comparator<Nodo> heuristica2() {
        Comparator<Nodo> heuristica2 = new Comparator<Nodo>() {
            @Override
            public int compare(Nodo nodo, Nodo nodo2) {
            	int valorHeuristico = 0;
        		
        		for(int i = 0; i < raiz.getEstado().length(); i++) {
        			if(raiz.getEstado().charAt(i) != objetivo.charAt(i)) {
        				valorHeuristico++;
        			}
        		}
        		return valorHeuristico;
            }
        };
        return heuristica2;
    }
    
    
    
    
    
    
    
    
    
    
    //Busqueda Heuristica
    public void busquedaHeuristica()
    {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        PriorityQueue<Nodo> estadosPorVisitar = new PriorityQueue<Nodo>(heuristica1());
        while(!nodoActual.getEstado().equals(objetivo))
        {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	//<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {
                    //System.out.println("---Metiendo nuevo Nodo");
                    //Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.poll();
        }
        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(imprimir(nodoActual));
        System.out.println(nodoActual);
    }
    
    
    
    public void busquedaHeuristica2()
    {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        PriorityQueue<Nodo> estadosPorVisitar = new PriorityQueue<Nodo>(heuristica2());
        while(!nodoActual.getEstado().equals(objetivo))
        {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	//<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {
                    //System.out.println("---Metiendo nuevo Nodo");
                    //Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.poll();
        }
        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(imprimir(nodoActual));
        System.out.println(nodoActual);
    }
    
    
    
    public void busquedaPorAnchura()
    {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        Queue<Nodo> estadosPorVisitar = new LinkedList();
        while(!nodoActual.getEstado().equals(objetivo))
        {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	//<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {
                    //System.out.println("---Metiendo nuevo Nodo");
                    //Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.poll();
        }
        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(imprimir(nodoActual));
        System.out.println(nodoActual);
    }
    
    
    
    
    public void busquedaPorProfundidad()
    {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList();
        Stack<Nodo> estadosPorVisitar = new Stack();
        while(!nodoActual.getEstado().equals(objetivo))
        {
            estadosVisitados.add(nodoActual.getEstado());
            //Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos();	//<-- Cada Equipo tiene que ingeniarselas para crear este metodo!
            for (String hijo : hijos) {
                if(!estadosVisitados.contains(hijo))
                {
                    //System.out.println("---Metiendo nuevo Nodo");
                    //Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.pop();
        }
        System.out.println("YA SE ENCONTRO EL NODO OBJETIVO");
        System.out.println(imprimir(nodoActual));
        System.out.println(nodoActual);
    }
    public String imprimir(Nodo nodoActual) {
    	
    	Nodo nodoImprimir = nodoActual;
    	String nodoString = "";
    	
    	do {
    		 nodoImprimir= nodoImprimir.getPadre();
    		 nodoString= nodoImprimir+"\n"+nodoString;
    		
    	} while(nodoImprimir != raiz);
    	
    	return nodoString;
    }
    
    
    
}
