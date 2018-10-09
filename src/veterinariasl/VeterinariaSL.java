/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinariasl;

import clasesdata.ClienteData;
import clasesprincipales.Cliente;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class VeterinariaSL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
 
        ClienteData pepitoData= new ClienteData();
        List<Cliente> clientes = pepitoData.listarClientes();
        clientes.stream().forEach(cliente -> System.out.println(cliente.getNombre_apellido()));
    
    }
    
}
