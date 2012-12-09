/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclasesgithub;

import java.util.Comparator;

/**
 *
 * @author Mónica
 */
public class FechaOperacionComparador implements Comparator {

    public int compare(Object o1, Object o2) {
        OperacionBancaria operacion1 = (OperacionBancaria) o1;
        OperacionBancaria operacion2 = (OperacionBancaria) o2;
        return operacion1.fechaOperacion.compareTo(operacion2.fechaOperacion);

    }
}
