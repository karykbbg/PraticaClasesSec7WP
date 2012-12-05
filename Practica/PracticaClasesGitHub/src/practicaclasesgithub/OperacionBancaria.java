/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclasesgithub;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Monica Batista
 */
public class OperacionBancaria {

    private String claveOperacion;
    private Date fechaOperacion;
    private long idOperacion;
    private long montoOperacion;
    private long idTipoOperacion;
    private String numeroCuenta;
    EntradaTeclado recibirDatosTeclado = new EntradaTeclado();
    private ArrayList<OperacionBancaria> operacionesBancarias = new ArrayList<OperacionBancaria>();
    TipoOperacion tipOp = new TipoOperacion(); 
    TipoOperacion tipoOpe = new  TipoOperacion(); 

    public OperacionBancaria() {
    }

    public OperacionBancaria(String numCuenta, long tipOp) {
    }

    public void createOperacionBancaria() throws IOException {
        tipoOpe = tipOp.ListarDatosTipoOperacion();
        System.out.println(tipoOpe.idTipoOperacion);
        /*idTipoOperacion = tipoOpe.idTipoOperacion;
        System.out.println(" Ingrese numero de cuenta :  ");
        numeroCuenta = recibirDatosTeclado.leerCadenaCaracteres(30);
        java.util.Date fecha = new Date();
        fechaOperacion = fecha;
        System.out.println(" Ingrese el id de la operacion:  ");
        numeroCuenta = recibirDatosTeclado.leerCadenaCaracteres(30);*/
    }


    public void getListOperacionesByDate(Date fechaIni, Date fechaFin) {
    }
}
