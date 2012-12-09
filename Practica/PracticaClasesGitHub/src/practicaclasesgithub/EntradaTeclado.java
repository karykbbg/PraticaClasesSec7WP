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
public class EntradaTeclado {

    public void EntradaTeclado() {
    }

    public int leerValorEntero() throws IOException {

        InputStreamReader lector = new InputStreamReader(System.in);
        BufferedReader entrada = new BufferedReader(lector);

        int valorTeclado = 0;
        boolean Errorlectura;
        do {

            try {
                Errorlectura = false;
                System.out.print("-> : ");
                valorTeclado = Integer.parseInt(entrada.readLine());
                if(valorTeclado<=0)
                {
                 System.out.print("        \033[31mNo se permiten valores menores o iguales a cero, Ingrese nuevamente el valor \n");
                 Errorlectura = true;   
                }
            } catch (NumberFormatException error) {
                System.out.print("        \033[31mNúmero no válido " + error + " Ingrese el valor nuevamente");
                Errorlectura = true;
            }
        } while (Errorlectura == true);

        return valorTeclado;
    }

    //método para la lectura por teclado de varibles Float
    public float leerValorFloat() throws IOException {

        InputStreamReader lector = new InputStreamReader(System.in);
        BufferedReader entrada = new BufferedReader(lector);

        float valorTeclado = 0;
        boolean Errorlectura;
        do {

            try {
                Errorlectura = false;
                System.out.print("-> : ");
                valorTeclado = Float.parseFloat(entrada.readLine());
                if(valorTeclado<=0)
                {
                 System.out.print("        \033[31mNo se permiten valores menores o iguales a cero, Ingrese nuevamente el valor \n");
                 Errorlectura = true;   
                }
            } catch (NumberFormatException error) {
                System.out.print("         \033[31mNúmero no válido " + error + " Ingrese el valor nuevamente");
                Errorlectura = true;
            }
        } while (Errorlectura == true);

        return valorTeclado;
    }
    
    //método para la lectura por teclado de varibles long
    public long leerValorLong() throws IOException {
        InputStreamReader lector = new InputStreamReader(System.in);
        BufferedReader entrada = new BufferedReader(lector);

        long valorTeclado = 0;
        boolean Errorlectura;
        do {
            try {
                Errorlectura = false;
                System.out.print("-> : ");
                valorTeclado = Long.parseLong(entrada.readLine());
                if(valorTeclado<=0)
                {
                 System.out.print("        \033[31mNo se permiten valores menores o iguales a cero, Ingrese nuevamente el valor \n");
                 Errorlectura = true;   
                }
            } catch (NumberFormatException error) {
                System.out.print("     \033[31mNumero no válido" + error + " Ingrese el valor nuevamente");
                Errorlectura = true;

            }
        } while (Errorlectura == true);

        return valorTeclado;
    }

    //método para leer por teclado una cadena de caracteres
    public String leerCadenaCaracteres(int longitudMax) throws IOException {

        InputStreamReader lector = new InputStreamReader(System.in);
        BufferedReader entrada = new BufferedReader(lector);

        String valorTeclado = "";
        boolean ErrorValidacion;
        do {
            ErrorValidacion = false;
            try {

                System.out.print("-> : ");
                valorTeclado = entrada.readLine();
                if (valorTeclado.length() > longitudMax) {
                     System.out.print("  \033[31mTamaño no válido Máximo  " + longitudMax + " caracteres \n");
                     ErrorValidacion = true;
                }
                
            } catch (IOException error) {
                System.out.println("  \033[31mError de lectura " + error + " Ingrese el valor nuevamente");
                ErrorValidacion = true;
            }
        } while (ErrorValidacion == true);
        return valorTeclado;
    }
}
