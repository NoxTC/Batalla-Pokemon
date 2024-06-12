/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pokemon;

import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author WilmerTC
 */
public class Batalla {
    private Entrenador yo;
    private Scanner s = new Scanner(System.in);

    private Pikachu enemigo; // Cambia a Pikachu como enemigo
    private Pokemon mio;

    // Constructor
    public Batalla(Entrenador yo) {
        this.yo = yo;
        this.s = new Scanner(System.in); // Inicializar el objeto Scanner
    }

    // Batalla
    // Con este método se comienza la batalla y se encarga de llamar al resto de métodos 
    public void comienza() {
        enemigo = new Pikachu(); // El enemigo siempre es Pikachu
        Interfaz.Elegir.TxtEnemigo.setText("Vida Enemigo: " + enemigo.getVida());
        mio = elige();
        
        
    }

    // Genera la pelea entre los dos Pokémon
    public void pelea(int opcion) {
    boolean disponible = true;
        if (mio instanceof Pikachu) {
        switch (opcion) {
            case 1:
                enemigo.danio_recibido(mio.atacarAraniazo());
                break;
            case 2:
                enemigo.danio_recibido(((IElectrico) mio).atacarImpactrueno());
                break;
            case 3:
                disponible = !(yo.captura(enemigo));
                break;
            default:
                // Maneja otros casos o errores aquí
        }
    } else if (mio instanceof Charmander) {
        switch (opcion) {
            case 1:
                enemigo.danio_recibido(mio.atacarMordisco());
                break;
            case 2:
                enemigo.danio_recibido(((((IFuego) mio).atacarLanzallamas())));
                break;
            case 3:
                disponible = !(yo.captura(enemigo));
                break;
            default:
                // Maneja otros casos o errores aquí
        }
    }
        // Actualiza la vida del enemigo en el JTextField
    int vidaEnemigoActualizada = Math.max(enemigo.getVida(), 0);
    Interfaz.Elegir.TxtEnemigo.setText("Vida Enemigo: " + enemigo.getVida());

    // Comprueba si la batalla ha terminado y muestra un mensaje si es necesario
    if (mio.getVida() <= 0 || enemigo.getVida() <= 0) {
        JOptionPane.showMessageDialog(null, "¡Felicidades!\nHas ganado la batalla.", "Victoria", JOptionPane.INFORMATION_MESSAGE);
    }
    
}

    // Este método se elige a qué Pokémon usar en la batalla
    public Pokemon elige() {
        int opcion;
    String[] opciones = new String[yo.getCont()];

    for (int i = 0; i < yo.getCont(); i++) {
        Pokemon pokemon = yo.getMochila()[i];
        opciones[i] = pokemon.getNombrePokemon();
    }

        // Mostrar un JOptionPane para que el usuario elija un Pokémon
         opcion = JOptionPane.showOptionDialog(
        null,
        "Elige tu Pokémon:",
        "Selección de Pokémon",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.PLAIN_MESSAGE,
        null,
        opciones,
        opciones[0]
    );

    if (opcion >= 0 && opcion < yo.getCont()) {
        Pokemon pokemonSeleccionado = yo.getMochila()[opcion];
        // Actualiza el campo de texto TxtVida con la vida del Pokémon seleccionado
        Interfaz.Elegir.TxtVida.setText("Vida " + pokemonSeleccionado.getVida());
        return pokemonSeleccionado;
    } else {
        return null;
    }
    }
}
