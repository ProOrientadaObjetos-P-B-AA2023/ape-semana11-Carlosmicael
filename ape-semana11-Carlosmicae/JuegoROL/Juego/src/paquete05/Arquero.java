package paquete05;
import paquete02.Personaje;
import paquete03.Guerrero;
import paquete04.Mago;

public class Arquero extends Personaje {
   private int precision;
   private Guerrero guerrero;
   private Mago mago;
    public Arquero() {}
    public Arquero(String nombrePersonaje, int puntosVida, int nivelExperiencia) {
        super(nombrePersonaje, puntosVida, nivelExperiencia);
    }
    public Arquero(int precision,Guerrero guerrero,Mago mago) {
        this.precision = precision;
        this.guerrero=guerrero;
        this.mago=mago;
    }
    public Arquero(String nombrePersonaje, int puntosVida, int nivelExperiencia, int precision) {
        super(nombrePersonaje, puntosVida, nivelExperiencia);
        this.precision = precision;
    }
    public int getPrecision() {
        return precision;
    }
    public void setPrecision(int precision) {
        this.precision = precision;
    }
    public void ataque() {
        int dano = 30; // Daño fijo
        // Atacar al Guerrero
        System.out.println("El Arquero " + this.getNombrePersonaje() + " ataca al Guerrero");
        guerrero.disminuirPuntosVida(dano);
        // Atacar al Mago
        System.out.println("El Arquero " + this.getNombrePersonaje() + " ataca al Mago");
        mago.disminuirPuntosVida(dano);
        System.out.println("¡El ataque ha sido realizado!");
    }
    public int defensa() {
        int valorDefensa = 15;
        System.out.println("El Arquero " + this.getNombrePersonaje() + " se defiende");
        return valorDefensa;
    }
    public void subirNivel() {
        if (guerrero != null || mago != null) {
            System.out.println("El Arquero no puede subir de nivel sin haber ganado el combate.");
            return;
        }
        System.out.println("El Arquero ha subido de nivel.");
        setNivelExperiencia(getNivelExperiencia() + 1);
    }
    public void evaluarCombate() {
        if (guerrero != null) {
            if (this.getPuntosVida() > 0) {
                System.out.println("El Arquero ha ganado el combate contra el Guerrero.");
            } else {
                System.out.println("El Arquero ha perdido el combate contra el Guerrero.");
            }
        }
        if (mago != null) {
            if (this.getPuntosVida() > 0) {
                System.out.println("El Arquero ha ganado el combate contra el Mago.");
            } else {
                System.out.println("El Arquero ha perdido el combate contra el Mago.");
            }
        }
    }
}
