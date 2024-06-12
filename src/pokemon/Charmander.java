/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon;

/**
 *
 * @author WilmerTC
 */
public class Charmander extends Pokemon implements IFuego {

    public Charmander() {
        nombrePokemon = "charmander";
        nivel = rand.nextInt(5) + 1;   //Le sumo 1 al nivel, para tener como minimo el nivel 1

        ataque = 14 * nivel;
        defensa = 5 * nivel;
        vida = 5 * nivel;

        pm1 = 10;
        pm2 = 10;

    }

    public String getNombrePokemon() {
        return nombrePokemon;
    }

    @Override
    protected int atacarPlacaje() {
        int danio;
        if (pm1 > 0) {
            danio = ataque;
            pm1--;
        } else {
            danio = 0;
        }

        return danio;
    }

    @Override
    protected int atacarAraniazo() {
        int danio;
        if (pm1 > 0) {
            danio = ataque;
            pm1--;
        } else {
            danio = 0;
        }

        return danio;
    }

    protected int atacarMordisco() {
        int danio;
        if (pm1 > 0) {
            danio = ataque;
            pm1--;
        } else {
            danio = 0;
        }

        return danio;
    }

    @Override
    public int atacarLanzallamas() {
        int danio;
        if (pm2 > 0) {
            danio = ataque * 2;
            pm2--;
        } else {
            danio = 0;
        }
        return danio;
    }

    @Override
    public int atacarGiroFuego() {
        int danio;
        if (pm2 > 0) {
            danio = ataque * 2;
            pm2--;
        } else {
            danio = 0;
        }
        return danio;
    }

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
    public void mostrar(String nombre) {
        System.out.println("Nombre: " + nombre + " Nivel: " + nivel + " Vida: " + vida);
    }

}
