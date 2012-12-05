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
    private long idTipocuenta;
    private String numeroCuenta;
    EntradaTeclado recibirDatosTeclado = new EntradaTeclado();
    private ArrayList<OperacionBancaria> operacionesBancarias = new ArrayList<OperacionBancaria>();

    public OperacionBancaria() {
    }

    public OperacionBancaria(String numCuenta, long tipOp) {
    }

    public void createOperacionBancaria() throws IOException {
        System.out.println("Ingrese el id del tipo de cuenta: ");
        idTipocuenta = recibirDatosTeclado.leerValorLong();
        System.out.println("Indique el tipo de operación a realizar: ");
        numeroCuenta = recibirDatosTeclado.leerCadenaCaracteres(30);
        System.out.println("El numero de Cuenta es: " + numeroCuenta);
        java.util.Date fecha = new Date();
        System.out.println(fecha);
        System.out.println("se imprimio la fecha");
        
    }


    public void getListOperacionesByDate(Date fechaIni, Date fechaFin) {
    }
}
