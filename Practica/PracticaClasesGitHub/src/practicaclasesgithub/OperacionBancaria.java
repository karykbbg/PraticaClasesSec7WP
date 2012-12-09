/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclasesgithub;

import java.io.IOException;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * Seccion: 7 Grupo de Exposicion Windows Phone
 *
 * @author Kary Bonilla CI 15233412
 * @author Monica Batista CI 14281041
 * @author Johanna Duarte CI 15538692
 * @author Naretza Ovalles CI 17021921
 */
public class OperacionBancaria {

    private String claveOperacion; // Se valida con clave de operaciones que ingresa el cliente al registrarse
    Date fechaOperacion; // Fecha de la transaccion
    private long idOperacion;
    private float montoOperacion;
    EntradaTeclado recibirDatosTeclado = new EntradaTeclado();
    private static ArrayList<OperacionBancaria> operacionesBancarias = new ArrayList<OperacionBancaria>();
    TipoOperacion tipOp = new TipoOperacion(); // Objeto auxiliar para llamada de datos
    TipoOperacion tipoOpe = new TipoOperacion(); // Objeto definitivo asignado a la transaccion
    CuentaBancaria ctaBanc = new CuentaBancaria();
    private long incremetId; // Numero autoincrementable para manejar el id de operacion

    public OperacionBancaria() {
    }

    public void createOperacionBancaria() throws IOException {

        String resp;
        String numCuentaTeclado;
        float saldoCta;
        boolean constanteError;
        CuentaBancaria ctaBancAux = new CuentaBancaria();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        do {
            OperacionBancaria obj = new OperacionBancaria();

            obj.tipoOpe = tipOp.ListarDatosTipoOperacion();

            if (obj.tipoOpe.idTipoOperacion != -1) {
                incremetId += 1;
                obj.idOperacion = incremetId;
                System.out.println("Indique el Número de Cuenta:  ");
                numCuentaTeclado = recibirDatosTeclado.leerCadenaCaracteres(50);
                obj.ctaBanc = ctaBancAux.BuscarNumCuentaBancaria(numCuentaTeclado);
                saldoCta = getSaldoCuenta(obj.ctaBanc);
                if (obj.ctaBanc.idCuentaBancaria != -1) {
                    if (validarClave(obj.ctaBanc.Clientes.ClaveOperaciones) == true) {

                        System.out.println("Fecha de operación ");
                        obj.fechaOperacion = sdf.parse(leerFecha(), new ParsePosition(0));

                        System.out.println("Ingrese el monto de la operación :  ");
                        obj.montoOperacion = recibirDatosTeclado.leerValorFloat();

                        if ((obj.tipoOpe.tipo == 2 && saldoCta >= obj.montoOperacion) || (obj.tipoOpe.tipo == 1)) {
                            operacionesBancarias.add(obj);
                            System.out.println("\033[34m     Operación realizada con éxito");
                            System.out.println("\033[34m     Concepto: " + obj.tipoOpe.descripcion);
                            System.out.println("\033[34m     Fecha :   " + obj.fechaOperacion);
                            System.out.println("\033[34m     Cuenta N°:" + obj.ctaBanc.numeroCuenta);
                            System.out.println("\033[34m     Titular:  " + obj.ctaBanc.Clientes.nombreCliente);
                            System.out.println("\033[34m     Monto:    " + obj.montoOperacion);

                        } else {
                            System.out.println("\n      \033[31mERROR:____No Cuenta con Saldo suficiente para realizar esta operacion");
                        }
                    } else {
                        System.out.println("\n      \033[31mERROR:____Usted superó la cantidad máxima de intentos para esta operación  ");
                    }
                }
            }
            System.out.println("Si Desea realizar otra operación presione (S):");
            resp = recibirDatosTeclado.leerCadenaCaracteres(1);
            resp = resp.toLowerCase();

        } while (resp.equals("s"));


    }

    public void getListOperacionesByDate(String fechaIni, String fechaFin) throws IOException {
        String formato;
        String numCuentaTeclado;
        CuentaBancaria ctaBancAux = new CuentaBancaria();
        OperacionBancaria obj = new OperacionBancaria();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Indique el Número de Cuenta:  ");
        numCuentaTeclado = recibirDatosTeclado.leerCadenaCaracteres(50);
        obj.ctaBanc = ctaBancAux.BuscarNumCuentaBancaria(numCuentaTeclado);
        // El método parse devuelve null si no se ha podido parsear el string en  según el formato indicado. 
        Date fecha1 = sdf.parse(fechaIni, new ParsePosition(0));
        Date fecha2 = sdf.parse(fechaFin, new ParsePosition(0));
        if (obj.ctaBanc.idCuentaBancaria != -1) {

            if (operacionesBancarias.size() > 0) {
                Collections.sort(operacionesBancarias, new FechaOperacionComparador());
                Iterator listaElementos = operacionesBancarias.iterator();
                System.out.println("\033[34m--------------------------------------------------------------------------------------------");
                System.out.println("\033[34m   OPERACIONES BANCARIAS DE LA CUENTA No. " + obj.ctaBanc.numeroCuenta + " CLIENTE: " + obj.ctaBanc.Clientes.nombreCliente);
                System.out.println("\033[34m--------------------------------------------------------------------------------------------");
                System.out.println("\033[34mId        Fecha       Operacion                           Ingreso              Egreso       ");
                System.out.println("\033[34m--------------------------------------------------------------------------------------------");
                while (listaElementos.hasNext()) {
                    OperacionBancaria OperListado = (OperacionBancaria) listaElementos.next();
                    if (OperListado.ctaBanc.idCuentaBancaria == obj.ctaBanc.idCuentaBancaria) {

                        //Date fecha3 = sdf.parse(OperListado.fechaOperacion, new ParsePosition(0));
                        // Comparacion de fechas
                        if ((OperListado.fechaOperacion.before(fecha2) || OperListado.fechaOperacion.equals(fecha2)) && (fecha1.before(OperListado.fechaOperacion) || fecha1.equals(OperListado.fechaOperacion))) {
                            if (OperListado.tipoOpe.tipo == 1) {
                                formato = "%18.2f";
                            } else {
                                formato = "%38.2f";
                            }
                            System.out.println(String.format("%-10s", OperListado.idOperacion) + "" + String.format("%-10s", sdf.format(OperListado.fechaOperacion)) + "" + String.format("%-30s", OperListado.tipoOpe.descripcion) + "" + String.format(formato, OperListado.montoOperacion));
                        }
                    }
                }
                System.out.println("\033[34m--------------------------------------------------------------------------------------------");
            } else {
                System.out.println("\n      \033[31mERROR:____NO SE HA REGISTRADO NINGUNA OPERACION EN EL SISTEMA\n");
            }
        }
    }

    public String leerFecha() throws IOException {
        String fecha;
        boolean constanteError;

        do {
            System.out.print(" - Ingrese la fecha (dd/mm/aaaa):  ");
            fecha = recibirDatosTeclado.leerCadenaCaracteres(10);
            if (validarFecha(fecha) == true) {
                constanteError = false;
            } else {
                constanteError = true;
            }
        } while (constanteError == true);
        return fecha;

    }

    private boolean validarFecha(String fecha) {

        if (fecha == null) {
            System.out.println("\n      \033[31mERROR:____Debe indicar una fecha ");
            return false;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (fecha.trim().length() != dateFormat.toPattern().length()) {
            System.out.println("\n      \033[31mERROR:____La fecha ingresada no coincide con el formato ");
            return false;
        }

        dateFormat.setLenient(false);

        try {
            dateFormat.parse(fecha.trim());
        } catch (ParseException pe) {
            System.out.println("\n      \033[31mERROR:____No se pudo leer la fecha ");
            return false;
        }
        return true;
    }

    private boolean validarClave(String claveCli) throws IOException {

        String claveOperacion;
        boolean verifClave = false;

        for (int contCla = 0; contCla < 3; contCla++) {
            System.out.println("Ingrese la clave de Operaciones Especiales :  \n Le quedan " + (3 - contCla) + " intentos");
            claveOperacion = recibirDatosTeclado.leerCadenaCaracteres(4);
            if (claveOperacion.equals(claveCli)) {
                verifClave = true;
                contCla = 3;
            }

        }
        if (verifClave == true) {
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
