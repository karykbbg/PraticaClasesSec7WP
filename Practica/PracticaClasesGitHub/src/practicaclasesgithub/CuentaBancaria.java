/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclasesgithub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.text.SimpleDateFormat;
import java.text.ParseException;


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
    private static ArrayList<CuentaBancaria> CuentaBancaria = new ArrayList<CuentaBancaria>();

    public CuentaBancaria() {
    }

    public CuentaBancaria(String fechaAper, long idCuenta, String numCuenta) {
        fechaApertura = fechaAper;
        idCuentaBancaria = idCuenta;
        numeroCuenta = numCuenta;
    }

    public CuentaBancaria getNewObject() {
        return new CuentaBancaria();
    }

    public void createCuentaBancaria() {


        InputStreamReader lector = new InputStreamReader(System.in);
        BufferedReader entrada = new BufferedReader(lector);

        try {

            //tipo de cuenta
            System.out.println(" Ingrese Id de la cuenta :  ");
            this.idCuentaBancaria = Long.parseLong(entrada.readLine());

            System.out.println(" Ingrese numero de cuenta :  ");
            this.numeroCuenta = entrada.readLine();

            System.out.println("Fecha de creacion cuenta (dd/mm/aaaa):  ");
            this.fechaApertura = entrada.readLine();

            if (this.validarFecha(fechaApertura) == true) {
                CuentaBancaria.add(this);
            }



        } catch (IOException e) {
            System.out.println("No válido\n" + e);
        }


    }

    public long getCuentaBancariaByID() {
        return idCuentaBancaria;
    }

    public boolean validarFecha(String fecha) {

        if (fecha == null) {
            return false;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (fecha.trim().length() != dateFormat.toPattern().length()) {
            return false;
        }

        dateFormat.setLenient(false);

        try {
            dateFormat.parse(fecha.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
}
