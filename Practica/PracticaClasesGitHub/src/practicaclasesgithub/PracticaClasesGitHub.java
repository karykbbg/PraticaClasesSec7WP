/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclasesgithub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(entrada);

        do {

            System.out.println("------------------------");
            System.out.println("     MENU PRINCIPAL");
            System.out.println("------------------------");
            System.out.println("1.... CARGAR MAESTROS");
            System.out.println("2.... OPERACIONES DEL CLIENTE");
            System.out.println("3.... REPORTES");
            System.out.println("4.... SALIR");
            System.out.println("------------------------");

            do {
                System.out.print("INTRODUZCA EL N° DE LA OPCION: ");
                opcionMenuPcpal = Integer.parseInt(lector.readLine());

                if ((opcionMenuPcpal > 4) || (opcionMenuPcpal < 1)) {
                    System.out.println("NO EXISTE LA OPCION SELECCIONADA");
                }

            } while ((opcionMenuPcpal > 4) || (opcionMenuPcpal < 1));


            System.out.println("");

            switch (opcionMenuPcpal) { // Eleige la opcion acorde al numero de mes
             case 1: {             
             break;
             }
             case 2:
             break;
             case 3:
             break;
             case 4:
                 System.exit(0);
             break;             
             default: // El default es para cuando no se ejecuto ninguna de las otras opciones
             System.out.println("Opcion invalida");
             break;
             }

            
        } while (opcionMenuPcpal!=4);
        System.out.println("\nHasta pronto!");
    }
}
