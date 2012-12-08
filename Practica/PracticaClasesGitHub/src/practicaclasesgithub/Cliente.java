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
 * @author unet
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

        do {

            System.out.println("Ingrese el identificador Unico del Cliente (debe ser un valor numérico) :");
            idCliente = recibirDatosTeclado.leerValorLong();

            consultaExistencia = this.buscarPosicionClientebyId(idCliente);
            if (consultaExistencia >= 0) {
                System.out.println("El identificador ya esta siendo utilizado, por favor ingrese otro -> :");
            }
        } while (consultaExistencia > 0);

        System.out.println("Ingrese el nombre del Cliente:\n");
        nombreCliente = recibirDatosTeclado.leerCadenaCaracteres(100);
        String opcionCrearCuenta;
        do {
            System.out.println("-> \n");
            System.out.println("Ingrese los datos de la cuenta bancaria :\n");
            CuentaBancaria CuentaBancariaInicial = new CuentaBancaria();
            CuentaBancariaInicial.createCuentaBancaria(this);

            misCuentasBancarias.add(CuentaBancariaInicial);

            System.out.println("Desea agregar cuenta bancaria al Cliente ingrese (S) sí :\n");

            opcionCrearCuenta = recibirDatosTeclado.leerCadenaCaracteres(1);

        } while ("S".equals(opcionCrearCuenta));

        listaClientes.add(this);

    }

    public int getCantidadClientes() {
        return listaClientes.size();
    }

    public Cliente buscarCliente() {
        EntradaTeclado recibirDatosTeclado = new EntradaTeclado();
        boolean validarIngreso;
        String respuestaIntentos;
        Cliente clienteEncontrado = null;
        long idClienteConsulta=0;
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
                System.out.println("Cliente no encontrado");
                validarIngreso = true;
                System.out.println("Desea intentar nuevamente ? (S) ");

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
         System.out.println("Ubicando posicion");
        if (posicionLista >= 0) {
            clienteEncontrado = listaClientes.get(posicionLista);
            clienteEncontrado.misCuentasBancarias.add(nuevaCuenta);
            listaClientes.set(posicionLista, clienteEncontrado);
            System.out.println("Cuenta Agregada");
        } else {
            System.out.println("Error no se encontro el cliente");
        }


    }

    public void listadoClientes() {
        Iterator lista = listaClientes.iterator();
        if (listaClientes.size() > 0) {
            while (lista.hasNext()) {

                Cliente actualCliente = (Cliente) lista.next();
                System.out.println("_________________________________________________________\n");
                System.out.println("Id Cliente: " + actualCliente.idCliente + "\n");
                System.out.println("Nombre del Cliente: " + actualCliente.nombreCliente + "\n");
                System.out.println("----------------------------------------------------------\n");
                //aqui incluir lista de cuentas

                System.out.println("_________________________________________________________\n");

            }
        } else {
            System.out.println("_____________NO HAY CLIENTES POR LISTAR__________________\n");
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
                CuentaBancaria actCuentaCliente = (CuentaBancaria) listaCuentas.next();
                try {
                    actCuentaCliente.ListarCuentaActual();
                } catch (IOException ex) {
                    Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                //  System.out.println("Id de Cuenta : " + actCuentaCliente.getCuentaBancariaByID() + "\n");
            }
        }
    }

    public void consultar() throws IOException {
        EntradaTeclado recibirDatosTeclado = new EntradaTeclado();
        System.out.println("Ingrese el identificador del Cliente (debe ser un valor numérico) :");
        idCliente = recibirDatosTeclado.leerValorLong();
        int posicionLista;
        posicionLista = this.buscarPosicionClientebyId(idCliente);
        if (posicionLista >= 0) {
            Cliente clienteEncontrado = listaClientes.get(posicionLista);
            System.out.println("Id Cliente : " + clienteEncontrado.idCliente + "Nombre Cliente " + clienteEncontrado.nombreCliente);
            this.showCuentasBancarias(clienteEncontrado);
        } else {
            System.out.println("Cliente no encontrado");
        }


    }
}
