/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon;

import Interfaz.Elegir;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Entrenador {


    private String nombre;
    private int cont = 0, tam = 2;

    private Pokemon[] mochila = new Pokemon[tam];

    //Constructor
    public Entrenador(String nombre) {
        this.nombre = nombre;
    }

    public void getPersonaje() {
        // Permite al entrenador elegir entre Pikachu y Charmander al principio

        // Realiza la acción cuando el botón de Pikachu está presionado y es igual a true
        mochila[cont] = new Pikachu();
        cont++;
    }

    public void getPersonaje2() {
        // Permite al entrenador elegir entre Pikachu y Charmander al inicio

        // Realiza la acción cuando el botón de Charmander está presionado y es igual a true
        mochila[cont] = new Charmander();

        cont++;
    }
    //Getter

    public String getNombre() {
        return this.nombre;
    }
    
    public int getCont() {
        return cont;
    }

    public Pokemon[] getMochila() {
        return mochila;
    }

    //Metodos
    // Se elige a un pokemon de la mochila en funcion del indice recibido (i) y se devuelve
    // Si el indice no se encuentra en el vector se devuelve null
    public Pokemon elige(int i) {
        if (i < cont) {
            return mochila[i];
        } else {
            return null;
        }
    }
    //Metodo que se llama cuando un entrenador trata de capturar a un pikachu, devuelve un booleano

    public boolean captura(Pokemon enemigo) {
        boolean capturado = false;
        if (enemigo.getVida() <= 20) {
            if (cont < tam) {
                mochila[cont] = enemigo;
                capturado = true;
                cont++;
JOptionPane.showMessageDialog(null, "El pokemon ha sido capturado satisfactoriamente");
                
            } else {
                System.out.println("La mochila esta llena ");
            }
        } else {
            System.out.println("Imposible de capturar");
        }
        return capturado;
    }

    //Metodo que muestra los pikachus que tenemos en la mochila junto a sus caracterisiticas
    public void mostrar_mochila() {
        System.out.println("Tienes: " + cont + " Pokémon");
        for (int i = 0; i < cont; i++) {
            Pokemon pokemon = mochila[i];
            if (pokemon instanceof Pikachu) {
                Pikachu pikachu = (Pikachu) pokemon;
                System.out.println("Tienes un nuevo pokemon N°: " + i + " Nombre: " + pikachu.getNombrePokemon() + " Nivel: " + pikachu.getNivel() + " Vida: " + pikachu.getVida());
                String mensaje = "¡Tienes un nuevo Pokémon!\n";
                mensaje += "Número: " + i + "\n";
                mensaje += "Nombre: " + pikachu.getNombrePokemon() + "\n";
                mensaje += "Nivel: " + pikachu.getNivel() + "\n";
                mensaje += "Vida: " + pikachu.getVida();
                Interfaz.Elegir.TxtVida.setText("Vida " + pikachu.getVida());
                JOptionPane.showMessageDialog(null, mensaje);
            } else if (pokemon instanceof Charmander) {
                Charmander charmander = (Charmander) pokemon;
                System.out.println("Tienes un nuevo pokemon N°: " + i + " Nombre: " + charmander.getNombrePokemon() + " Nivel: " + charmander.getNivel() + " Vida: " + charmander.getVida());
                String mensaje = "¡Tienes " + cont + " Pokemon!\n";
                mensaje += "Número: " + i + "\n";
                mensaje += "Nombre: " + charmander.getNombrePokemon() + "\n";
                mensaje += "Nivel: " + charmander.getNivel() + "\n";
                mensaje += "Vida: " + charmander.getVida();

                Interfaz.Elegir.TxtVida.setText("Vida " + charmander.getVida());
                JOptionPane.showMessageDialog(null, mensaje);
            }
        }
    }
}
