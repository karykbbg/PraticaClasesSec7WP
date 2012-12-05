/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclasesgithub;

import java.io.BufferedReader;
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
    ArrayList operacion = new ArrayList();

    public OperacionBancaria() {
    }

    public OperacionBancaria(String numCuenta, long tipOp) {
    }

    public void createOperacionBancaria() {
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader lector = new BufferedReader(entrada);
        System.out.println("Indique la Cédula del Cliente");
        System.out.println("Indique el tipo de operación a realizar: ");
    }

    public void getListOperacionesByDate(Date fechaIni, Date fechaFin) {
    }
}
