/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclasesgithub;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.Date;
import java.util.Calendar;

/**
 *
 * @author Kary Bonilla
 * @author Monica Batista
 * @author Johanna Duarte
 * @author Naretza Ovalles
 */
public class CuentaBancaria {

    private String fechaApertura;
    private long idCuentaBancaria;
    private String numeroCuenta;
    private TipoCuenta TipoCuenta = new TipoCuenta();
    
    //ArrayList cliente = new ArrayList();
   // private static ArrayList<CuentaBancaria> CuentaBancaria = new ArrayList<CuentaBancaria>();

    public CuentaBancaria() {
    }

    public CuentaBancaria(String fechaAper, long idCuenta, String numCuenta) {
        fechaApertura = fechaAper;
        idCuentaBancaria = idCuenta;
        numeroCuenta = numCuenta;
    }

    public void createCuentaBancaria() {
        
        int nroCuentas=0;
        String DescCuenta=TipoCuenta.descripcion;
        long tipoCuenta=TipoCuenta.idTipocuenta;
        
        System.out.println("Tipos de Cuentas:");
        
        for(int cantidadCuentas=0;nroCuentas<cantidadCuentas;cantidadCuentas++)
        {
         System.out.println("* "+ tipoCuenta+"-"+DescCuenta);
        }
        
        
        
    }

    public long getCuentaBancariaByID() {
        return idCuentaBancaria;
    }
}
