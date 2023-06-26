package paquete01;
import paquete03.MenuCarta;
import paquete04.MenuDia;
import paquete05.MenuNino;
import paquete06.MenuEconomico;
import paquete07.CuentaPagar;
import java.util.Scanner;
public class Ejecutor02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del cliente:");
        String nombreCliente = scanner.nextLine();
        System.out.println("Ingrese el número de opciones de menú que desea agregar:");
        int opcionesMenu = scanner.nextInt();
        scanner.nextLine();
        CuentaPagar cuentaPagar = new CuentaPagar(nombreCliente,10);
        for (int i = 0; i < opcionesMenu; i++) {
            System.out.println("Seleccione una opción de menú:");
            System.out.println("1. Menú Carta");
            System.out.println("2. Menú Día");
            System.out.println("3. Menú Niño");
            System.out.println("4. Menú Económico");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del plato:");
                    String nombrePlato = scanner.nextLine();
                    System.out.println("Ingrese el valor del menú:");
                    double valorMenu = scanner.nextDouble();
                    System.out.println("Ingrese el valor inicial del menú:");
                    double valorInicialMenu = scanner.nextDouble();
                    System.out.println("Ingrese el valor de la bebida:");
                    double valorBebida = scanner.nextDouble();
                    System.out.println("Ingrese el valor de la porción:");
                    double valorPorcion = scanner.nextDouble();
                    System.out.println("Ingrese el porcentaje de servicio:");
                    double porcentajeServicio = scanner.nextDouble();
                    scanner.nextLine();
                    MenuCarta menuCarta = new MenuCarta(nombrePlato, valorMenu, valorInicialMenu, valorBebida, valorPorcion, porcentajeServicio);
                    menuCarta.calcularTotalPagar();
                    cuentaPagar.agregarMenu(menuCarta);
                    System.out.println("Total a Pagar por el menu: "+menuCarta.getTotalPagar());
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del plato:");
                    nombrePlato = scanner.nextLine();
                    System.out.println("Ingrese el valor del menú:");
                    valorMenu = scanner.nextDouble();
                    System.out.println("Ingrese el valor inicial del menú:");
                    valorInicialMenu = scanner.nextDouble();
                    System.out.println("Ingrese el valor de la bebida:");
                    valorBebida = scanner.nextDouble();
                    System.out.println("Ingrese el valor del postre:");
                    double valorPostre = scanner.nextDouble();
                    scanner.nextLine();
                    MenuDia menuDia = new MenuDia(nombrePlato, valorMenu, valorInicialMenu, valorBebida, valorPostre);
                    menuDia.calcularTotalPagar();
                    cuentaPagar.agregarMenu(menuDia);
                    System.out.println("Total a Pagar por el menu: "+menuDia.getTotalPagar());
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del plato:");
                    nombrePlato = scanner.nextLine();
                    System.out.println("Ingrese el valor del menú:");
                    valorMenu = scanner.nextDouble();
                    System.out.println("Ingrese el valor inicial del menú:");
                    valorInicialMenu = scanner.nextDouble();
                    System.out.println("Ingrese el valor de la bebida:");
                    valorBebida = scanner.nextDouble();
                    System.out.println("Ingrese el valor del helado:");
                    double valorHelado = scanner.nextDouble();
                    System.out.println("Ingrese el valor del pastel:");
                    double valorPastel = scanner.nextDouble();
                    scanner.nextLine();
                    MenuNino menuNino = new MenuNino(nombrePlato, valorMenu, valorInicialMenu, valorBebida, valorHelado, valorPastel);
                    menuNino.calcularTotalPagar();
                    cuentaPagar.agregarMenu(menuNino);
                    System.out.println("Total a Pagar por el menu: "+menuNino.getTotalPagar());
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del plato:");
                    nombrePlato = scanner.nextLine();
                    System.out.println("Ingrese el valor del menú:");
                    valorMenu = scanner.nextDouble();
                    System.out.println("Ingrese el valor inicial del menú:");
                    valorInicialMenu = scanner.nextDouble();
                    System.out.println("Ingrese el valor de la bebida:");
                    valorBebida = scanner.nextDouble();
                    System.out.println("Ingrese el porcentaje de descuento:");
                    double porcentajeDescuento = scanner.nextDouble();
                    scanner.nextLine();
                    MenuEconomico menuEconomico = new MenuEconomico(nombrePlato, valorMenu, valorInicialMenu, valorBebida, porcentajeDescuento);
                    menuEconomico.calcularTotalPagar();
                    cuentaPagar.agregarMenu(menuEconomico);
                    System.out.println("Total a Pagar por el menu: "+menuEconomico.getTotalPagar());
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    i--;
                    break;
            }
        }
        cuentaPagar.calcularSubtotal();
        cuentaPagar.calcularIVA();
        cuentaPagar.calcularTotalPagar();
        System.out.println("===== FACTURA =====");
        System.out.println("Cliente: " + cuentaPagar.getNombreCliente());
        System.out.println("Subtotal: $" + cuentaPagar.getSubTotal());
        System.out.println("IVA: " + cuentaPagar.getIva());
        System.out.println("Total a pagar: $" + cuentaPagar.getValorTotal());
    }
}
