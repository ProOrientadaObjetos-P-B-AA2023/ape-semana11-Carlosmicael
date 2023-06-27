package paquete01;
import paquete02.Menu;
import paquete03.MenuCarta;
import paquete04.MenuDia;
import paquete05.MenuNino;
import paquete06.MenuEconomico;
import paquete07.CuentaPagar;
import java.util.ArrayList;
public class Ejecutor01 {
    public static void main(String[] args) {
        String[][] datosMenuNino = {
                {"Niños 01", "2.50", "2", "1.5", "1"},
                {"Niños 02", "3.25", "1", "2.0", "3"},
                {"Niños 03", "2.75", "3", "0.5", "7"}
        };
        String[][] datosMenuEconomico = {
                {"Econo 001", "4.50", "20", "23"},
                {"Econo 002", "4.75", "15", "12"},
                {"Econo 003", "5.00", "30", "59"}
        };
        String[][] datosMenuDia = {
                {"Dia 001", "6.00", "1", "1", "2"},
                {"Dia 002", "7.50", "2", "2", "5"},
                {"Dia 003", "5.75", "3", "1", "7"}
        };
        String[][] datosMenuCarta = {
                {"Carta 001", "7.00", "1.5", "2", "10", "5"},
                {"Carta 002", "8.25", "1.7", "2.1", "5", "2"},
                {"Carta 003", "9.50", "1.9", "2.2", "5", "8"},
                {"Carta 004", "10.00", "2.5", "2.9", "5", "9"}
        };
        ArrayList<Menu> lista = new ArrayList<>();
        for (String[] dato : datosMenuNino) {
            String nombrePlato = dato[0];
            double valorMenu = Double.parseDouble(dato[1]);
            double valorInicialMenu = Double.parseDouble(dato[2]);
            double valorPorcionHelado = Double.parseDouble(dato[3]);
            double valorPorcionPastel = Double.parseDouble(dato[4]);
            MenuNino menuNino = new MenuNino(nombrePlato, valorMenu, valorInicialMenu, 0, valorPorcionHelado, valorPorcionPastel);
            lista.add(menuNino);
        }
        for (String[] dato : datosMenuEconomico) {
            String nombrePlato = dato[0];
            double valorMenu = Double.parseDouble(dato[1]);
            double valorInicialMenu = Double.parseDouble(dato[2]);
            double porcentajeDescuento = Double.parseDouble(dato[3]);
            MenuEconomico menuEconomico = new MenuEconomico(nombrePlato, valorMenu, valorInicialMenu, 0, porcentajeDescuento);
            lista.add(menuEconomico);
        }
        for (String[] dato : datosMenuDia) {
            String nombrePlato = dato[0];
            double valorMenu = Double.parseDouble(dato[1]);
            double valorInicialMenu = Double.parseDouble(dato[2]);
            double valorBebida = Double.parseDouble(dato[3]);
            double valorPostre = Double.parseDouble(dato[4]);
            MenuDia menuDia = new MenuDia(nombrePlato, valorMenu, valorInicialMenu, valorBebida, valorPostre);
            lista.add(menuDia);
        }
        for (String[] dato : datosMenuCarta) {
            String nombrePlato = dato[0];
            double valorMenu = Double.parseDouble(dato[1]);
            double valorInicialMenu = Double.parseDouble(dato[2]);
            double valorBebida = Double.parseDouble(dato[3]);
            double valorPorcionGuarnicion = Double.parseDouble(dato[4]);
            double valorPorcentajeAdicionalServicio = Double.parseDouble(dato[5]);
            MenuCarta menuCarta = new MenuCarta(nombrePlato, valorMenu, valorInicialMenu, valorBebida, valorPorcionGuarnicion, valorPorcentajeAdicionalServicio);
            lista.add(menuCarta);
        }
        for (Menu menu : lista) {
            menu.calcularTotalPagar();
        }
        CuentaPagar miCuenta = new CuentaPagar("Carlos Lopez", 10);
        miCuenta.calcularTotalPagar();
        System.out.printf("%s\n", miCuenta);
    }
}
