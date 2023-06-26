package paquete04;

import paquete02.Personaje;
import paquete03.Guerrero;
import paquete05.Arquero;

import java.util.ArrayList;
import java.util.List;

public class Mago extends Personaje {
    private List<String> hechizos;
    private List<String> poderesMagicos;
    private Arquero arquero;
    private Guerrero guerrero;
    public Mago() {}
    public Mago(String nombrePersonaje, int puntosVida, int nivelExperiencia) {
        super(nombrePersonaje, puntosVida, nivelExperiencia);
    }
    public Mago(List<String> hechizos, List<String> poderesMagicos,Arquero arquero,Guerrero guerrero) {
        this.arquero=arquero;
        this.guerrero=guerrero;
        this.hechizos = new ArrayList<>(hechizos);
        this.poderesMagicos = new ArrayList<>(poderesMagicos);

    }
    public Mago(String nombrePersonaje, int puntosVida, int nivelExperiencia,
                List<String> hechizos, List<String> poderesMagicos,Arquero arquero,Guerrero guerrero) {
        super(nombrePersonaje, puntosVida, nivelExperiencia);
        this.hechizos = new ArrayList<>(hechizos);
        this.poderesMagicos = new ArrayList<>(poderesMagicos);
        this.arquero=arquero;
        this.guerrero=guerrero;
    }
    public void agregarHechizo(String hechizo){
        hechizos.add(hechizo);
    }
    public void eliminarHechizo(String hechizo){
        hechizos.remove(hechizo);
    }
    public List<String> getHechizos() {
        return hechizos;
    }
    public void agregarPoderMagico(String poderMagico){
        poderesMagicos.add(poderMagico);
    }
    public void removerPoderMagico(String poderMagico){
        poderesMagicos.remove(poderMagico);
    }
    public List<String>getPoderesMagicos(){
        return poderesMagicos;
    }
    public void ataque() {
        Personaje personaje = null;
        int dano = 30;
        List<String> habilidades = new ArrayList<>();
        habilidades.addAll(hechizos);
        habilidades.addAll(poderesMagicos);
        if (!habilidades.isEmpty()) {
            int indiceHabilidad = (int) (Math.random() * habilidades.size());
            String habilidad = habilidades.get(indiceHabilidad);
            System.out.println("El Mago " + this.getNombrePersonaje() + " utiliza '" + habilidad + "' contra " + personaje.getNombrePersonaje());
            personaje.disminuirPuntosVida(dano);
            System.out.println("¡El ataque ha sido realizado!");
        } else {
            System.out.println("El Mago no tiene habilidades disponibles para atacar.");
        }
    }
    public int defensa() {
        int valorDefensa = 20;
        return valorDefensa;
    }
    public void subirNivel() {
        if (guerrero != null && arquero != null) {
            System.out.println("El Mago no puede subir de nivel hasta derrotar tanto al Guerrero como al Arquero.");
            return;
        }
        System.out.println("El Mago ha derrotado al Guerrero y al Arquero, ¡sube de nivel!");
        setNivelExperiencia(getNivelExperiencia() + 1);
    }
    public void evaluarCombate() {
        if (guerrero != null) {
            if (this.getPuntosVida() > 0) {
                System.out.println("El Mago ha ganado el combate contra el Guerrero.");
            } else {
                System.out.println("El Mago ha perdido el combate contra el Guerrero.");
            }
        }
        if (arquero != null) {
            if (this.getPuntosVida() > 0) {
                System.out.println("El Mago ha ganado el combate contra el Arquero.");
            } else {
                System.out.println("El Mago ha perdido el combate contra el Arquero.");
            }
        }
    }
}
