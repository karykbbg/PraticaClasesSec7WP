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
 * @author Kary Bonilla
 * @author Monica Batista
 * @author Johanna Duarte
 * @author Naretza Ovalles
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
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(entrada);

        do {

            opcionMenuPcpal = MenuPrincipal(); //Genera el Menu principal
            clear();//simula un limpiar pantalla

            switch (opcionMenuPcpal) { // Eleige la opcion acorde al numero de mes           
                case 1: {  //Inicia menu de operaciones realizadas por el cliente      
                    do {
                        opcionMenuMaestros = MenuMestros(); //Genera el menu de maestros
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

                        CuentaBancaria cuenta = new CuentaBancaria();
                        OperacionBancaria operacion = new OperacionBancaria();
                        switch (opcionMenuCliente) {
                            case 1://Registrar nuevo cliente
                                break;
                            case 2://Aperturar cuentas
                                cuenta.createCuentaBancaria();
                                break;
                            case 3://realizar operacion bancaria
                                operacion.createOperacionBancaria();
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

                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
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
                    System.out.println("FIN DEL PROGRAMA...");
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

    public static int MenuPrincipal() {

        int opcionMenuPcpal = 0;
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(entrada);
        // EntradaTeclado leeTeclado = new EntradaTeclado();

        System.out.println("        -------------------------------     ");
        System.out.println("                MENÚ PRINCIPAL              ");
        System.out.println("        -------------------------------     ");
        System.out.println("        1.... CARGAR MAESTROS               ");
        System.out.println("        2.... OPERACIONES DEL CLIENTE       ");
        System.out.println("        3.... REPORTES                      ");
        System.out.println("        4.... SALIR                         ");
        System.out.println("        -------------------------------     ");

        do {
            System.out.print("      INTRODUZCA EL N° DE LA OPCION: ");
            try {
                opcionMenuPcpal = Integer.parseInt(lector.readLine()); //leeTeclado.leerValorEntero();
            } catch (IOException ex) {
                Logger.getLogger(PracticaClasesGitHub.class.getName()).log(Level.SEVERE, null, ex);
            }

            if ((opcionMenuPcpal > 4) || (opcionMenuPcpal < 1)) {
                System.out.println("\n      ERROR:____NO EXISTE LA OPCION SELECCIONADA");
            }

        } while ((opcionMenuPcpal > 4) || (opcionMenuPcpal < 1));

        return opcionMenuPcpal;

    }

    //-------------------------------------------------------
    public static int MenuCliente() {

        int opcionMenuCliente = 0;
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(entrada);

        System.out.println("            -------------------------------------   ");
        System.out.println("                 MENÚ OPERACIONES CLIENTE           ");
        System.out.println("            -------------------------------------   ");
        System.out.println("            (1).... REGISTRAR NUEVO CLIENTE         ");
        System.out.println("            (2).... APERTURAR CUENTA BANCARIA       ");
        System.out.println("            (3).... REALIZAR OPERACION BANCARIA     ");
        System.out.println("            (4).... SALIR MENÚ CLIENTE              ");
        System.out.println("            -------------------------------------   ");

        do {
            System.out.print("              INTRODUZCA EL N° DE LA OPCIÓN: ");
            try {
                opcionMenuCliente = Integer.parseInt(lector.readLine());
            } catch (IOException ex) {
                Logger.getLogger(PracticaClasesGitHub.class.getName()).log(Level.SEVERE, null, ex);
            }

            if ((opcionMenuCliente > 4) || (opcionMenuCliente < 1)) {
                System.out.println("\n      ERROR:____NO EXISTE LA OPCION SELECCIONADA");
            }

        } while ((opcionMenuCliente > 4) || (opcionMenuCliente < 1));

        return opcionMenuCliente;
    }

//-------------------------------------------------------
    public static int MenuMestros() {

        int opcionMenuMaestros = 0;
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(entrada);

        System.out.println("            ----------------------------------------------  ");
        System.out.println("            MENÚ CARGA DE TIPOS DE CUENTAS Y OPERACIONES    ");
        System.out.println("            ----------------------------------------------  ");
        System.out.println("                (1).... REGISTRAR TIPOS DE CUENTAS          ");
        System.out.println("                (2).... REGISTRAR TIPOS DE OPERACIONES      ");
        System.out.println("                (3).... SALIR                               ");
        System.out.println("            ----------------------------------------------  ");

        do {
            System.out.print("              INTRODUZCA EL N° DE LA OPCIÓN: ");
            try {
                opcionMenuMaestros = Integer.parseInt(lector.readLine());
            } catch (IOException ex) {
                Logger.getLogger(PracticaClasesGitHub.class.getName()).log(Level.SEVERE, null, ex);
            }

            if ((opcionMenuMaestros > 3) || (opcionMenuMaestros < 1)) {
                System.out.println("\n      ERROR:____NO EXISTE LA OPCION SELECCIONADA");
            }

        } while ((opcionMenuMaestros > 3) || (opcionMenuMaestros < 1));

        return opcionMenuMaestros;

    }

    //-------------------------------------------------------
    public static int MenuReportes() {

        int opcionMenuReporte = 0;
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(entrada);

        System.out.println("            ----------------------------------------------------    ");
        System.out.println("                                 MENÚ REPORTES                      ");
        System.out.println("            ----------------------------------------------------    ");
        System.out.println("            (1).... OBSERVAR CUENTAS POR USUARIO                    ");
        System.out.println("            (2).... DETALLE DE OPERACIONES BANCARIAS POR CUENTA     ");
        System.out.println("            (3).... LISTADO DE CLIENTES                             ");
        System.out.println("            (4).... LISTADO DE CUENTAS POR TIPO                     ");
        System.out.println("            (5).... LISTADO DE TIPOS DE OPERACIONES                 ");
        System.out.println("            (6).... LISTADO DE TIPOS DE CUENTAS                     ");
        System.out.println("            (7).... SALIR                                           ");
        System.out.println("            -----------------------------------------------------   ");

        do {
            System.out.print("              INTRODUZCA EL N° DE LA OPCIÓN: ");
            try {
                opcionMenuReporte = Integer.parseInt(lector.readLine());
            } catch (IOException ex) {
                Logger.getLogger(PracticaClasesGitHub.class.getName()).log(Level.SEVERE, null, ex);
            }

            if ((opcionMenuReporte > 7) || (opcionMenuReporte < 1)) {
                System.out.println("\n      ERROR:____NO EXISTE LA OPCION SELECCIONADA");
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
