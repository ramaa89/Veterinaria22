/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinariasl;

import clasesdata.ClienteData;
import clasesprincipales.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class VeterinariaSL {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here

        
        //Guardando Cliente en BD
         Cliente clientePrueba= new Cliente("34587657","Pepito Prueba", "266415648", "Amigo alterno", "Colon 654");
         
         ClienteData dataPrueba=new ClienteData();
         
         dataPrueba.guardarCliente(clientePrueba);
         
         
         //Buscar ese cliente
         
        /* Cliente resultado=dataPrueba.buscarCliente("34587657");
         
         System.out.println(resultado.getDni()+" "+ resultado.getNombre_apellido()+ " "+ resultado.getTel()+ " "+ resultado.getPersona_alt()+" "+ resultado.getDireccion());
         
        */
         
         
        //Borrar ese cliente
          /*
          ClienteData dataPrueba=new ClienteData();
          dataPrueba.borrarCliente("34587657");
        */
          
          
          //Obtener lista de clientes
          /*
          List<Cliente> lista= dataPrueba.listarClientes();
          
          lista.stream().forEach(Cliente -> System.out.println(Cliente.getDni()+" "+ Cliente.getNombre_apellido()+ " "+ Cliente.getTel()+ " "+Cliente.getPersona_alt()+" "+ Cliente.getDireccion()));
         */
              
         
    
    }
    
}
