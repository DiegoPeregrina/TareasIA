package Tareas.Puzzle8;

import java.util.Scanner;

public class Puzzle8 {

    public static String estadoInicial = "12578 346";
    public static String estadoFinal = "12345678 ";
    
    public static void main(String[] args) {
        //Instanciar el arbol
        ArbolBusqueda a = new ArbolBusqueda(new Nodo(estadoInicial), estadoFinal);
        //Ejecuta la busqueda
        Scanner scan = new Scanner(System.in);
        int op;
        do {
            System.out.println("Seleccione una opcion:");
            System.out.println("1=Posiciones erroneas");
            System.out.println("2=Diferencia absoluta entre valores");
            System.out.println("3=Diferencia entre posiciones");
            System.out.println("4=Mostrar resultados");
            System.out.println("5=Salir");
            op = scan.nextInt();
            switch (op) {
                case 1:
                    a.busquedaPAHeuritica(op);
                    break;
                case 2:
                    a.busquedaPAHeuritica(op);
                    break;
            
                case 3:
                    a.busquedaPAHeuritica(op);
                    break;
                    
                case 4:
                    a.mostarResultados();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opcion no valida\n\n");
                    break;
            }
        }while(op!=5);
        
        scan.close();
    }

}