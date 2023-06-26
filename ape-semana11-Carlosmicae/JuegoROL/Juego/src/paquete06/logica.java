package paquete06;
import paquete02.Personaje;
import paquete03.Guerrero;
import paquete04.Mago;
import paquete05.Arquero;
import java.util.Scanner;
public class logica {
    public static void iniciarBatalla(Personaje jugador1, Personaje jugador2) {
        Scanner scanner = new Scanner(System.in);
        boolean jugador1AtaqueExtra = false;
        boolean jugador2AtaqueExtra = false;
        while (jugador1.getPuntosVida() > 0 && jugador2.getPuntosVida() > 0) {
            System.out.println("----- TURNO DE JUGADOR 1 -----");
            mostrarOpciones();
            int opcionJugador1 = scanner.nextInt();
            scanner.nextLine();
            if (opcionJugador1 == 1) {
                if (jugador1 instanceof Guerrero) {
                    ((Guerrero) jugador1).ataque();
                } else if (jugador1 instanceof Mago) {
                    ((Mago) jugador1).ataque();
                } else if (jugador1 instanceof Arquero) {
                    ((Arquero) jugador1).ataque();
                }
                if (jugador2.getPuntosVida() <= 0) {
                    System.out.println("El jugador 2 ha sido eliminado.");
                    break;
                }
            } else if (opcionJugador1 == 2) {
                if (jugador1 instanceof Guerrero) {
                    ((Guerrero) jugador1).defensa();
                } else if (jugador1 instanceof Mago) {
                    ((Mago) jugador1).defensa();
                } else if (jugador1 instanceof Arquero) {
                    ((Arquero) jugador1).defensa();
                }
            } else if (opcionJugador1 == 3) {
                jugador1AtaqueExtra = true;
            }
            if (jugador1AtaqueExtra) {
                jugador1AtaqueExtra = false;
                System.out.println("----- TURNO EXTRA DE JUGADOR 1 -----");
                mostrarOpciones();
                int opcionExtraJugador1 = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner
                if (opcionExtraJugador1 == 1) {
                    if (jugador1 instanceof Guerrero) {
                        ((Guerrero) jugador1).ataque();
                    } else if (jugador1 instanceof Mago) {
                        ((Mago) jugador1).ataque();
                    } else if (jugador1 instanceof Arquero) {
                        ((Arquero) jugador1).ataque();
                    }
                    if (jugador2.getPuntosVida() <= 0) {
                        System.out.println("El jugador 2 ha sido eliminado.");
                        break;
                    }
                } else if (opcionExtraJugador1 == 2) {
                    if (jugador1 instanceof Guerrero) {
                        ((Guerrero) jugador1).defensa();
                    } else if (jugador1 instanceof Mago) {
                        ((Mago) jugador1).defensa();
                    } else if (jugador1 instanceof Arquero) {
                        ((Arquero) jugador1).defensa();
                    }
                }
            }
            System.out.println("----- TURNO DE JUGADOR 2 -----");
            mostrarOpciones();
            int opcionJugador2 = scanner.nextInt();
            scanner.nextLine();
            if (opcionJugador2 == 1) {
                if (jugador2 instanceof Guerrero) {
                    ((Guerrero) jugador2).ataque();
                } else if (jugador2 instanceof Mago) {
                    ((Mago) jugador2).ataque();
                } else if (jugador2 instanceof Arquero) {
                    ((Arquero) jugador2).ataque();
                }
                if (jugador1.getPuntosVida() <= 0) {
                    System.out.println("El jugador 1 ha sido eliminado.");
                    break;
                }
            } else if (opcionJugador2 == 2) {
                if (jugador2 instanceof Guerrero) {
                    ((Guerrero) jugador2).defensa();
                } else if (jugador2 instanceof Mago) {
                    ((Mago) jugador2).defensa();
                } else if (jugador2 instanceof Arquero) {
                    ((Arquero) jugador2).defensa();
                }
            } else if (opcionJugador2 == 3) {
                jugador2AtaqueExtra = true;
            }
            if (jugador2AtaqueExtra) {
                jugador2AtaqueExtra = false;
                System.out.println("----- TURNO EXTRA DE JUGADOR 2 -----");
                mostrarOpciones();
                int opcionExtraJugador2 = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner
                if (opcionExtraJugador2 == 1) {
                    if (jugador2 instanceof Guerrero) {
                        ((Guerrero) jugador2).ataque();
                    } else if (jugador2 instanceof Mago) {
                        ((Mago) jugador2).ataque();
                    } else if (jugador2 instanceof Arquero) {
                        ((Arquero) jugador2).ataque();
                    }
                    if (jugador1.getPuntosVida() <= 0) {
                        System.out.println("El jugador 1 ha sido eliminado.");
                        break;
                    }
                } else if (opcionExtraJugador2 == 2) {
                    if (jugador2 instanceof Guerrero) {
                        ((Guerrero) jugador2).defensa();
                    } else if (jugador2 instanceof Mago) {
                        ((Mago) jugador2).defensa();
                    } else if (jugador2 instanceof Arquero) {
                        ((Arquero) jugador2).defensa();
                    }
                }
            }
        }
        if (jugador1.getPuntosVida() > 0 && jugador2.getPuntosVida() > 0) {
            System.out.println("La batalla ha terminado en empate.");
        } else if (jugador1.getPuntosVida() > 0) {
            System.out.println("El jugador 1 ha ganado la batalla.");
        } else {
            System.out.println("El jugador 2 ha ganado la batalla.");
        }
    }
    public static void mostrarOpciones() {
        System.out.println("----- Opciones de Acción -----");
        System.out.println("Jugador 1: ");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        System.out.println("Jugador 2: ");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        System.out.println("Elige una opción: ");
    }
}
