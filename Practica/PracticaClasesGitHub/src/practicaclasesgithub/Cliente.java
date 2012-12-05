/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaclasesgithub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author unet
 */
public class Cliente {
    private long idCliente;
    private String nombreCliente;
    private ArrayList<CuentaBancaria> misCuentasBancarias = new ArrayList<CuentaBancaria>();   
    private static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    public void Cliente()
    {
        
    }        
    
    public void createCliente() throws IOException
    {
      EntradaTeclado recibirDatosTeclado =  new EntradaTeclado();
      System.out.println("Ingrese el identificador Unico del Cliente (debe ser un valor numérico) :\n" );
      idCliente=recibirDatosTeclado.leerValorLong();      
      System.out.println("Ingrese el nombre del Cliente:\n" );
      nombreCliente=recibirDatosTeclado.leerCadenaCaracteres(100);           
      String opcionCrearCuenta;
      do
      {            
            System.out.println("-> \n" );
            System.out.println("Ingrese los datos de la cuenta bancaria :\n" );
            CuentaBancaria CuentaBancariaInicial = new  CuentaBancaria();
            CuentaBancariaInicial.createCuentaBancaria(); 
            
            misCuentasBancarias.add(CuentaBancariaInicial);
            
            System.out.println("Desea agregar cuenta bancaria al Cliente ingrese (S) sí :\n" ); 
               
            opcionCrearCuenta =  recibirDatosTeclado.leerCadenaCaracteres(1); 
            
      }while( "S".equals(opcionCrearCuenta));
      
      listaClientes.add(this);
      
    }
    
    public void listadoClientes()
    {
          Iterator lista = listaClientes.iterator();
           if (listaClientes.size() > 0) 
           {
                while (lista.hasNext()) {
                    
                  Cliente actualCliente = (Cliente) lista.next(); 
                  System.out.println("_________________________________________________________\n");
                  System.out.println("Id Cliente: " + actualCliente.idCliente + "\n");
                  System.out.println("Nombre del Cliente: " + actualCliente.idCliente + "\n");                  
                  System.out.println("----------------------------------------------------------\n");
                  //aqui incluir lista de cuentas
                  Iterator listaCuentas = actualCliente.misCuentasBancarias.iterator();
                  if(actualCliente.misCuentasBancarias.size() > 0)
                  {
                        while (listaCuentas.hasNext()) {
                            CuentaBancaria actCuentaCliente = (CuentaBancaria) listaCuentas.next();
                            System.out.println("Id de Cuenta : " + actCuentaCliente.getCuentaBancariaByID() + "\n");
                        }
                  }
                  System.out.println("_________________________________________________________\n");
                  
                }
           }
    }
}
