/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclasesgithub;

import java.io.IOException;
import java.util.*;

/**
 *
 * @author Naretza Ovalles
 */
public class TipoCuenta {

    long idTipocuenta;
    String descripcion;
    private static Vector<TipoCuenta> tipoCuenta = new Vector<TipoCuenta>();
    EntradaTeclado recibirDatosTeclado = new EntradaTeclado();

    public TipoCuenta() {
    }

    public void addTipoCuenta() throws IOException {

        String respuesta;
        int existe;
        do {

            TipoCuenta obj = new TipoCuenta();
            System.out.println("Ingrese el id del tipo de cuenta: ");
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

    //Valida que no exista el id
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
            System.out.println("\n ERROR:____**No** se insertó el tipo de cuenta, código ya existe / Debe utilizar otro identificador _______________\n");
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
            respMenu = recibirDatosTeclado.leerValorEntero();
            return tipoCuenta.get(respMenu - 1);
        } else {
            String entradaTecl = "";
            TipoCuenta objAux = new TipoCuenta();
            System.out.println("\n ERROR:____Debe ingresar el tipo de cuenta. \n Diríjase al menú de Maestros y registre el tipo de cuenta deseado\n");
            objAux.idTipocuenta = -1;

            do {

                System.out.println("Presione cualquier tecla para continuar.....");
                entradaTecl = recibirDatosTeclado.leerCadenaCaracteres(1);

            } while (entradaTecl == "");
            return objAux;
        }
    }

    //Lista todos los tipos de cuentas creados
    public void ListarTipoCuenta() throws IOException {

        String entradaTecl = "";
        do {
            System.out.println("---------------------------");
            System.out.println("  TIPOS DE CUENTAS CREADAS ");
            System.out.println("---------------------------");
            System.out.println("ID           DESCRIPCION");
            System.out.println("---------------------------");
            for (int numCta = 0; numCta < tipoCuenta.size(); numCta++) {
                System.out.println(tipoCuenta.elementAt(numCta).idTipocuenta + "    " + String.format("%-40s", tipoCuenta.elementAt(numCta).descripcion));
            }

            System.out.println("Presione cualquier tecla para continuar.....");
            entradaTecl = recibirDatosTeclado.leerCadenaCaracteres(1);

        } while (entradaTecl == "");

    }
}
