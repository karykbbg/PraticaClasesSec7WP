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
    private long incremetId = 0;

    public OperacionBancaria() {
    }

    public OperacionBancaria(String numCuenta, long tipOp) {
    }

    public void createOperacionBancaria() throws IOException {

        String resp;

        do {
            OperacionBancaria obj = new OperacionBancaria();
            obj.tipoOpe = tipOp.ListarDatosTipoOperacion();
            if (obj.tipoOpe.idTipoOperacion != -1) {
                incremetId += 1;
                obj.idOperacion = incremetId;
                System.out.println(" Ingrese el monto de la operación :  ");
                obj.montoOperacion = recibirDatosTeclado.leerValorFloat();
                java.util.Date fecha = new Date();
                obj.fechaOperacion = fecha;
                operacionesBancarias.add(obj);
            }
            System.out.println("Desea realizar otra operaci{on: (S/N)");
            resp = recibirDatosTeclado.leerCadenaCaracteres(1);
            resp = resp.toLowerCase();

        } while (resp.equals("s"));


    }

    public void getListOperacionesByDate(String fechaIni, String fechaFin) throws IOException {
        String formato;
        if ((this.validarFecha(fechaIni) == true) && (this.validarFecha(fechaFin) == true)) {
            System.out.println(operacionesBancarias.size());

            Iterator listaElementos = operacionesBancarias.iterator();
            System.out.println("\033[34m---------------------------------------------------------------------------------------------------------");
            System.out.println("\033[34mId        Fecha                         Operacion                     Ingreso             Egreso         ");
            System.out.println("\033[34m---------------------------------------------------------------------------------------------------------");
            while (listaElementos.hasNext()) {

                OperacionBancaria OperListado = (OperacionBancaria) listaElementos.next();
                if (OperListado.tipoOpe.tipo == 1) {
                    formato = "%12.2f";
                } else {
                    formato = "%26.2f";
                }
                System.out.println(String.format("%-10s", OperListado.idOperacion) + "" + String.format("%-30s", OperListado.fechaOperacion) + "" + String.format("%-30s", OperListado.tipoOpe.descripcion) + "" + String.format(formato, OperListado.montoOperacion));

            }
            System.out.println("\033[34m----------------------------------------------------------------------------------------------------");

        }

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
