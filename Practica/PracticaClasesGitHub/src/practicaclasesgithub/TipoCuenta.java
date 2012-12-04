/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclasesgithub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Naretza Ovalles
 */
public class TipoCuenta {

    long idTipocuenta;
    String descripcion;
    static Vector<TipoCuenta> tipoCuenta = new Vector<TipoCuenta>();

    public TipoCuenta() {
    }

    public void addTipoCuenta() {

        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(entrada);
        
        String respuesta;

        try {
            do {
                
                TipoCuenta obj = new TipoCuenta();
                System.out.println("Ingrese el id del tipo de cuenta: ");
                obj.idTipocuenta = Long.parseLong(lector.readLine());
                System.out.println("Ingrese el nombre del Tipo de cuenta a crear: ");
                obj.descripcion = lector.readLine();
                System.out.println("fgfg"+obj.idTipocuenta+"--"+obj.descripcion);
                
                tipoCuenta.add(obj);

                System.out.println("Desea agregar otro tipo de cuenta: (S/N)");
                respuesta = lector.readLine();
                respuesta = respuesta.toLowerCase();

            } while (respuesta.equals("s"));



        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }

    public TipoCuenta ListarDatosTipoCuenta() {
        
        int indMenu=0;
        System.out.println("Seleccione el tipo de cuenta que desea crear: ");
        
        for (int numCta = 0; numCta < tipoCuenta.size(); numCta++) {
            indMenu++;
            System.out.println( indMenu +"...   " + tipoCuenta.elementAt(numCta).descripcion);
        }
        
        return tipoCuenta.get();
        
    }
}
