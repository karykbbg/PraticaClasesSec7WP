/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclasesgithub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Seccion: 7 Grupo de Exposicion Windows Phone
 *
 * @author Kary Bonilla CI 15233412
 * @author Monica Batista CI 14281041
 * @author Johanna Duarte CI 15538692
 * @author Naretza Ovalles CI 17021921
 */
public class PracticaClasesGitHub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        int opcionMenuPcpal;
        int opcionMenuCliente;
        int opcionMenuMaestros;
        int opcionMenuReportes;
        String fechaInicio;
        String fechaFinal;

        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(entrada);

        do {

            opcionMenuPcpal = MenuPrincipal(); //Genera el Menu principal
            clear();//simula un limpiar pantalla

            switch (opcionMenuPcpal) { // Eleige la opcion acorde al numero de mes           
                case 1: {  //Inicia menu de operaciones realizadas por el cliente      
                    do {
                        opcionMenuMaestros = MenuMaestros(); //Genera el menu de maestros
                        clear();

                        TipoCuenta tipo = new TipoCuenta();
                        TipoOperacion tipOp = new TipoOperacion();

                        switch (opcionMenuMaestros) {
                            case 1://crear tipo de cuenta
                                tipo.addTipoCuenta();
                                break;
                            case 2://crear tipo de operacion
                                tipOp.addTipoOperacion();
                                break;

                        }

                    } while (opcionMenuMaestros != 3);

                    break;
                }
                case 2: {
                    do {
                        opcionMenuCliente = MenuCliente(); //Genera el menu cliente
                        clear();




                        switch (opcionMenuCliente) {
                            case 1://Registrar nuevo cliente
                                Cliente nuevoCliente = new Cliente();
                                nuevoCliente.createCliente();
                                break;
                            case 2://Aperturar cuentas
                                Cliente clienteAperturaCuenta = new Cliente();
                                CuentaBancaria cuenta = new CuentaBancaria();

                                if (clienteAperturaCuenta.getCantidadClientes() > 0) {
                                    clienteAperturaCuenta = clienteAperturaCuenta.buscarCliente();
                                    if (clienteAperturaCuenta.idCliente != -1) {
                                        cuenta.idCuentaBancaria = -1;
                                        cuenta.numeroCuenta = "";

                                        do {
                                            cuenta.createCuentaBancaria(clienteAperturaCuenta);
                                            System.out.println(" Cuenta :" + cuenta.numeroCuenta);
                                            if (cuenta.elementoEncontrado != 1) {
                                                clienteAperturaCuenta.agregarCuentaBancaria(cuenta);
                                            } else {
                                                System.out.println("        \033[31m La cuenta no ha sido asociada por favor  verifique los datos a ingresar");
                                            }
                                        } while (cuenta.elementoEncontrado == 1);
                                    } else {
                                        System.out.println("        \033[31m Si el cliente no esta registrado por favor dirijase al menu y seleccione registrar un nuevo cliente");
                                    }
                                }
                                if (clienteAperturaCuenta.getCantidadClientes() == 0) {
                                    System.out.println("        \033[31m Debe registrar un cliente al cual asociar la cuenta");

                                    clienteAperturaCuenta.createCliente();
                                }
                                break;
                            case 3://realizar operacion bancaria
                                OperacionBancaria operacion = new OperacionBancaria();
                                TipoOperacion listaTiposOperacion = new TipoOperacion();
                                if (listaTiposOperacion.cantidadTipoOperaciones() > 0) {
                                    operacion.createOperacionBancaria();
                                } else {
                                    System.out.println("  \033[31m No se puede procesar ninguna operación bancaria hasta no configurar los tipos de operaciones");

                                }
                                break;

                        }

                    } while (opcionMenuCliente != 4);
                    break;
                }
                case 3: {
                    do {
                        opcionMenuReportes = MenuReportes();
                        TipoOperacion tipOp = new TipoOperacion();
                        clear();

                        TipoCuenta tipo = new TipoCuenta();
                        switch (opcionMenuReportes) {
                            case 1:
                                Cliente clienteConsulta = new Cliente();
                                clienteConsulta.consultar();
                                lector.readLine();
                                break;
                            case 2:
                                OperacionBancaria operacion = new OperacionBancaria();
                                System.out.println("DESDE: ");
                                fechaInicio = operacion.leerFecha();
                                System.out.println("HASTA: ");
                                fechaFinal = operacion.leerFecha();
                                operacion.getListOperacionesByDate(fechaInicio, fechaFinal);
                                System.out.println("Presione Enter para continuar ");
                                lector.readLine();
                                break;
                            case 3:
                                Cliente clienteReporte = new Cliente();
                                clienteReporte.listadoClientes();
                                lector.readLine();
                                break;
                            case 4:
                                CuentaBancaria cuenta = new CuentaBancaria();
                                cuenta.ListarCuentaporTipo();
                                lector.readLine();
                                break;
                            case 5:
                                tipOp.ListarTipOperacion();
                                break;
                            case 6:
                                tipo.ListarTipoCuenta();
                                break;

                        }


                    } while (opcionMenuReportes != 7);
                    break;
                }
                case 4:
                    System.out.println("\033[31mFIN DEL PROGRAMA...");
                    System.exit(0);
                    break;
                default: // El default es para cuando no se ejecuto ninguna de las otras opciones
                    System.out.println("Opcion invalida");
                    break;
            }


        } while (opcionMenuPcpal != 4);
        System.out.println("\nHasta pronto!");
    }
//----------------------------------------------

    public static boolean esEntero(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            if (!Character.isDigit(cadena.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static int MenuPrincipal() {

        int opcionMenuPcpal = 0;
        String op;
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(entrada);
        // EntradaTeclado leeTeclado = new EntradaTeclado();

        System.out.println("        \033[31m-------------------------------     ");
        System.out.println("                \033[31mMENÚ PRINCIPAL              ");
        System.out.println("        \033[31m-------------------------------     ");
        System.out.println("        \033[34m1.... CARGAR MAESTROS               ");
        System.out.println("        \033[34m2.... OPERACIONES DEL CLIENTE       ");
        System.out.println("        \033[34m3.... REPORTES                      ");
        System.out.println("        \033[34m4.... SALIR                         ");
        System.out.println("        \033[31m-------------------------------     ");

        do {
            System.out.print("      \033[34mINTRODUZCA EL N° DE LA OPCION: ");

            try {
                op = lector.readLine();
                if (op.isEmpty() || !PracticaClasesGitHub.esEntero(op)) {//valida en caso que nos seleccione ninguna opcion
                    op = "0";
                }
                opcionMenuPcpal = Integer.parseInt(op); //leeTeclado.leerValorEntero();

            } catch (IOException ex) {
                Logger.getLogger(PracticaClasesGitHub.class.getName()).log(Level.SEVERE, null, ex);
            }

            if ((opcionMenuPcpal > 4) || (opcionMenuPcpal < 1)) {
                System.out.println("\n      \033[31mERROR:____NO EXISTE LA OPCION SELECCIONADA\n");
            }

        } while ((opcionMenuPcpal > 4) || (opcionMenuPcpal < 1));

        return opcionMenuPcpal;

    }

    //-------------------------------------------------------
    public static int MenuCliente() {

        int opcionMenuCliente = 0;
        String op;
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(entrada);

        System.out.println("            \033[31m-------------------------------------   ");
        System.out.println("                 \033[31mMENÚ OPERACIONES CLIENTE           ");
        System.out.println("            \033[31m-------------------------------------   ");
        System.out.println("            \033[34m(1).... REGISTRAR NUEVO CLIENTE         ");
        System.out.println("            \033[34m(2).... APERTURAR CUENTA BANCARIA       ");
        System.out.println("            \033[34m(3).... REALIZAR OPERACION BANCARIA     ");
        System.out.println("            \033[34m(4).... SALIR MENÚ CLIENTE              ");
        System.out.println("            \033[31m-------------------------------------   ");

        do {
            System.out.print("             \033[34mINTRODUZCA EL N° DE LA OPCIÓN: ");
            System.out.print("");
            System.out.print("");
            System.out.print("");
            try {
                op = lector.readLine();
                if (op.isEmpty() || !PracticaClasesGitHub.esEntero(op)) {//valida en caso que nos seleccione ninguna opcion
                    op = "0";
                }
                opcionMenuCliente = Integer.parseInt(op);
            } catch (IOException ex) {
                Logger.getLogger(PracticaClasesGitHub.class.getName()).log(Level.SEVERE, null, ex);
            }

            if ((opcionMenuCliente > 4) || (opcionMenuCliente < 1)) {
                System.out.println("\n      \033[31mERROR:____NO EXISTE LA OPCION SELECCIONADA\n");
            }

        } while ((opcionMenuCliente > 4) || (opcionMenuCliente < 1));

        return opcionMenuCliente;
    }

//-------------------------------------------------------
    public static int MenuMaestros() {

        int opcionMenuMaestros = 0;
        String op;
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(entrada);

        System.out.println("            \033[31m----------------------------------------------  ");
        System.out.println("            \033[31mMENÚ CARGA DE TIPOS DE CUENTAS Y OPERACIONES    ");
        System.out.println("            \033[31m----------------------------------------------  ");
        System.out.println("                \033[34m(1).... REGISTRAR TIPOS DE CUENTAS          ");
        System.out.println("                \033[34m(2).... REGISTRAR TIPOS DE OPERACIONES      ");
        System.out.println("                \033[34m(3).... SALIR                               ");
        System.out.println("            \033[31m----------------------------------------------  ");

        do {
            System.out.print("              \033[34mINTRODUZCA EL N° DE LA OPCIÓN: ");
            try {
                op = lector.readLine();
                if (op.isEmpty() || !PracticaClasesGitHub.esEntero(op)) {//valida en caso que nos seleccione ninguna opcion
                    op = "0";
                }
                opcionMenuMaestros = Integer.parseInt(op);

            } catch (IOException ex) {
                Logger.getLogger(PracticaClasesGitHub.class.getName()).log(Level.SEVERE, null, ex);
            }

            if ((opcionMenuMaestros > 3) || (opcionMenuMaestros < 1)) {
                System.out.println("\n      ERROR:____NO EXISTE LA OPCION SELECCIONADA\n");
            }

        } while ((opcionMenuMaestros > 3) || (opcionMenuMaestros < 1));

        return opcionMenuMaestros;

    }

    //-------------------------------------------------------
    public static int MenuReportes() {

        int opcionMenuReporte = 0;
        String op;
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(entrada);

        System.out.println("            \033[31m----------------------------------------------------    ");
        System.out.println("                                 \033[31mMENÚ REPORTES                      ");
        System.out.println("            \033[31m----------------------------------------------------    ");
        System.out.println("            \033[34m(1).... OBSERVAR CUENTAS POR USUARIO                    ");
        System.out.println("            \033[34m(2).... DETALLE DE OPERACIONES BANCARIAS POR CUENTA     ");
        System.out.println("            \033[34m(3).... LISTADO DE CLIENTES                             ");
        System.out.println("            \033[34m(4).... LISTADO DE CUENTAS POR TIPO                     ");
        System.out.println("            \033[34m(5).... LISTADO DE TIPOS DE OPERACIONES                 ");
        System.out.println("            \033[34m(6).... LISTADO DE TIPOS DE CUENTAS                     ");
        System.out.println("            \033[34m(7).... SALIR                                           ");
        System.out.println("            \033[31m-----------------------------------------------------   ");

        do {
            System.out.print("             \033[34mINTRODUZCA EL N° DE LA OPCIÓN: ");
            try {
                op = lector.readLine();
                if (op.isEmpty() || !PracticaClasesGitHub.esEntero(op)) {//valida en caso que nos seleccione ninguna opcion
                    op = "0";
                }
                opcionMenuReporte = Integer.parseInt(op);
            } catch (IOException ex) {
                Logger.getLogger(PracticaClasesGitHub.class.getName()).log(Level.SEVERE, null, ex);
            }

            if ((opcionMenuReporte > 7) || (opcionMenuReporte < 1)) {
                System.out.println("\n      ERROR:____NO EXISTE LA OPCION SELECCIONADA\n");
            }

        } while ((opcionMenuReporte > 7) || (opcionMenuReporte < 1));

        return opcionMenuReporte;
    }

    public static void clear() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }
}
