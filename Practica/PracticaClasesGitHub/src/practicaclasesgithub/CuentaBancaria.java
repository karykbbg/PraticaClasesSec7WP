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

    String fechaApertura;
    long idCuentaBancaria;
    String numeroCuenta;
    public int elementoEncontrado = 0;
    public TipoCuenta tiposCuenta = new TipoCuenta();
    EntradaTeclado recibirDatosTeclado = new EntradaTeclado();
    private static ArrayList<CuentaBancaria> CuentaBancarias = new ArrayList<CuentaBancaria>();
    public Cliente Clientes = new Cliente();

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

    public void createCuentaBancaria(Cliente ClienteTitular) throws IOException {


        TipoCuenta tipoCuentaBancaria = new TipoCuenta();

        boolean constanteError;
        int existe;
        //Cliente Titular
        Clientes=ClienteTitular;

        //tipo de cuenta
        tiposCuenta = tipoCuentaBancaria.ListarDatosTipoCuenta();

        if (tiposCuenta.idTipocuenta == -1) {
            //System.out.println("datos:" + tiposCuenta.descripcion + "/" + tiposCuenta.idTipocuenta);
            return;
        }
        // System.out.println("datos entro:" + tiposCuenta.descripcion + "/" + tiposCuenta.idTipocuenta);
        System.out.println("Ingrese Id de la cuenta :  ");
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
            System.out.println("Ingrese numero de cuenta :  ");
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
                        elementoEncontrado = 4;//creada la cuenta
                        System.out.println("\033[34m     Cuenta Bancaria creada con éxito  ");
                        constanteError = false;
                    } else {
                        System.out.println("\033[31m Número no válido\n");
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
            System.out.println("\033[31m \n ERROR:____No se insertó Cuenta Bancaria, código ya existe / Debe utilizar otro identificador _______________\n");
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
            System.out.println("\033[31m \n ERROR:____No se insertó Cuenta Bancaria, Número de cuenta ya existe / Debe utilizar otro identificador _______________\n");
            return 1;
        } else {
            return 0;
        }

    }

     //Buscar numero de cuenta
    public CuentaBancaria BuscarNumCuentaBancaria(String numeroCuent) {


        int posicion = -1;
        int contadorPosiciones = -1;
        CuentaBancaria objDevolver = new CuentaBancaria();
        Iterator listaElementos = CuentaBancarias.iterator();
        while (listaElementos.hasNext()) {
            CuentaBancaria CtaActual = (CuentaBancaria) listaElementos.next();
            contadorPosiciones += 1;
            if (CtaActual.numeroCuenta.compareTo(numeroCuent) == 0) {
                posicion = contadorPosiciones;
                objDevolver=CtaActual;
                break;
            }

        }
        if (posicion > -1) {
             return objDevolver;
         
        } else {
            CuentaBancaria objAux = new CuentaBancaria();
            objAux.numeroCuenta= null;
            System.out.println("\033[31m \n ERROR:____No se encontro Cuenta Bancaria\n");
            return objAux;
        }

    }
    
    public void ListarCuentaActual() throws IOException {

        String entradaTecl = "";
        do {
            System.out.println("\033[34m        ----------------------------------------------------------------    ");
            System.out.println("\033[34m                                  CUENTA                                    ");
            System.out.println("\033[34m        ----------------------------------------------------------------    ");
            System.out.println("\033[34m        ID                  NRO CUENTA                FECHA                 ");
            System.out.println("\033[34m        ----------------------------------------------------------------    ");

            System.out.println("4        " + this.idCuentaBancaria + "                    " + this.numeroCuenta + "                     " + this.fechaApertura);


            System.out.println("Presione cualquier tecla para continuar.....");
            entradaTecl = recibirDatosTeclado.leerCadenaCaracteres(1);

        } while (entradaTecl == "");

    }

    //listado de cuentas
    public void ListarCuenta() throws IOException {

        String entradaTecl = "";
        do {
            System.out.println("        ----------------------------------------------------------------    ");
            System.out.println("                          CUENTAS                                           ");
            System.out.println("        ----------------------------------------------------------------    ");
            System.out.println("        ID                  NRO CUENTA                FECHA                 ");
            System.out.println("        ----------------------------------------------------------------    ");
            for (int numCta = 0; numCta < CuentaBancarias.size(); numCta++) {
                System.out.println("        " + CuentaBancarias.get(numCta).idCuentaBancaria + "              " + CuentaBancarias.get(numCta).numeroCuenta + "                 " + CuentaBancarias.get(numCta).fechaApertura);
            }

            System.out.println("Presione cualquier tecla para continuar.....");
            entradaTecl = recibirDatosTeclado.leerCadenaCaracteres(1);

        } while (entradaTecl == "");

    }

    //listado de cuenta por tipos
    public void ListarCuentaporTipo() throws IOException {
        long idTipo;
        String entradaTecl = "";
        EntradaTeclado recibirDatosTeclado = new EntradaTeclado();

        tiposCuenta.ListarTipoCuenta();//enlisto los tipos de cuenta

        System.out.println("            Ingrese el tipo de cuenta a listar :");
        idTipo = recibirDatosTeclado.leerValorLong();


        Iterator listaElementos = CuentaBancarias.iterator();

        while (listaElementos.hasNext()) {

            CuentaBancaria cuentaListado = (CuentaBancaria) listaElementos.next();

            if (cuentaListado.tiposCuenta.idTipocuenta == idTipo) {
                System.out.println("\033[34m        ----------------------------------------------------------------------------------------");
                System.out.println("\033[34m                          CUENTAS POR TIPO                         ");
                System.out.println("\033[34m        ----------------------------------------------------------------------------------------");
                System.out.println("\033[34m       TIPO CUENTA      ID                  NRO CUENTA                FECHA                     ");
                System.out.println("\033[34m        ----------------------------------------------------------------------------------------");
                System.out.println("        " + cuentaListado.tiposCuenta.descripcion + "              " + cuentaListado.idCuentaBancaria + "              " + cuentaListado.numeroCuenta + "               " + cuentaListado.fechaApertura);
            }
        }
        System.out.println(" Presione cualquier tecla para continuar.....");
        entradaTecl = recibirDatosTeclado.leerCadenaCaracteres(1);


    }
}
