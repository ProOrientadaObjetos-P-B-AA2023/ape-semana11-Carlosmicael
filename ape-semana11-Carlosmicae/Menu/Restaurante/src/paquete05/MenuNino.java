package paquete05;
import paquete02.Menu;
public class MenuNino extends Menu {
    private double valorHelado;
    private double valorPastel;
    public MenuNino() {}
    public MenuNino(double valorHelado, double valorPastel) {
        this.valorHelado = valorHelado;
        this.valorPastel = valorPastel;
    }
    public MenuNino(String nombrePlato, double valorMenu, double valorInicialMenu, double valorBebida,
                    double valorHelado, double valorPastel) {
        super(nombrePlato, valorMenu, valorInicialMenu, valorBebida);
        this.valorHelado = valorHelado;
        this.valorPastel = valorPastel;
    }
    public double getValorHelado() {
        return valorHelado;
    }
    public void setValorHelado(double valorHelado) {
        this.valorHelado = valorHelado;
    }
    public double getValorPastel() {
        return valorPastel;
    }
    public void setValorPastel(double valorPastel) {
        this.valorPastel = valorPastel;
    }
    public void calcularTotalPagar(){
        this.totalPagar = valorInicialMenu + valorHelado + valorPastel;
    }
    public double getTotalPagar(){
        return totalPagar;
    }
}
