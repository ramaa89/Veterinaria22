/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesdata;

import clasesprincipales.Cliente;
import java.sql.*;
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

    public void guardarCliente(Cliente cliente) {
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
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
