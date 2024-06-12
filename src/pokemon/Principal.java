/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemon;

import Interfaz.Elegir;
import java.util.Scanner;

/**
 *
 * @author WilmerTC
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Elegir el = new Elegir();
       el.setVisible(true);
       Scanner teclado =  new Scanner (System.in);
       String nombre;
       int opcion;
        nombre = Interfaz.Elegir.TxtUsuario.getText();
        nombre = teclado.nextLine();
        
        Entrenador yo = new Entrenador(nombre);
        
        Batalla bat = new Batalla(yo);
        
        do{
            yo.mostrar_mochila();
            System.out.println();
            System.out.println();
            System.out.println();
            
            System.out.println("Elige una opcion: ");
            System.out.println("1. Comenzar una batalla");
            System.out.println("2. Salir");
            
            opcion = teclado.nextInt();
            
            if(opcion == 1){
                bat.comienza();
            }
        }while(opcion !=2);
        
    }
    
}
