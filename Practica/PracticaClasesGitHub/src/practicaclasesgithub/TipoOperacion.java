/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclasesgithub;

import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

/**
 * Seccion: 7 Grupo de Exposicion Windows Phone
 *
 * @author Kary Bonilla CI 15233412
 * @author Monica Batista CI 14281041
 * @author Johanna Duarte CI 15538692
 * @author Naretza Ovalles CI 17021921
 */
public class TipoOperacion {

    long idTipoOperacion;
    String descripcion;
    int tipo; // 1- Egreso, 2- Adicion
    private static Vector<TipoOperacion> tipOperacion = new Vector<TipoOperacion>();
    EntradaTeclado recibirDatosTeclado = new EntradaTeclado();

    public TipoOperacion() {
    }

    public int cantidadTipoOperaciones() {
        return tipOperacion.size();
    }

    public void addTipoOperacion() throws IOException {

        String respuesta;
        int existe;
        do {

            TipoOperacion obj = new TipoOperacion();
            System.out.println("Ingrese el identificador del tipo de operación: ");
            obj.idTipoOperacion = recibirDatosTeclado.leerValorLong();

            System.out.println("Ingrese el nombre del Tipo de operacion a crear: ");
            obj.descripcion = recibirDatosTeclado.leerCadenaCaracteres(30);

            System.out.println("Ingrese el tipo de operación a realizar en la cuenta: (1).. Adicionar saldo (2)... Restar saldo");
            obj.tipo = recibirDatosTeclado.leerValorEntero();

            existe = this.validarId(obj.idTipoOperacion);

            if (obj.tipo != 1 && obj.tipo != 2) {
                System.out.println("\n \033[31mDebe seleccionar solo los valores de la lista");
                existe = 1;
            }
            if (existe == 0) {
                tipOperacion.add(obj);
            }

            System.out.println("Desea agregar otro tipo de operacion: (S/N)");
            respuesta = recibirDatosTeclado.leerCadenaCaracteres(1);
            respuesta = respuesta.toLowerCase();

        } while (respuesta.equals("s"));
    }

    public int validarId(long idTipOper) {

        int posicion = -1;
        int contadorPosiciones = -1;
        Iterator listaElementos = tipOperacion.iterator();

        while (listaElementos.hasNext()) {

            TipoOperacion tipoOperActual = (TipoOperacion) listaElementos.next();
            contadorPosiciones += 1;

            if (tipoOperActual.idTipoOperacion == idTipOper) {
                posicion = contadorPosiciones;
                break;
            }

        }
        if (posicion > -1) {
            System.out.println("\n \033[31m No se insertó el tipo de operación, código ya existe / Debe utilizar otro identificador\n");
            return 1;
        } else {
            return 0;
        }

    }

    public TipoOperacion ListarDatosTipoOperacion() throws IOException {

        int indMenu = 0;
        int respMenu;
        if (tipOperacion.size() > 0) {
            System.out.println("Seleccione el tipo de operacion que desea realizar: ");

            for (int numCta = 0; numCta < tipOperacion.size(); numCta++) {
                indMenu++;
                System.out.println(indMenu + "...   " + tipOperacion.elementAt(numCta).descripcion);
            }
            respMenu = recibirDatosTeclado.leerValorEntero();
            return tipOperacion.get(respMenu - 1);

        } else {
            String entradaTecl;
            TipoOperacion objAux = new TipoOperacion();
            System.out.println("\n \033[31m Debe ingresar el tipo de operaciones a realizar. \n \033[31mDiríjase al menú de Maestros y registre el tipo de operación deseado\n");
            objAux.idTipoOperacion = -1;


            System.out.println(" \033Presione Enter para continuar.....");
            entradaTecl = recibirDatosTeclado.leerCadenaCaracteres(1);

            return objAux;
        }

    }

    public void ListarTipOperacion() throws IOException {


        String entradaTecl;
        String tip;
        do {
            if (tipOperacion.size() > 0) {
                System.out.println("        \033[34m-----------------------------------------------------------------------------------");
                System.out.println("                            \033[34mTIPOS DE OPERACIONES CREADAS                    ");
                System.out.println("        \033[34m-----------------------------------------------------------------------------------");
                System.out.println("         \033[34mIDENTIFICADOR     DESCRIPCION                                     TIPO        ");
                System.out.println("        \033[34m-----------------------------------------------------------------------------------");
                for (int numOp = 0; numOp < tipOperacion.size(); numOp++) {
                    if (tipOperacion.elementAt(numOp).tipo == 1) {
                        tip = "Adicionar Saldo";
                    } else {
                        tip = "Restar Saldo";
                    }
                    System.out.println(String.format("%20s", Long.toString(tipOperacion.elementAt(numOp).idTipoOperacion)) + "    " + String.format("%-35s", tipOperacion.elementAt(numOp).descripcion) + "        " + String.format("%-20s", tip));
                }


            } else {
                System.out.println("\n \033[31mDebe ingresar el tipo de operaciones que se pueden realizar. \n \033[31mDiríjase al menú de Maestros y registre los tipos de operaciones\n");
            }

            System.out.println("Presione cualquier tecla para continuar.....");
            entradaTecl = recibirDatosTeclado.leerCadenaCaracteres(1);

        } while (!"".equals(entradaTecl));
    }
}
