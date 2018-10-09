/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesdata;

import clasesprincipales.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ClienteData {

    public Connection conn;

    public ClienteData() {
        conn = Conexion.getConexion();
    }

    public void guardarCliente(Cliente cliente) throws SQLException{
        String sql = "INSERT INTO cliente VALUES (?, ?, ?, ?, ?);";
        try {
            try (PreparedStatement stm = conn.prepareStatement(sql)) {
                stm.setString(1, cliente.getDni());
                stm.setString(2, cliente.getNombre_apellido());
                stm.setString(3, cliente.getTel());
                stm.setString(4, cliente.getPersona_alt());
                stm.setString(5, cliente.getDireccion());

                if (stm.executeUpdate() == 0) {
                    System.out.println("Error al insertar Cliente: " + cliente.getNombre_apellido());
                } else {
                    System.out.println("Se agrego el Cliente: " + cliente.getNombre_apellido());
                }
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(ClienteData.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            conn.close();
        }
    }
    
    public List<Cliente> listarClientes() throws SQLException{
        List<Cliente> clientes = new ArrayList<>();
        
        try{
            String sql = "SELECT * FROM cliente;";
            
            try (PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
                
                Cliente client;
                while(rs.next()){
                    client = new Cliente();
                    client.setDni(rs.getString("dni_cliente"));
                    client.setNombre_apellido(rs.getString("nombre_apellido"));
                    client.setTel(rs.getString("telefono"));
                    client.setPersona_alt(rs.getString("persona_alternativa"));
                    client.setDireccion(rs.getString("direccion"));
                    clientes.add(client);
                }
            }
                      
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            conn.close();
        }
        return clientes;
        
    }

}