package paquete03;
import paquete02.Personaje;
import paquete04.Mago;
import paquete05.Arquero;
public class Guerrero extends Personaje {
    private double fuerza;
    private Mago mago;
    private Arquero arquero;
    public Guerrero() {}
    public Guerrero(double fuerza,Mago mago, Arquero arquero) {
        this.fuerza = fuerza;
        this.mago = mago;
        this.arquero = arquero;
    }
    public Guerrero(String nombrePersonaje, int puntosVida,
                    int nivelExperiencia, double fuerza,Mago mago, Arquero arquero) {
        super(nombrePersonaje, puntosVida, nivelExperiencia);
        this.fuerza = fuerza;
        this.mago = mago;
        this.arquero = arquero;
    }
    public Guerrero(String nombrePersonaje, int puntosVida, int nivelExperiencia) {
        super(nombrePersonaje, puntosVida, nivelExperiencia);
    }
    public double getFuerza() {
        return fuerza;
    }
    public void setFuerza(double fuerza) {
        this.fuerza = fuerza;
    }
    public Mago getMago() {
        return mago;
    }
    public void setMago(Mago mago) {
        this.mago = mago;
    }
    public Arquero getArquero() {
        return arquero;
    }
    public void setArquero(Arquero arquero) {
        this.arquero = arquero;
    }
    public void ataque(){
        int fuerzaGuerrero = 70;
        System.out.println("El guerrero " + getNombrePersonaje() + " realiza un ataque con una fuerza de " + fuerzaGuerrero);
        if (mago != null) {
            int vidaMago = mago.getPuntosVida();
            double factorDanoMago = 1.0 - (mago.defensa() + mago.getNivelExperiencia());
            int danoMago = (int) (fuerzaGuerrero * factorDanoMago);
            vidaMago = vidaMago - danoMago;
            mago.setPuntosVida(vidaMago);
            System.out.println("El mago " + mago.getNombrePersonaje() + " recibe " + danoMago + " puntos de daño.");
            if (vidaMago <= 0) {
                System.out.println("El mago " + mago.getNombrePersonaje() + " ha sido eliminado.");
                mago = null;
            }
        }
        if (arquero != null) {
            int vidaArquero = arquero.getPuntosVida();
            double factorDanoArquero = 1.0 - (arquero.defensa() + arquero.getNivelExperiencia());
            int danoArquero = (int) (fuerzaGuerrero * factorDanoArquero);
            vidaArquero = vidaArquero - danoArquero;
            arquero.setPuntosVida(vidaArquero);
            System.out.println("El arquero " + arquero.getNombrePersonaje() + " recibe " + danoArquero + " puntos de daño.");
            if (vidaArquero <= 0) {
                System.out.println("El arquero " + arquero.getNombrePersonaje() + " ha sido eliminado.");
                arquero = null;
            }
        }
    }
    public int defensa(){
        int defensaGuerrero = defensa();
        int nivelExperienciaGuerrero = getNivelExperiencia();
        if (mago != null) {
            int defensaMago = mago.defensa();
            int nivelExperienciaMago = mago.getNivelExperiencia();
            double factorDanoMago = 1.0 - (defensaGuerrero + nivelExperienciaGuerrero) / (defensaMago + nivelExperienciaMago);
            int danoRealMago = (int) (10 * factorDanoMago);
            mago.setPuntosVida(mago.getPuntosVida() - danoRealMago);
            System.out.println("El guerrero " + getNombrePersonaje() + " recibe " + danoRealMago + " puntos de daño del mago " + mago.getNombrePersonaje() + ".");
        }
        if (arquero != null) {
            int defensaArquero = arquero.defensa();
            int nivelExperienciaArquero = arquero.getNivelExperiencia();
            double factorDanoArquero = 1.0 - (defensaGuerrero + nivelExperienciaGuerrero) / (defensaArquero + nivelExperienciaArquero);
            int danoRealArquero = (int) (10 * factorDanoArquero);
            arquero.setPuntosVida(arquero.getPuntosVida() - danoRealArquero);
            System.out.println("El guerrero " + getNombrePersonaje() + " recibe " + danoRealArquero + " puntos de daño del arquero " + arquero.getNombrePersonaje() + ".");
        }
        return defensaGuerrero;
    }
    public void subirNivel(){
            if (mago == null && arquero == null) {
                System.out.println("No hay enemigos para derrotar. El guerrero no puede subir de nivel.");
                return;
            }
            if (mago != null) {
                System.out.println("El guerrero ha derrotado al mago y sube de nivel.");
                setNivelExperiencia(getNivelExperiencia() + 10);
                setFuerza(getFuerza() + 10);
                mago = null;
            }
            if (arquero != null) {
                System.out.println("El guerrero ha derrotado al arquero y sube de nivel.");
                setNivelExperiencia(getNivelExperiencia() + 10);
                setFuerza(getFuerza() + 10);
                arquero = null;
            }
        }
    public void evaluarCombate(){
        if (puntosVida > 0 && arquero.getPuntosVida() <= 0) {
            System.out.println("El guerrero ha ganado la batalla contra el arquero.");
            subirNivel();
        } else if (puntosVida<= 0 && arquero.getPuntosVida() > 0) {
            System.out.println("El arquero ha ganado la batalla contra el guerrero.");
        } else {
            System.out.println("La batalla entre el guerrero y el arquero ha terminado en empate.");
        }
        if (puntosVida > 0 && mago.getPuntosVida() <= 0) {
            System.out.println("El guerrero ha ganado la batalla contra el mago.");
            subirNivel();
        } else if (puntosVida <= 0 && mago.getPuntosVida() > 0) {
            System.out.println("El mago ha ganado la batalla contra el guerrero.");
        } else {
            System.out.println("La batalla entre el guerrero y el mago ha terminado en empate.");
        }
        if (puntosVida > 0 && (arquero.getPuntosVida() <= 0 || mago.getPuntosVida() <= 0)) {
        } else {
            System.out.println("Nadie sube de nivel en caso de empate.");
        }
    }
}

