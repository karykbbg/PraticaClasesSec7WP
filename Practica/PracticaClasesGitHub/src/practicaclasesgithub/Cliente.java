/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclasesgithub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joha
 */
public class Cliente {

    public long idCliente;
    public String nombreCliente;
    public String ClaveOperaciones;
    private ArrayList<CuentaBancaria> misCuentasBancarias = new ArrayList<CuentaBancaria>();
    private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    public void Cliente() {
    }

    public void createCliente() throws IOException {
        EntradaTeclado recibirDatosTeclado = new EntradaTeclado();
        int consultaExistencia;

        TipoCuenta tiposCuenta = new TipoCuenta();

        if (tiposCuenta.totalTiposCuentas() <= 0) {
            System.out.println("        \033[31m NO SE PUEDE REGISTRAR EL CLIENTE POR FAVOR, DEBE CONFIGURAR LOS TIPOS DE CUENTAS");
            return;
        }
        do {

            System.out.println("Ingrese el identificador único del cliente (debe ser un valor numérico) :");
            idCliente = recibirDatosTeclado.leerValorLong();

            consultaExistencia = this.buscarPosicionClientebyId(idCliente);
            if (consultaExistencia >= 0) {
                System.out.println("El identificador ya esta siendo utilizado, por favor ingrese otro :");
            }
        } while (consultaExistencia > 0);

        System.out.print("Ingrese el nombre del cliente:\n");
        nombreCliente = recibirDatosTeclado.leerCadenaCaracteres(100);

        System.out.print("Ingresar clave especial de operaciones:\n");
        ClaveOperaciones = recibirDatosTeclado.leerCadenaCaracteres(100);

        String opcionCrearCuenta;


        System.out.println("        \033[34m A continuación debe ingresar los datos de la cuenta bancaria asociada al nuevo cliente");
        do {

            CuentaBancaria CuentaBancariaInicial = new CuentaBancaria();
            CuentaBancariaInicial.createCuentaBancaria(this);

            misCuentasBancarias.add(CuentaBancariaInicial);
            System.out.println("Desea agregar otra cuenta bancaria asociada al cliente   (S)sí :\n");

            opcionCrearCuenta = recibirDatosTeclado.leerCadenaCaracteres(1);

        } while ("S".equals(opcionCrearCuenta) || "s".equals(opcionCrearCuenta));

        if (misCuentasBancarias.size() > 0) {
            listaClientes.add(this);
            System.out.println("        \033[31m Cliente agregado con éxito");
        } else {
            System.out.println("        \033[34m NO SE PUEDE REGISTRAR EL CLIENTE POR FAVOR, SIGA LAS INDICACIONES ANTERIORES");
        }

    }

    public int getCantidadClientes() {
        return listaClientes.size();
    }

    public Cliente buscarCliente() {
        EntradaTeclado recibirDatosTeclado = new EntradaTeclado();
        boolean validarIngreso;
        String respuestaIntentos;
        Cliente clienteEncontrado = null;
        long idClienteConsulta = 0;
        do {
            respuestaIntentos = "N";
            validarIngreso = false;
            System.out.println("Ingrese el identificador del Cliente:");
            try {
                idClienteConsulta = recibirDatosTeclado.leerValorLong();
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            int posicionLista;
            posicionLista = this.buscarPosicionClientebyId(idClienteConsulta);
            clienteEncontrado = listaClientes.get(posicionLista);
            if (posicionLista >= 0) {
                System.out.println("Cliente Encontrado Datos: Identificador.- " + clienteEncontrado.idCliente + " Nombre Cliente.- " + clienteEncontrado.nombreCliente);
            } else {
                System.out.println("        \033[34mCLIENTE NO ENCONTRADO");
                validarIngreso = true;
                System.out.println("        \033 Desea intentar nuevamente ? (S) ");

                try {
                    respuestaIntentos = recibirDatosTeclado.leerCadenaCaracteres(1);
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } while (validarIngreso == true && (("S").equals(respuestaIntentos) || ("s").equals(respuestaIntentos)));


        return clienteEncontrado;
    }

    //Antes de llamar al método agregarCuentaBancaria el objeto debe estar creado o asignado
    public void agregarCuentaBancaria(CuentaBancaria nuevaCuenta) {
        Cliente clienteEncontrado;
        int posicionLista;
        posicionLista = this.buscarPosicionClientebyId(idCliente);
        if (posicionLista >= 0) {
            clienteEncontrado = listaClientes.get(posicionLista);
            clienteEncontrado.misCuentasBancarias.add(nuevaCuenta);
            listaClientes.set(posicionLista, clienteEncontrado);
            System.out.println("Cuenta Agregada");
        } else {
            System.out.println("        \033[34mError no se encontro el cliente");
        }


    }

    public void listadoClientes() {
        Iterator lista = listaClientes.iterator();
        if (listaClientes.size() > 0) {
            System.out.println("        \033[34m----------------------------------------------------------------    ");
            System.out.println("                           \033[34mCLIENTES                     ");
            System.out.println("        \033[34m----------------------------------------------------------------    ");
            System.out.println("         \033[34m ID                                NOMBRE        ");
            System.out.println("        \033[34m----------------------------------------------------------------    ");

            while (lista.hasNext()) {

                Cliente actualCliente = (Cliente) lista.next();

                System.out.println(String.format("%20s", Long.toString(actualCliente.idCliente)) + "                 " + String.format("%-55s", actualCliente.nombreCliente));


            }
        } else {
            System.out.println("        \033[31mNO HAY CLIENTES POR LISTAR, PRESIONE ENTER PARA CONTINUAR\n");
        }
    }

    public int buscarPosicionClientebyId(long idClienteConsulta) {
        int resultadoBusqueda;
        int contadorPosiciones = -1;
        resultadoBusqueda = -1;
        Iterator lista = listaClientes.iterator();
        if (listaClientes.size() > 0) {
            while (lista.hasNext()) {
                Cliente actualCliente = (Cliente) lista.next();
                contadorPosiciones += 1;
                if (actualCliente.idCliente == idClienteConsulta) {
                    resultadoBusqueda = contadorPosiciones;
                    break;
                }
            }
        }
        return resultadoBusqueda;
    }

    public void showCuentasBancarias(Cliente clienteConsulta) {
        Iterator listaCuentas = clienteConsulta.misCuentasBancarias.iterator();
        if (clienteConsulta.misCuentasBancarias.size() > 0) {
            while (listaCuentas.hasNext()) {
                CuentaBancaria actualCuentaCliente = (CuentaBancaria) listaCuentas.next();


                System.out.println("        \033" + String.format("%10s", actualCuentaCliente.fechaApertura) + "               " + String.format("%-20s", Long.toString(actualCuentaCliente.idCuentaBancaria)) + "  " + String.format("%-50s", actualCuentaCliente.numeroCuenta) + "   " + String.format("%-30s", actualCuentaCliente.tiposCuenta.descripcion));

            }
        }
        System.out.println(" \n Presione Enter para continuar ");
    }

    public void consultar() throws IOException {
        EntradaTeclado recibirDatosTeclado = new EntradaTeclado();
        System.out.println("Ingrese el identificador del cliente  :");
        idCliente = recibirDatosTeclado.leerValorLong();
        int posicionLista;
        posicionLista = this.buscarPosicionClientebyId(idCliente);
        if (posicionLista >= 0) {
            Cliente clienteEncontrado = listaClientes.get(posicionLista);
            System.out.println("        \033[34m-------------------------------------------------------------------------------------------------------------");
            System.out.println("        \033[34m Id del cliente : " + clienteEncontrado.idCliente + " Nombre del cliente " + clienteEncontrado.nombreCliente);
            System.out.println("        \033[34m-------------------------------------------------------------------------------------------------------------");
            System.out.println("                           \033[34mCUENTAS DEL CLIENTE                    ");
            System.out.println("        \033[34m-------------------------------------------------------------------------------------------------------------");
            System.out.println("         \033[34m FECHA APERTURA      ID DE LA CUENTA             Nº DE CUENTA                              TIPO DE CUENTA   ");
            System.out.println("        \033[34m-------------------------------------------------------------------------------------------------------------");

            this.showCuentasBancarias(clienteEncontrado);
        } else {
            System.out.println("        \033[31mCliente no encontrado");
        }


    }
}
