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
        
        public ClienteData(){
           
            conn= Conexion.getConexion();
        }
            
        
        public void guardarCliente(Cliente cliente){
           
            String sql= "INSERT INTO cliente VALUES (?, ?, ?, ?, ?);";
            
            try {
                PreparedStatement stm= conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                
                stm.setInt(1, cliente.getDni());
                stm.setString(2, cliente.getNombre_apellido());
                stm.setInt(3, cliente.getTel());
                stm.setString(4, cliente.getPersona_alt());
                stm.setString(5, cliente.getDireccion());
                
                stm.executeUpdate();
                
                ResultSet rs=stm.getGeneratedKeys();
                
                System.out.println("Se Agrego un alumno");
                
                stm.close();
                
                
                /*     String sql = "INSERT INTO alumno (nombre, fecNac, activo) VALUES ( ? , ? , ? );";
                
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, alumno.getNombre());
                statement.setDate(2, Date.valueOf(alumno.getFecNac()));
                statement.setBoolean(3, alumno.getActivo());
                
                statement.executeUpdate();
                
                 ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                alumno.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un alumno");
            }
            statement.close();
                */
            } catch (SQLException ex) {
                Logger.getLogger(ClienteData.class.getName()).log(Level.SEVERE, null, ex);
            }
}

}
