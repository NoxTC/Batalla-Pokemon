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
public class Pikachu extends Pokemon implements IElectrico {

    // Constructor
    
    public Pikachu() {
        nombrePokemon = "pikachu";
        nivel = rand.nextInt(5) + 1;   //Le sumo 1 al nivel, para tener como minimo el nivel 1
        
        ataque = 10 * nivel;
        defensa = 5 * nivel;
        vida = 10 * nivel;
        
        pm1 = 10;
        pm2 = 10;
        
    }
    
    // Ataques: Deben de tener el PM de cada ataque que sea mayor que 0, sino no se realiza el ataque
    // Placaje es un ataque basico y quita de danio lo mismo que tenga de ataque pikachu

    @Override
    protected int atacarPlacaje() {
        int danio;
        if(pm1 > 0){
            danio = ataque;
            pm1--;
        }else{
            danio = 0;
        }
        
        return danio;
    }

    @Override
    protected int atacarAraniazo() {
        int danio;
        if(pm1 > 0){
            danio = ataque;
            pm1--;
        }else{
            danio = 0;
        }
        
        return danio;
    }
    // Rayo es un ataque un poco mas fuerte y quita el dobke de danio que el atributo ataque
    
    @Override
    public int atacarImpactrueno() {
        int danio;
        if(pm2 > 0){
            danio = ataque*2;
            pm2--;
        }else{
            danio = 0;
        }
        return danio;
    }

    @Override
    public int atacarRayo() {
       int danio;
        if(pm2 > 0){
            danio = ataque*2;
            pm2--;
        }else{
            danio = 0;
        }
        return danio;
    }
    
    // Ataque recibido
    // Cuando pikachu recibe danio se llama a este metodo, que lo que hace es restarle vida al pobe en funcion del danio recibido
    
     public int danio_recibido(int danio) {
    if ((danio - defensa) > 0) {
        vida -= (danio - defensa);
        if (vida < 0) {
            vida = 0;
        }
    }
    return vida;
}
    
    //Datos
    //Simplemente mostrar por pantalla los datos del pikachu en cuestion
    
    @Override
    public void mostrar (String nombre){
        System.out.println("Nombre: " + nombre + " Nivel: " + nivel + " Vida: " + vida );
    } 


    
}
