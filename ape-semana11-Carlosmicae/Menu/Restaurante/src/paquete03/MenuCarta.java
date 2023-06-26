package paquete03;
import paquete02.Menu;
public class MenuCarta extends Menu {
   private double valorPorcion;
   private double porcentajeServicio;
    public MenuCarta() {}
    public MenuCarta(double valorPorcion, double porcentajeServicio) {
        this.valorPorcion = valorPorcion;
        this.porcentajeServicio = porcentajeServicio;
    }
    public MenuCarta(String nombrePlato, double valorMenu, double valorInicialMenu, double valorBebida, double valorPorcion, double porcentajeServicio) {
        super(nombrePlato, valorMenu, valorInicialMenu, valorBebida);
        this.valorPorcion = valorPorcion;
        this.porcentajeServicio = porcentajeServicio;
    }
    public double getValorPorcion() {
        return valorPorcion;
    }
    public void setValorPorcion(double valorPorcion) {
        this.valorPorcion = valorPorcion;
    }
    public double getPorcentajeServicio() {
        return porcentajeServicio;
    }
    public void setPorcentajeServicio(double porcentajeServicio) {
        this.porcentajeServicio = porcentajeServicio;
    }
    public void calcularTotalPagar() {
        this.totalPagar= valorInicialMenu + valorPorcion + valorBebida;
        double servicio = (porcentajeServicio / 100) * valorInicialMenu;
        this.totalPagar = totalPagar + servicio;
    }
    public double getTotalPagar(){
        return totalPagar;
    }
}
