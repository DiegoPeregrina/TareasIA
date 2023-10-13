package Proyecto;

import java.util.Scanner;

import net.sourceforge.jFuzzyLogic.FIS;

public class AnimalFuzzyLogic {
	
    public static void main(String[] args) {
    	
        String fileName = "";
        FIS fis = FIS.load(fileName, true);

        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese los datos del animal");
        System.out.println("(tortuga, perro o leon)\n");
        
        System.out.print("Altura (10 - 120) cm: ");
        int altura = s.nextInt();
        
        System.out.print("Peso: (10 - 120) kg: ");
        int peso = s.nextInt();
        
        System.out.print("Velocidad (30 - 100) km/h: ");
        int velocidad = s.nextInt();
        s.close();
        
        fis.setVariable("altura", altura);
        fis.setVariable("peso", peso);
        fis.setVariable("velocidad", velocidad);
        System.out.println();

        fis.evaluate();

        double especie = fis.getVariable("especie").getValue();
        System.out.print("La especie es: ");
        
        if (especie < 10) {
        	System.out.println("desconocido");
        } else if (especie < 38){
        	System.out.println("tortuga");
        } else if (especie < 63){
        	System.out.println("perro");
        } else {
        	System.out.println("leon");
        }
        
    }
    
}