package paquete01;
import paquete02.Personaje;
import paquete03.Guerrero;
import paquete04.Mago;
import paquete05.Arquero;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static paquete06.logica.iniciarBatalla;
public class Ejecutor01 {
    private static List<Guerrero> guerreros = new ArrayList<>();
    private static List<Mago> magos = new ArrayList<>();
    private static List<Arquero> arqueros = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Crear personajes");
            System.out.println("2. Jugar");
            System.out.println("3. Ver resultados");
            System.out.println("0. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea
            switch (opcion) {
                case 1:
                    crearPersonajes(scanner);
                    break;
                case 2:
                    jugar();
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
            System.out.println();
        } while (opcion != 0);
    }
    private static void crearPersonajes(Scanner scanner) {
        boolean crearOtroPersonaje = true;
        while (crearOtroPersonaje) {
            System.out.println("CREAR PERSONAJE");
            System.out.println("Seleccione el tipo de personaje:");
            System.out.println("1. Guerrero");
            System.out.println("2. Mago");
            System.out.println("3. Arquero");
            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea
            System.out.print("Ingrese el nombre del personaje: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese los puntos de vida del personaje: ");
            int puntosVida = scanner.nextInt();
            System.out.print("Ingrese el nivel de experiencia del personaje: ");
            int nivelExperiencia = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea
            if (opcion == 1) {
                Guerrero guerrero = new Guerrero(nombre, puntosVida, nivelExperiencia);
                guerreros.add(guerrero);
            } else if (opcion == 2) {
                Mago mago = new Mago(nombre, puntosVida, nivelExperiencia);
                // Selección de poderes mágicos
                System.out.println("Seleccione los poderes mágicos del Mago:");
                System.out.println("1. Poder devastador");
                System.out.println("2. Poder destructor");
                System.out.println("3. Defensa");
                int poderMagicoElegido = scanner.nextInt();
                scanner.nextLine();

                switch (poderMagicoElegido) {
                    case 1:
                        mago.agregarPoderMagico("Poder devastador");
                        break;
                    case 2:
                        mago.agregarPoderMagico("Poder destructor");
                        break;
                    case 3:
                        mago.agregarPoderMagico("Defensa");
                        break;
                    default:
                        System.out.println("Opción inválida. No se agregó ningún poder mágico.");
                        break;
                }
                // Selección de hechizos
                System.out.println("Seleccione los hechizos del Mago:");
                System.out.println("1. Hechizo primario");
                int hechizoElegido = scanner.nextInt();
                scanner.nextLine(); // Limpiar el salto de línea

                switch (hechizoElegido) {
                    case 1:
                        mago.agregarHechizo("Hechizo primario");
                        break;
                    default:
                        System.out.println("Opción inválida. No se agregó ningún hechizo.");
                        break;
                }
                magos.add(mago);
            } else if (opcion == 3) {
                Arquero arquero = new Arquero(nombre, puntosVida, nivelExperiencia);
                arqueros.add(arquero);
            } else {
                System.out.println("Opción inválida. Intente nuevamente.");
                continue;
            }
            System.out.print("¿Desea crear otro personaje? (s/n): ");
            String opcionCrearOtro = scanner.nextLine();
            crearOtroPersonaje = opcionCrearOtro.equalsIgnoreCase("s");
            System.out.println();
        }
    }
    public static void jugar() {
        Scanner scanner = new Scanner(System.in);
        if (guerreros.isEmpty() || magos.isEmpty() || arqueros.isEmpty()) {
            System.out.println("No hay personajes disponibles para jugar. Por favor, crea al menos un personaje de cada tipo.");
            return;
        }
        System.out.println("----- JUGAR -----");
        System.out.println("Escoge el personaje para el Jugador 1:");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.println("3. Arquero");
        System.out.print("Ingrese una opción: ");
        int opcionJugador1 = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.println("Escoge el personaje para el Jugador 2:");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.println("3. Arquero");
        System.out.print("Ingrese una opción: ");
        int opcionJugador2 = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        Personaje jugador1 = null;
        Personaje jugador2 = null;
        if (opcionJugador1 == 1) {
            if (guerreros.isEmpty()) {
                System.out.println("No hay guerreros disponibles.");
                return;
            }
            System.out.println("Personajes disponibles para el Jugador 1:");
            mostrarGuerreros();
            int seleccionJugador1 = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
            if (seleccionJugador1 < 1 || seleccionJugador1 > guerreros.size()) {
                System.out.println("Opción inválida. Por favor, intenta nuevamente.");
                return;
            }
            jugador1 = guerreros.get(seleccionJugador1 - 1);
        } else if (opcionJugador1 == 2) {
            if (magos.isEmpty()) {
                System.out.println("No hay magos disponibles.");
                return;
            }
            System.out.println("Personajes disponibles para el Jugador 1:");
            mostrarMagos();
            int seleccionJugador1 = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
            if (seleccionJugador1 < 1 || seleccionJugador1 > magos.size()) {
                System.out.println("Opción inválida. Por favor, intenta nuevamente.");
                return;
            }
            jugador1 = magos.get(seleccionJugador1 - 1);
        } else if (opcionJugador1 == 3) {
            if (arqueros.isEmpty()) {
                System.out.println("No hay arqueros disponibles.");
                return;
            }
            System.out.println("Personajes disponibles para el Jugador 1:");
            mostrarArqueros();
            int seleccionJugador1 = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
            if (seleccionJugador1 < 1 || seleccionJugador1 > arqueros.size()) {
                System.out.println("Opción inválida. Por favor, intenta nuevamente.");
                return;
            }
            jugador1 = arqueros.get(seleccionJugador1 - 1);
        } else {
            System.out.println("Opción inválida. Por favor, intenta nuevamente.");
            return;
        }
        if (opcionJugador2 == 1) {
            if (guerreros.isEmpty()) {
                System.out.println("No hay guerreros disponibles.");
                return;
            }
            System.out.println("Personajes disponibles para el Jugador 2:");
            mostrarGuerreros();
            int seleccionJugador2 = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
            if (seleccionJugador2 < 1 || seleccionJugador2 > guerreros.size()) {
                System.out.println("Opción inválida. Por favor, intenta nuevamente.");
                return;
            }
            jugador2 = guerreros.get(seleccionJugador2 - 1);
        } else if (opcionJugador2 == 2) {
            if (magos.isEmpty()) {
                System.out.println("No hay magos disponibles.");
                return;
            }
            System.out.println("Personajes disponibles para el Jugador 2:");
            mostrarMagos();
            int seleccionJugador2 = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
            if (seleccionJugador2 < 1 || seleccionJugador2 > magos.size()) {
                System.out.println("Opción inválida. Por favor, intenta nuevamente.");
                return;
            }
            jugador2 = magos.get(seleccionJugador2 - 1);
        } else if (opcionJugador2 == 3) {
            if (arqueros.isEmpty()) {
                System.out.println("No hay arqueros disponibles.");
                return;
            }
            System.out.println("Personajes disponibles para el Jugador 2:");
            mostrarArqueros();
            int seleccionJugador2 = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner
            if (seleccionJugador2 < 1 || seleccionJugador2 > arqueros.size()) {
                System.out.println("Opción inválida. Por favor, intenta nuevamente.");
                return;
            }
            jugador2 = arqueros.get(seleccionJugador2 - 1);
        } else {
            System.out.println("Opción inválida. Por favor, intenta nuevamente.");
            return;
        }
        System.out.println("¡Comienza la batalla!");
        System.out.println("Jugador 1: " + jugador1.getNombrePersonaje() + " (Puntos de vida: " + jugador1.getPuntosVida() + ")");
        System.out.println("Jugador 2: " + jugador2.getNombrePersonaje() + " (Puntos de vida: " + jugador2.getPuntosVida() + ")");
        iniciarBatalla(jugador1, jugador2);
    }
    public static void mostrarGuerreros() {
        System.out.println("Guerreros disponibles:");
        for (int i = 0; i < guerreros.size(); i++) {
            Guerrero guerrero = guerreros.get(i);
            System.out.println((i + 1) + ". " + guerrero.getNombrePersonaje() + " (Puntos de vida: " + guerrero.getPuntosVida() +
                    ", Nivel de experiencia: " + guerrero.getNivelExperiencia() + ")");
        }
    }
    public static void mostrarMagos() {
        System.out.println("Magos disponibles:");
        for (int i = 0; i < magos.size(); i++) {
            Mago mago = magos.get(i);
            System.out.println((i + 1) + ". " + mago.getNombrePersonaje() + " (Puntos de vida: " + mago.getPuntosVida() +
                    ", Nivel de experiencia: " + mago.getNivelExperiencia() + ")");
        }
    }
    public static void mostrarArqueros() {
        System.out.println("Arqueros disponibles:");
        for (int i = 0; i < arqueros.size(); i++) {
            Arquero arquero = arqueros.get(i);
            System.out.println((i + 1) + ". " + arquero.getNombrePersonaje() + " (Puntos de vida: " + arquero.getPuntosVida() +
                    ", Nivel de experiencia: " + arquero.getNivelExperiencia() + ")");
        }
    }
}
