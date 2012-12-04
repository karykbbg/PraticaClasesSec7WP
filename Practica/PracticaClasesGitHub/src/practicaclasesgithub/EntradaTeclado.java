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
 * @author unet
 */
public class EntradaTeclado {
       
        InputStreamReader lector;
        BufferedReader entrada; 
        
        public void EntradaTeclado()
        {
        lector = new InputStreamReader(System.in);
        entrada = new BufferedReader(lector);
        }
        
        public int leerValorEntero() throws IOException
        {
            int valorTeclado=0;
            boolean Errorlectura; 
             do{
                    
                    try
                        {
                         Errorlectura=false;
                         System.out.println("-> \n");
                         valorTeclado = Integer.parseInt(entrada.readLine());
                        }catch (NumberFormatException error) 
                        {                           
                            System.out.println("Número no válido\n" + error);  
                            Errorlectura=true;                             
                        }                   
                }while(Errorlectura == true);
             
            return valorTeclado;
        }
        
        //método para la lectura por teclado de varibles long
        public long leerValorLong() throws IOException
        {
            long valorTeclado=0;
             boolean Errorlectura;         
             do {
                        try
                        {
                            Errorlectura=false;
                            System.out.println("-> \n");  
                            valorTeclado = new Long(Long.parseLong(entrada.readLine()));
                        }catch (IOException error) 
                        {                           
                            System.out.println("Numero no válido\n" + error);  
                            Errorlectura=true; 
                            
                        }
             } while( Errorlectura == true);
            
            return valorTeclado;
        }
        
        //método para leer por teclado una cadena de caracteres
        public String leerCadenaCaracteres(int longitudMax) throws IOException
        {
             String valorTeclado="";
             boolean ErrorValidacion;
              do {
                  ErrorValidacion = false;
                   try
                    {
                        
                     System.out.println("-> \n");
                     valorTeclado = entrada.readLine();
                     if( valorTeclado.length() > longitudMax )
                     { 
                        System.out.println("Tamaño no válido Máximo  \n" + longitudMax + " caracteres");  
                     }
                    }catch (IOException error) 
                        {
                           System.out.println("Error de lectura \n" + error);
                           ErrorValidacion = true;                           
                        }
             } while( ErrorValidacion == true);
             return valorTeclado;
        }
    
}
