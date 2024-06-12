/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon;

import java.util.Random;

/**
 *
 * @author WilmerTC
 */
public abstract class Pokemon {
   protected String nombrePokemon;
  
    protected int ataque, defensa, nivel, vida;
    protected int pm1, pm2;
    protected Random rand = new Random (System.nanoTime());

    public int getNivel() {
        return nivel;
    }

    public int getVida() {
        return vida;
    }

    public int getPm1() {
        return pm1;
    }

    public int getPm2() {
        return pm2;
    }

    public String getNombrePokemon() {
        return nombrePokemon;
    }
    
    
    
     public void mostrar(String entrenadorNombre) {
        System.out.println("Nombre del entrenador: " + entrenadorNombre);
        System.out.println("Nombre del Pokémon: " + getNombrePokemon());
        System.out.println("Nivel: " + getNivel());
        System.out.println("Vida: " + getVida());
    }
    
    
    protected abstract int atacarPlacaje();
    protected abstract int atacarAraniazo();
    protected  int atacarMordisco(){
        return 0;
    }
}
