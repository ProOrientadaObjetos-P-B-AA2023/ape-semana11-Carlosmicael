package paquete04;
import paquete02.Menu;
public class MenuDia extends Menu {
    private double valorPostre;
    public MenuDia() {}
    public MenuDia(double valorPostre) {
        this.valorPostre = valorPostre;
    }
    public MenuDia(String nombrePlato, double valorMenu, double valorInicialMenu, double valorBebida, double valorPostre) {
        super(nombrePlato, valorMenu, valorInicialMenu, valorBebida);
        this.valorPostre = valorPostre;
    }
    public double getValorPostre() {
        return valorPostre;
    }
    public void setValorPostre(double valorPostre) {
        this.valorPostre = valorPostre;
    }
    public void calcularTotalPagar(){
        this.totalPagar = valorInicialMenu + valorPostre + valorBebida;
    }
    public double getTotalPagar(){
        return totalPagar;
    }
}
