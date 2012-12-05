/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclasesgithub;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Iterator;

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
    private TipoCuenta tiposCuenta = new TipoCuenta();
    //ArrayList cliente = new ArrayList();
    private static ArrayList<CuentaBancaria> CuentaBancarias = new ArrayList<CuentaBancaria>();

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

    public void createCuentaBancaria() throws IOException {

        EntradaTeclado recibirDatosTeclado = new EntradaTeclado();

        TipoCuenta tipoCuentaBancaria = new TipoCuenta();
        
        boolean constanteError;
        int existe;
        int elementoEncontrado = 0;
        //tipo de cuenta
        tipoCuentaBancaria = tiposCuenta.ListarDatosTipoCuenta();
           
        if(tipoCuentaBancaria.idTipocuenta==-1)
        {
         System.out.println("datos:"+tipoCuentaBancaria.descripcion+"/"+tipoCuentaBancaria.idTipocuenta);
         return;
        }
           

        System.out.println(" Ingrese Id de la cuenta :  ");
        this.idCuentaBancaria = recibirDatosTeclado.leerValorLong();
        existe = this.validarIdCuentaBancaria(this.idCuentaBancaria);
        if (existe == 1) {
            elementoEncontrado = 1;
            //CuentaBancarias.add(this);
        } else {
            existe = 0;
            elementoEncontrado = 2;
        }

        if (elementoEncontrado == 2) {
            System.out.println(" Ingrese numero de cuenta :  ");
            this.numeroCuenta = recibirDatosTeclado.leerCadenaCaracteres(50);

            existe = this.validarNumCuentaBancaria(this.numeroCuenta);
            if (existe == 1) {
                elementoEncontrado = 1;
                //CuentaBancarias.add(this);
            } else {
                existe = 0;
                elementoEncontrado = 3;
            }

            if (elementoEncontrado == 3) {
                do {
                    System.out.println("Fecha de creacion cuenta (dd/mm/aaaa):  ");
                    this.fechaApertura = recibirDatosTeclado.leerCadenaCaracteres(10);


                    if (this.validarFecha(fechaApertura) == true) {
                        CuentaBancarias.add(this);
                        constanteError = false;
                    } else {
                        System.out.println("Número no válido\n");
                        constanteError = true;

                    }
                } while (constanteError == true);
            }
        }

    }

    public long getCuentaBancariaByID() {
        return idCuentaBancaria;
    }

    /* Valida si el parámetro es una fecha con el formato "dd/MM/yyyy"
     * return true si cumple el formato, false en caso contrario
     */
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

    //Valida que no exista el id
    public int validarIdCuentaBancaria(long idCuentaBanc) {


        int posicion = -1;
        int contadorPosiciones = -1;
        Iterator listaElementos = CuentaBancarias.iterator();


        while (listaElementos.hasNext()) {

            CuentaBancaria CtaActual = (CuentaBancaria) listaElementos.next();
            contadorPosiciones += 1;

            if (CtaActual.idCuentaBancaria == idCuentaBanc) {
                posicion = contadorPosiciones;
                break;
            }

        }
        if (posicion > -1) {
            System.out.println("\n ERROR:____**No** se insertó Cuenta Bancaria, código ya existe / Debe utilizar otro identificador _______________\n");
            return 1;
        } else {
            return 0;
        }

    }

    //Valida que no exista el numero de cuenta
    public int validarNumCuentaBancaria(String numeroCuent) {


        int posicion = -1;
        int contadorPosiciones = -1;
        Iterator listaElementos = CuentaBancarias.iterator();


        while (listaElementos.hasNext()) {

            CuentaBancaria CtaActual = (CuentaBancaria) listaElementos.next();
            contadorPosiciones += 1;
            if (CtaActual.numeroCuenta.compareTo(numeroCuent) == 0) {
                posicion = contadorPosiciones;
                break;
            }

        }
        if (posicion > -1) {
            System.out.println("\n ERROR:____**No** se insertó Cuenta Bancaria, Número de cuenta ya existe / Debe utilizar otro identificador _______________\n");
            return 1;
        } else {
            return 0;
        }

    }
}
