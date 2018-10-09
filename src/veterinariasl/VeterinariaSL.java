/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veterinariasl;

import clasesdata.ClienteData;
import clasesprincipales.Cliente;

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
        
        Cliente pepito= new Cliente("32423423", "asdasdas", "2a2312", "asd23412fw", "Bsdase 2010");
        ClienteData pepitoData= new ClienteData();
        pepitoData.guardarCliente(pepito);
    
    }
    
}
