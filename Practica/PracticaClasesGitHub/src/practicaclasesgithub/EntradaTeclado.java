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
                System.out.println("-> \n");
                valorTeclado = Integer.parseInt(entrada.readLine());
            } catch (NumberFormatException error) {
                System.out.println("Número no válido\n" + error);
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
                System.out.println("-> \n");
                valorTeclado = Float.parseFloat(entrada.readLine());
            } catch (NumberFormatException error) {
                System.out.println("Número no válido\n" + error);
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
                System.out.println("-> \n");
                valorTeclado = Long.parseLong(entrada.readLine());
            } catch (IOException error) {
                System.out.println("Numero no válido\n" + error);
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

                System.out.println("-> \n");
                valorTeclado = entrada.readLine();
                if (valorTeclado.length() > longitudMax) {
                    System.out.println("Tamaño no válido Máximo  \n" + longitudMax + " caracteres");
                     ErrorValidacion = true;
                }
            } catch (IOException error) {
                System.out.println("Error de lectura \n" + error);
                ErrorValidacion = true;
            }
        } while (ErrorValidacion == true);
        return valorTeclado;
    }
}
