/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclasesgithub;

import java.io.IOException;
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
    private float montoOperacion;
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
        if(tipoOpe.idTipoOperacion != -1)
        { 
            System.out.println(" Ingrese el monto de la operación :  ");
            montoOperacion = recibirDatosTeclado.leerValorFloat();
            java.util.Date fecha = new Date();
            fechaOperacion = fecha;
        }
    }


    public void getListOperacionesByDate(Date fechaIni, Date fechaFin) {
    }
}
