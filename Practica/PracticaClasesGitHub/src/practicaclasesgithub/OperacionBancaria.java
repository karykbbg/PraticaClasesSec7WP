/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclasesgithub;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author Monica Batista
 */
public class OperacionBancaria {

    private String claveOperacion;
    private Date fechaOperacion;
    private long idOperacion;
    private float montoOperacion;
    EntradaTeclado recibirDatosTeclado = new EntradaTeclado();
    private static ArrayList<OperacionBancaria> operacionesBancarias = new ArrayList<OperacionBancaria>();
    TipoOperacion tipOp = new TipoOperacion();
    TipoOperacion tipoOpe = new TipoOperacion();
    CuentaBancaria ctaBanc = new CuentaBancaria();
    private long incremetId;

    public OperacionBancaria() {
    }

    public OperacionBancaria(String numCuenta, long tipOp) {
    }

    public void createOperacionBancaria() throws IOException {

        String resp;
        String numCuentaTeclado;
        float saldoCta;
        CuentaBancaria ctaBancAux = new CuentaBancaria();
        do {
            OperacionBancaria obj = new OperacionBancaria();
            
            obj.tipoOpe = tipOp.ListarDatosTipoOperacion();
            
            if (obj.tipoOpe.idTipoOperacion != -1) {
                incremetId += 1;
                obj.idOperacion = incremetId;
                java.util.Date fecha = new Date();
                obj.fechaOperacion = fecha;
                System.out.println(" Indique el Número de Cuenta:  ");
                numCuentaTeclado = recibirDatosTeclado.leerCadenaCaracteres(50);
                
                obj.ctaBanc = ctaBancAux.BuscarNumCuentaBancaria(numCuentaTeclado);
                saldoCta = getSaldoCuenta(obj.ctaBanc);
                System.out.println("El saldo de la Cuenta es: " + saldoCta);

                System.out.println("clave: " + obj.ctaBanc.Clientes.ClaveOperaciones + " nombreCli:" + obj.ctaBanc.Clientes.nombreCliente + " Fecha de apertura: " + obj.ctaBanc.fechaApertura + " idCuenta: " + obj.ctaBanc.idCuentaBancaria);
                if (obj.ctaBanc.idCuentaBancaria != -1) {
                    if (validarClave("1234")) { //ctaBanc.Clientes.ClaveOperaciones
                        System.out.println(" Ingrese el monto de la operación :  ");
                        obj.montoOperacion = recibirDatosTeclado.leerValorFloat();

                        if ((obj.tipoOpe.tipo == 2 &&  saldoCta>= obj.montoOperacion) || (obj.tipoOpe.tipo == 1)) {
                            
                            operacionesBancarias.add(obj);
                        }
                        else
                        {
                            System.out.println("No Cuenta con Saldo suficiente para realizar esta operacion");
                        }
                    } else {
                        System.out.println(" Usted superó la cantidad máxima de intentos para esta operación  ");
                    }
                }
            }
            System.out.println("Desea realizar otra operación: (S/N)");
            resp = recibirDatosTeclado.leerCadenaCaracteres(1);
            resp = resp.toLowerCase();

        } while (resp.equals("s"));


    }

    public void getListOperacionesByDate(String fechaIni, String fechaFin) throws IOException {
        String formato;
        String numCuentaTeclado;

        CuentaBancaria ctaBancAux = new CuentaBancaria();
        System.out.println(" Indique el Número de Cuenta:  ");
        numCuentaTeclado = recibirDatosTeclado.leerCadenaCaracteres(50);
        ctaBanc = ctaBancAux.BuscarNumCuentaBancaria(numCuentaTeclado);

        if ((this.validarFecha(fechaIni) == true) && (this.validarFecha(fechaFin) == true)) {

            System.out.println(operacionesBancarias.size());
            Iterator listaElementos = operacionesBancarias.iterator();
            System.out.println("\033[34m---------------------------------------------------------------------------------------------------------");
            System.out.println("\033[34mId        Fecha                         Operacion                     Ingreso             Egreso         ");
            System.out.println("\033[34m---------------------------------------------------------------------------------------------------------");
            while (listaElementos.hasNext()) {
                OperacionBancaria OperListado = (OperacionBancaria) listaElementos.next();
                if (OperListado.ctaBanc.idCuentaBancaria == ctaBanc.idCuentaBancaria) {
                    if (OperListado.tipoOpe.tipo == 1) {
                        formato = "%12.2f";
                    } else {
                        formato = "%26.2f";
                    }
                    System.out.println(String.format("%-10s", OperListado.idOperacion) + "" + String.format("%-30s", OperListado.fechaOperacion) + "" + String.format("%-30s", OperListado.tipoOpe.descripcion) + "" + String.format(formato, OperListado.montoOperacion));

                } else {
                    System.out.println("lista 1" + OperListado.idOperacion + "--" + OperListado.fechaOperacion + " " + OperListado.montoOperacion);
                }
            }
            System.out.println("\033[34m---------------------------------------------------------------------------------------------------------");

        }

    }

    private boolean validarFecha(String fecha) {

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

    private boolean validarClave(String claveCli) throws IOException {

        String claveOperacion;
        boolean verifClave = false;
        //int cuentaClave = 0;


        for (int contCla = 0; contCla < 3; contCla++) {
            System.out.println(" Ingrese la clave de Operaciones Especiales :  \n Le quedan " + (3 - contCla) + "intentos");
            claveOperacion = recibirDatosTeclado.leerCadenaCaracteres(4);
            if (claveOperacion.equals(claveCli)) {
                verifClave = true;
                contCla = 3;
            }

        }
        if (verifClave = true) {
            return true;
        } else {
            return false;
        }
    }

    private float getSaldoCuenta(CuentaBancaria cuentaSaldo) throws IOException {
        float saldo = 0;

        Iterator listaElementos = operacionesBancarias.iterator();
        while (listaElementos.hasNext()) {
            OperacionBancaria OperListado = (OperacionBancaria) listaElementos.next();
            System.out.println("\nListado: "+ OperListado.ctaBanc.idCuentaBancaria + "Objeto Recibido: " + cuentaSaldo.idCuentaBancaria);
            
            
            
            if (OperListado.ctaBanc.idCuentaBancaria == cuentaSaldo.idCuentaBancaria) {
                if (OperListado.tipoOpe.tipo == 1) {
                    saldo = saldo + OperListado.montoOperacion;
                } else {
                    if (OperListado.tipoOpe.tipo == 2) {
                        saldo = saldo - OperListado.montoOperacion;
                    }
                }
            }
        }
        return saldo;

    }
}
