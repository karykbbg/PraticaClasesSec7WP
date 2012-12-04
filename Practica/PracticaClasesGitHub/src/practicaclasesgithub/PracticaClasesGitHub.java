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
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(entrada);

        do {

            opcionMenuPcpal = MenuPrincipal(); //Genera el Menu principal
            System.out.println("");

            switch (opcionMenuPcpal) { // Eleige la opcion acorde al numero de mes           
                case 1: {  //Inicia menu de operaciones realizadas por el cliente      
                    do {
                        opcionMenuMaestros = MenuMestros(); //Genera el menu de maestros
                        switch (opcionMenuMaestros) {
                            case 1:
                                break;
                            case 2:
                                break;

                        }

                    } while (opcionMenuMaestros != 3);

                    break;
                }
                case 2: {
                    do {
                        opcionMenuCliente = MenuCliente(); //Genera el menu cliente
                        switch (opcionMenuCliente) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;

                        }

                    } while (opcionMenuCliente != 4);
                    break;
                }
                case 3:
                    break;
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

        System.out.println("------------------------");
        System.out.println("     MENÚ PRINCIPAL");
        System.out.println("------------------------");
        System.out.println("1.... CARGAR MAESTROS");
        System.out.println("2.... OPERACIONES DEL CLIENTE");
        System.out.println("3.... REPORTES");
        System.out.println("4.... SALIR");
        System.out.println("------------------------");

        do {
            System.out.print("INTRODUZCA EL N° DE LA OPCION: ");
            try {
                opcionMenuPcpal = Integer.parseInt(lector.readLine());
            } catch (IOException ex) {
                Logger.getLogger(PracticaClasesGitHub.class.getName()).log(Level.SEVERE, null, ex);
            }

            if ((opcionMenuPcpal > 4) || (opcionMenuPcpal < 1)) {
                System.out.println("NO EXISTE LA OPCION SELECCIONADA");
            }

        } while ((opcionMenuPcpal > 4) || (opcionMenuPcpal < 1));

        return opcionMenuPcpal;

    }

    //-------------------------------------------------------
    public static int MenuCliente() {

        int opcionMenuCliente = 0;
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(entrada);
        try {
            System.out.println("-------------------------------");
            System.out.println("     MENÚ OPERACIONES CLIENTE");
            System.out.println("-------------------------------");
            System.out.println("(1).... REGISTRAR NUEVO CLIENTE");
            System.out.println("(2).... APERTURAR CUENTA BANCARIA");
            System.out.println("(3).... REALIZAR OPERACION BANCARIA");
            System.out.println("(4).... SALIR MENÚ CLIENTE");
            System.out.println("---------------------------------");
            opcionMenuCliente = Integer.parseInt(lector.readLine());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return opcionMenuCliente;

    }

    //-------------------------------------------------------
    public static int MenuMestros() {

        int opcionMenuMaestros = 0;
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(entrada);
        try {
            System.out.println("-------------------------------");
            System.out.println("MENÚ CARGA DE TIPOS DE CUENTAS Y OPERACIONES");
            System.out.println("-------------------------------");
            System.out.println("(1).... REGISTRAR TIPOS DE CUENTAS");
            System.out.println("(2).... REGISTRAR TIPOS DE OPERACIONES");
            System.out.println("(3).... SALIR ");
            System.out.println("---------------------------------");
            opcionMenuMaestros = Integer.parseInt(lector.readLine());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return opcionMenuMaestros;

    }
}
