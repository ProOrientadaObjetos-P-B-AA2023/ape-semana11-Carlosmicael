package paquete07;
import paquete02.Menu;
import java.util.ArrayList;
import java.util.List;
public class CuentaPagar {
    private String nombreCliente;
    private List<Menu>listaMenus;
    private double valorTotal;
    private double subTotal;
    private double iva;
    public CuentaPagar() {}
    public CuentaPagar(String nombreCliente,double iva) {
        this.nombreCliente = nombreCliente;
        this.listaMenus = new ArrayList<>();
        this.iva=iva;
    }
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    public String getNombreCliente() {
        return nombreCliente;
    }
    public double getIva() {
        return iva;
    }
    public void setIva(double iva) {
        this.iva = iva;
    }
    public void agregarMenu(Menu menu) {
        listaMenus.add(menu);
    }
    public void calcularSubtotal() {
        for (Menu menu : listaMenus) {
            this.subTotal += menu.getValorMenu();
        }
    }
    public double getSubTotal(){
        return subTotal;
    }
    public void calcularIVA() {
        this.iva=(iva/100);
        this.iva = this.subTotal * iva;
    }
    public void calcularTotalPagar() {
        this.valorTotal = this.subTotal + iva;
    }
    public double getValorTotal(){
        return valorTotal;
    }
    @Override
    public String toString() {
        return "CuentaPagar{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", listaMenus=" + listaMenus +
                ", valorTotal=" + valorTotal +
                ", subTotal=" + subTotal +
                ", iva=" + iva +
                '}';
    }
}
