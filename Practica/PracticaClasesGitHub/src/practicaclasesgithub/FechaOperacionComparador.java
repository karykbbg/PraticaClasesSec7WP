/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclasesgithub;

import java.util.Comparator;

/**
 * Seccion: 7 Grupo de Exposicion Windows Phone
 *
 * @author Kary Bonilla CI 15233412
 * @author Monica Batista CI 14281041
 * @author Johanna Duarte CI 15538692
 * @author Naretza Ovalles CI 17021921
 */
public class FechaOperacionComparador implements Comparator {

    public int compare(Object o1, Object o2) {
        OperacionBancaria operacion1 = (OperacionBancaria) o1;
        OperacionBancaria operacion2 = (OperacionBancaria) o2;
        return operacion1.fechaOperacion.compareTo(operacion2.fechaOperacion);

    }
}
