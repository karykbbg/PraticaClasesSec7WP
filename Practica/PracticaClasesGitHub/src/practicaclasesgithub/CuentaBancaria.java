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

    //Crear cuenta bancaria a un cliente
    public void createCuentaBancaria(Cliente ClienteTitular) throws IOException {


        TipoCuenta tipoCuentaBancaria = new TipoCuenta();

        boolean constanteError;
        int existe;
        //Cliente Titular
        Clientes = ClienteTitular;

        //tipo de cuenta
        tiposCuenta = tipoCuentaBancaria.ListarDatosTipoCuenta();

        if (tiposCuenta.idTipocuenta == -1) {
            return;
        }
        System.out.println("Ingrese el identificador de la cuenta bancaria:  ");
        this.idCuentaBancaria = recibirDatosTeclado.leerValorLong();
        existe = this.validarIdCuentaBancaria(this.idCuentaBancaria);
        if (existe == 1) {
            elementoEncontrado = 1;
        } else {
            existe = 0;
            elementoEncontrado = 2;
        }

        if (elementoEncontrado == 2) {
            System.out.println("Ingrese número de cuenta bancaria:  ");
            this.numeroCuenta = recibirDatosTeclado.leerCadenaCaracteres(50);

            existe = this.validarNumCuentaBancaria(this.numeroCuenta);
            if (existe == 1) {
                elementoEncontrado = 1;
            } else {
                existe = 0;
                elementoEncontrado = 3;
            }

            if (elementoEncontrado == 3) {
                do {
                    System.out.println("Ingrese la fecha de creación de la cuenta bancaria (dd/mm/aaaa):  ");
                    this.fechaApertura = recibirDatosTeclado.leerCadenaCaracteres(10);

                    if (this.validarFecha(fechaApertura) == true) {
                        CuentaBancarias.add(this);
                        elementoEncontrado = 4;//creada la cuenta
                        System.out.println("\033[34m     Cuenta Bancaria creada con éxito  \n");
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

    // Valida si el parámetro es una fecha con el formato "dd/MM/yyyy"
    // return true si cumple el formato, false en caso contrario
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

    //Valida que no exista el identificador de la cuenta bancaria
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
            System.out.println("\033[31m \n No se insertó Cuenta Bancaria, identificador ya existe / Debe utilizar otro identificador \n");
            return 1;
        } else {
            return 0;
        }

    }

    //Valida que no exista el número de cuenta bancaria
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
            System.out.println("\033[31m \n No se insertó Cuenta Bancaria, número de cuenta ya existe / Debe utilizar otro número\n");
            return 1;
        } else {
            return 0;
        }
    }

    //Devuelve un objeto cuentaBancaria a partir de un número de cuenta
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
                objDevolver = CtaActual;
                break;
            }

        }
        if (posicion > -1) {
            return objDevolver;

        } else {
            CuentaBancaria objAux = new CuentaBancaria();
            objAux.idCuentaBancaria = -1;
            System.out.println("\033[31m No se encontro Cuenta Bancaria\n");
            return objAux;
        }
    }

    //listado de cuentas
    public void ListarCuenta() throws IOException {

        String entradaTecl = "";
        do {
            System.out.println("\033[34m-----------------------------------------------------------------------------------------------");
            System.out.println("\033[34m                          CUENTAS BANCARIAS                                                    ");
            System.out.println("\033[34m-----------------------------------------------------------------------------------------------");
            System.out.println("\033[34m         IDENTIFICADOR             NRO CUENTA                FECHA                 ");
            System.out.println("\033[34m-----------------------------------------------------------------------------------------------");
            for (int numCta = 0; numCta < CuentaBancarias.size(); numCta++) {
                System.out.println("        " + CuentaBancarias.get(numCta).idCuentaBancaria + "              " + CuentaBancarias.get(numCta).numeroCuenta + "                 " + CuentaBancarias.get(numCta).fechaApertura);
            }
            System.out.println("\033[34m-----------------------------------------------------------------------------------------------\n");
            System.out.println("Presione cualquier tecla para continuar.....");
            entradaTecl = recibirDatosTeclado.leerCadenaCaracteres(1);

        } while (entradaTecl == "");

    }

    //Listado de cuentas bancarias por tipos
    public void ListarCuentaporTipo() throws IOException {
        long idTipo;
        String entradaTecl = "";
        EntradaTeclado recibirDatosTeclado = new EntradaTeclado();

        tiposCuenta.ListarTipoCuenta();// se enlista los tipos de cuenta

        System.out.println("            Ingrese el tipo de cuenta a listar :");
        idTipo = recibirDatosTeclado.leerValorLong();


        Iterator listaElementos = CuentaBancarias.iterator();
                System.out.println("\033[34m-----------------------------------------------------------------------------------------------");
                System.out.println("\033[34m                          CUENTAS BANCARIAS POR TIPO                         ");
                System.out.println("\033[34m-----------------------------------------------------------------------------------------------");
                System.out.println("\033[34m       TIPO CUENTA      IDENTIFICADOR         NRO CUENTA              FECHA                    ");
                System.out.println("\033[34m-----------------------------------------------------------------------------------------------");
        while (listaElementos.hasNext()) {

            CuentaBancaria cuentaListado = (CuentaBancaria) listaElementos.next();

            if (cuentaListado.tiposCuenta.idTipocuenta == idTipo) {
               
                System.out.println("\033" + cuentaListado.tiposCuenta.descripcion + String.format("%20s", Long.toString(cuentaListado.idCuentaBancaria)) + "              " + cuentaListado.numeroCuenta + "               " + cuentaListado.fechaApertura);
                System.out.println("\033[34m-----------------------------------------------------------------------------------------------");
            }
        }
        System.out.println(" Presione cualquier tecla para continuar.....");
        entradaTecl = recibirDatosTeclado.leerCadenaCaracteres(1);
    }
}
