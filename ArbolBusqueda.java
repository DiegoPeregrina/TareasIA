package Tareas.Puzzle8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class ArbolBusqueda {

    Nodo raiz;
    String objetivo;
    Nodo Heu1,Heu2,Heu3;
    long Tiempo1,Tiempo2,Tiempo3;


    public ArbolBusqueda(Nodo raiz, String objetivo) {
        this.raiz = raiz;
        raiz.profundidad = 1;
        this.objetivo = objetivo;
    }

    // Busqueda por Anchura
    public void busquedaPorAnchura() {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList<String>();
        Queue<Nodo> estadosPorVisitar = new LinkedList<Nodo>();
        while (!nodoActual.getEstado().equals(objetivo)) {
            estadosVisitados.add(nodoActual.getEstado());
            // Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos(); // <-- Cada Equipo tiene que ingeniarselas para crear
                                                                 // este metodo!
            for (String hijo : hijos) {
                if (!estadosVisitados.contains(hijo)) {
                    // System.out.println("---Metiendo nuevo Nodo");
                    // Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.profundidad = nodoActual.profundidad + 1;
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.poll();
        }
        System.out.println("se ha encontrado el nodo objetivo");
        System.out.println(nodoActual.getEstado() + "\n");
        System.out.println(nodoActual.profundidad + "\n");
        camino(nodoActual, new String());
    }
    //metodo de busqueda por profundidad
    public void busquedaPP() {
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList<String>();
        Stack<Nodo> estadosPorVisitar = new Stack<Nodo>();
        while (!nodoActual.getEstado().equals(objetivo)) {
            estadosVisitados.add(nodoActual.getEstado());
            // Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos(); // <-- Cada Equipo tiene que ingeniarselas para crear
                                                                 // este metodo!
            for (String hijo : hijos) {
                if (!estadosVisitados.contains(hijo)) {
                    // System.out.println("---Metiendo nuevo Nodo");
                    // Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.profundidad = nodoActual.profundidad + 1;
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.pop();
        }
        System.out.println("se ha encontrado el nodo objetivo");
        System.out.println(nodoActual.getEstado());
        System.out.println(nodoActual.profundidad+ "\n");
        camino(nodoActual, new String());
        
    }

    //Metodo para imprimir el camino
    public void camino(Nodo nodo, String aux) {
        if (nodo.padre != null) {
            camino(nodo.padre, aux);
        }
        aux = nodo.getEstado();
        System.out.println(aux.charAt(0) + " [ " + aux.charAt(1) + " ] " + aux.charAt(2));
        System.out.println(aux.charAt(3) + " [ " + aux.charAt(4) + " ] " + aux.charAt(5));
        System.out.println(aux.charAt(6) + " [ " + aux.charAt(7) + " ] " + aux.charAt(8));
        System.out.println("************");
    }
    
    
  //metodo de busqueda por profundidad con Heu
    public void busquedaPAHeuritica(int op) {
        long tiempoini, tiempofin;
        tiempoini = System.currentTimeMillis();
        Nodo nodoActual = raiz;
        Collection<String> estadosVisitados = new ArrayList<String>();
        PriorityQueue<Nodo> estadosPorVisitar = new PriorityQueue<Nodo>();
        while (!nodoActual.getEstado().equals(objetivo)) {
            estadosVisitados.add(nodoActual.getEstado());
            
            // Generar a los Nodos Hijos
            Collection<String> hijos = nodoActual.generaHijos(); // <-- Cada Equipo tiene que ingeniarselas para crear
                                                                 // este metodo!
            for (String hijo : hijos) {
                if (!estadosVisitados.contains(hijo)) {
                    // System.out.println("---Metiendo nuevo Nodo");
                    // Crear nuevo Nodo.
                    Nodo nHijo = new Nodo(hijo);
                    nHijo.profundidad = nodoActual.profundidad + 1;
                    switch (op) {
                        case 1:
                            nHijo.costo = heuristica1(nHijo.getEstado(), objetivo);                            
                            break;
                        case 2:
                            nHijo.costo = heuristica2(nHijo.getEstado(), objetivo);
                            break;
                        case 3:
                            nHijo.costo = heuristica3(nHijo.getEstado(), objetivo);
                            break;
                    }
                    nHijo.setPadre(nodoActual);
                    estadosPorVisitar.add(nHijo);
                }
            }
            nodoActual = estadosPorVisitar.poll();
        }
        tiempofin = System.currentTimeMillis();
        switch (op) {
            case 1:
                this.Tiempo1 = tiempofin - tiempoini;
                this.Heu1 = nodoActual;
                break;
            case 2:
                this.Tiempo2 = tiempofin - tiempoini;
                this.Heu2 = nodoActual;
                break;
            case 3:
                this.Tiempo3 = tiempofin - tiempoini;
                this.Heu3 = nodoActual;
                break;
        }
        System.out.println(estadosVisitados.size());
        System.out.println("se ha encontrado el nodo objetivo");
        System.out.println(nodoActual.getEstado() + "\n");
        System.out.println(nodoActual.profundidad+ "\n");

        System.out.println("Pasos para llegar al estado final");
        camino(nodoActual, new String());
    }

    public int heuristica1(String actual, String objetivo) {
        int cont = 0;
        for(int i=0; i<actual.length(); i++){
            if (actual.charAt(i) != objetivo.charAt(i)){
                cont++ ;
            }
        }
        return cont;
    }

    public int heuristica2(String actual, String objetivo) {
        int a,b,cont = 0;
        for(int i=0; i<actual.length(); i++){
            a = Character.getNumericValue(actual.charAt(i));
            if (actual.charAt(i) == ' ')
                a = 0;
            b = Character.getNumericValue(objetivo.charAt(i));
            if (objetivo.charAt(i) == ' ')
                b = 0;
            cont = cont + Math.abs(a-b) ;
    }
        return cont;
    }

    public int heuristica3(String actual, String objetivo) {
        int cont = 0;
        for(int i=0; i<actual.length(); i++){
            for(int j=0; j<actual.length(); j++){
                if (actual.charAt(i) == objetivo.charAt(j)){
                    cont += Math.abs(i-j);
                    break;
                }
            }
        }
        return cont;
    }

    public void mostarResultados(){
        System.out.println("\n\n\t\tResultado");
        System.out.println("Heuristica 1:");
        if (this.Heu1 == null)
            System.out.println("\tVacio");
        else{
        	
            System.out.println("Ultimo nodo: "+Heu1.profundidad);
            System.out.println("Tiempo transcurrido: "+Tiempo1 +" milisegundos\n");    
        }
        System.out.println("Heuristica 2:");
        if (this.Heu2 == null)
            System.out.println("\tVacio");
        else{
        	
            System.out.println("Ultimo nodo: "+Heu2.profundidad);
            System.out.println("Tiempo transcurrido: "+Tiempo2 +" milisegundos\n");    
        }
        System.out.println("Heuristica 3:");
        if (this.Heu3 == null)
            System.out.println("\tVacio");
        else{
        	
            System.out.println("Ultimo nodo: "+Heu3.profundidad);
            System.out.println("Tiempo transcurrido: "+Tiempo3 +" milisegundos\n");    
        }
    }
}