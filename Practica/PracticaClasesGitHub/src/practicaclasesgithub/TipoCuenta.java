/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclasesgithub;

import java.io.IOException;
import java.util.*;

/**
 *
 * Seccion: 7 Grupo de Exposicion Windows Phone
 *
 * @author Kary Bonilla CI 15233412
 * @author Monica Batista CI 14281041
 * @author Johanna Duarte CI 15538692
 * @author Naretza Ovalles CI 17021921
 */
public class TipoCuenta {

    long idTipocuenta;
    String descripcion;
    private static Vector<TipoCuenta> tipoCuenta = new Vector<TipoCuenta>();
    EntradaTeclado recibirDatosTeclado = new EntradaTeclado();

    public TipoCuenta() {
    }

    public long getTipoCuentaByID() {
        return idTipocuenta;
    }

    public String getCuentaBancariaByDesc() {
        return descripcion;
    }

    public int totalTiposCuentas() {
        return tipoCuenta.size();
    }

    public void addTipoCuenta() throws IOException {

        String respuesta;
        int existe;
        do {

            TipoCuenta obj = new TipoCuenta();
            System.out.println("Ingrese el identificador del tipo de cuenta: ");
            obj.idTipocuenta = recibirDatosTeclado.leerValorLong();

            System.out.println("Ingrese el nombre del Tipo de cuenta a crear: ");
            obj.descripcion = recibirDatosTeclado.leerCadenaCaracteres(30);

            existe = this.validarId(obj.idTipocuenta);
            if (existe == 0) {
                tipoCuenta.add(obj);
            }

            System.out.println("Desea agregar otro tipo de cuenta: (S/N)");
            respuesta = recibirDatosTeclado.leerCadenaCaracteres(1);
            respuesta = respuesta.toLowerCase();

        } while (respuesta.equals("s"));
    }

    //Valida que no exista el identificador de tipo de cuenta
    public int validarId(long idTipoCuenta) {

        int posicion = -1;
        int contadorPosiciones = -1;
        Iterator listaElementos = tipoCuenta.iterator();

        while (listaElementos.hasNext()) {

            TipoCuenta tipoCtaActual = (TipoCuenta) listaElementos.next();
            contadorPosiciones += 1;

            if (tipoCtaActual.idTipocuenta == idTipoCuenta) {
                posicion = contadorPosiciones;
                break;
            }
        }
        if (posicion > -1) {
            System.out.println("\n \033[31m No se insertó el tipo de cuenta, código ya existe / Debe utilizar otro identificador\n");
            return 1;
        } else {
            return 0;
        }

    }

    //Lista los tipos de cuentas creados para que el usuario seleccione 
    //al momento de crear la cuenta
    public TipoCuenta ListarDatosTipoCuenta() throws IOException {

        int indMenu = 0;
        int respMenu;
        if (tipoCuenta.size() > 0) {
            System.out.println("Seleccione el tipo de cuenta que desea crear: ");

            for (int numCta = 0; numCta < tipoCuenta.size(); numCta++) {
                indMenu++;
                System.out.println(indMenu + "...   " + tipoCuenta.elementAt(numCta).descripcion);
            }
            do {
                respMenu = recibirDatosTeclado.leerValorEntero();
                if (respMenu <= 0 || respMenu > tipoCuenta.size()) {
                    System.out.println("Opción no válida por favor seleccione nuevamente:");
                }
            } while (respMenu <= 0 || respMenu > tipoCuenta.size());
            return tipoCuenta.get(respMenu - 1);
        } else {
            String entradaTecl;
            TipoCuenta objAux = new TipoCuenta();
            System.out.println("\n \033[31mDebe ingresar los tipos de cuenta que se pueden realizar. \n \033[31mDiríjase al menú de Maestros y registre los tipos de cuentas deseadas\n");
            objAux.idTipocuenta = -1;

            do {

                System.out.println("Presione Enter para continuar.....");
                entradaTecl = recibirDatosTeclado.leerCadenaCaracteres(1);

            } while (" ".equals(entradaTecl));
            return objAux;
        }
    }

    //Lista todos los tipos de cuentas creados
    public void ListarTipoCuenta() throws IOException {

        String entradaTecl;
        do {
            if (tipoCuenta.size() > 0) {
                System.out.println("        \033[34m----------------------------------------------------------------    ");
                System.out.println("                           \033[34mTIPOS DE CUENTAS CREADAS                         ");
                System.out.println("        \033[34m----------------------------------------------------------------    ");
                System.out.println("           \033[34mIDENTIFICADOR                  DESCRIPCION                                 ");
                System.out.println("        \033[34m----------------------------------------------------------------    ");
                for (int numCta = 0; numCta < tipoCuenta.size(); numCta++) {
                    System.out.println("        \033" + String.format("%-20s", Long.toString(tipoCuenta.elementAt(numCta).idTipocuenta)) + "                   " + String.format("%-50s", tipoCuenta.elementAt(numCta).descripcion));
                }
            } else {
                System.out.println("\n \033[31mDebe ingresar los tipos de cuenta que se pueden realizar. \n \033[31mDiríjase al menú de Maestros y registre los tipos de cuentas deseadas\n");
            }
            System.out.println("Presione  Enter para continuar.....");
            entradaTecl = recibirDatosTeclado.leerCadenaCaracteres(1);

        } while (!"".equals(entradaTecl));

    }
}
