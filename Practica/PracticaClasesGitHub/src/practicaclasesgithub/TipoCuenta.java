/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclasesgithub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 *
 * @author Naretza Ovalles
 */
public class TipoCuenta {

    long idTipocuenta;
    String descripcion;
    Vector tipoCuenta = new Vector();

    public TipoCuenta() {
    }

    public void addTipoCuenta() {
       
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(entrada);
        try {
           
            System.out.println("Ingrese el id del tipo de cuenta: ");
            idTipocuenta = Long.parseLong(lector.readLine());
            tipoCuenta.add(idTipocuenta);
            System.out.println("Ingrese el nombre del Tipo de cuenta a crear: ");
            descripcion = lector.readLine();
            tipoCuenta.add(descripcion);
            
            
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }
}
