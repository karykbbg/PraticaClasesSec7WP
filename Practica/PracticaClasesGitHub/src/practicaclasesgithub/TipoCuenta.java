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
    private static Vector<TipoCuenta> tipoCuenta = new Vector<TipoCuenta>();
    EntradaTeclado recibirDatosTeclado = new EntradaTeclado();
    
    public TipoCuenta() {
    }

    public void addTipoCuenta() throws IOException {

        String respuesta;

        do {

            TipoCuenta obj = new TipoCuenta();
            System.out.println("Ingrese el id del tipo de cuenta: ");
            obj.idTipocuenta = recibirDatosTeclado.leerValorLong();
            System.out.println("Ingrese el nombre del Tipo de cuenta a crear: ");
            obj.descripcion = recibirDatosTeclado.leerCadenaCaracteres(30);

            tipoCuenta.add(obj);

            System.out.println("Desea agregar otro tipo de cuenta: (S/N)");
            respuesta = recibirDatosTeclado.leerCadenaCaracteres(1);
            respuesta = respuesta.toLowerCase();

        } while (respuesta.equals("s"));
    }

public TipoCuenta ListarDatosTipoCuenta() throws IOException {
        
        int indMenu=0;
        int respMenu;
        System.out.println("Seleccione el tipo de cuenta que desea crear: ");
        
        for (int numCta = 0; numCta < tipoCuenta.size(); numCta++) {
            indMenu++;
            System.out.println( indMenu +"...   " + tipoCuenta.elementAt(numCta).descripcion);
        }
       respMenu = recibirDatosTeclado.leerValorEntero();
       return tipoCuenta.get(respMenu-1);
        
    }
}
