package paquete06;
import paquete02.Menu;
public class MenuEconomico extends Menu {
    private double porcentajeDescuento;
    public MenuEconomico() {}
    public MenuEconomico(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
    public MenuEconomico(String nombrePlato, double valorMenu, double valorInicialMenu,
                         double valorBebida, double porcentajeDescuento) {
        super(nombrePlato, valorMenu, valorInicialMenu, valorBebida);
        this.porcentajeDescuento = porcentajeDescuento;
    }
    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }
    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }
    public void calcularTotalPagar(){
        double descuento = valorInicialMenu * porcentajeDescuento / 100;
        this.totalPagar = valorInicialMenu - descuento;
    }
    public double getTotalPagar(){
        return totalPagar;
    }
    @Override
    public String toString() {
        return "MenuEconomico{" +
                "porcentajeDescuento=" + porcentajeDescuento +
                ", nombrePlato='" + nombrePlato + '\'' +
                ", valorMenu=" + valorMenu +
                ", valorInicialMenu=" + valorInicialMenu +
                ", valorBebida=" + valorBebida +
                ", totalPagar=" + totalPagar +
                '}';
    }
}
