package paquete02;
abstract public class Menu {
    protected String nombrePlato;
    protected double valorMenu;
    protected double valorInicialMenu;
    protected double valorBebida;
    protected double totalPagar;
    public Menu() {}
    public Menu(String nombrePlato, double valorMenu,
                double valorInicialMenu, double valorBebida) {
        this.nombrePlato = nombrePlato;
        this.valorMenu = valorMenu;
        this.valorInicialMenu = valorInicialMenu;
        this.valorBebida = valorBebida;
    }
    public String getNombrePlato() {
        return nombrePlato;
    }
    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }
    public double getValorMenu() {
        return valorMenu;
    }
    public void setValorMenu(double valorMenu) {
        this.valorMenu = valorMenu;
    }
    public double getValorInicialMenu() {
        return valorInicialMenu;
    }
    public void setValorInicialMenu(double valorInicialMenu) {
        this.valorInicialMenu = valorInicialMenu;
    }
    public double getValorBebida() {
        return valorBebida;
    }
    public void setValorBebida(double valorBebida) {
        this.valorBebida = valorBebida;
    }
    public abstract void calcularTotalPagar();
    @Override
    public String toString() {
        return "Menu{" +
                "nombrePlato='" + nombrePlato + '\'' +
                ", valorMenu=" + valorMenu +
                ", valorInicialMenu=" + valorInicialMenu +
                ", valorBebida=" + valorBebida +
                ", totalPagar=" + totalPagar +
                '}';
    }
}
