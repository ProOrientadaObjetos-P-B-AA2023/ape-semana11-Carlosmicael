package paquete02;

abstract public class Personaje {
    public String nombrePersonaje;
    protected static int puntosVida;
    protected int nivelExperiencia;
    public Personaje() {}
    public Personaje(String nombrePersonaje, int puntosVida, int nivelExperiencia) {
        this.nombrePersonaje = nombrePersonaje;
        this.puntosVida = puntosVida;
        this.nivelExperiencia = nivelExperiencia;
    }
    public String getNombrePersonaje() {
        return nombrePersonaje;
    }
    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }
    public static int getPuntosVida() {
        return puntosVida;
    }
    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }
    public int getNivelExperiencia() {
        return nivelExperiencia;
    }
    public void setNivelExperiencia(int nivelExperiencia) {
        this.nivelExperiencia = nivelExperiencia;
    }
    public void disminuirPuntosVida(int dano) {
        puntosVida -= dano;
        if (puntosVida < 0) {
            puntosVida = 0;
        }
    }
    public abstract void ataque();
    public abstract int defensa();
    public abstract void subirNivel();
    public abstract void evaluarCombate();
}
