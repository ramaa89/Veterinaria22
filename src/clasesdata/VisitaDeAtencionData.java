/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesdata;

import clasesprincipales.VisitaDeAtencion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class VisitaDeAtencionData {

    public VisitaDeAtencionData() {
    }
    
    public ArrayList<VisitaDeAtencion> listarVisitas(){
        Connection con = Conexion.getConexion();
        String sql = "select * from visita";
        ArrayList<VisitaDeAtencion> listaDeVisitas = new ArrayList<>();
        
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {                
                VisitaDeAtencion visita = new VisitaDeAtencion();
                visita.setIdVisita(rs.getInt(1));
                visita.setIdMascota(rs.getInt(2));
                visita.setIdTratamiento(rs.getInt(3));
                visita.setFecha(rs.getDate(4));
                visita.setPrecio(rs.getDouble(5));
                
                listaDeVisitas.add(visita);
            }
            
            return listaDeVisitas;
            
        } catch (SQLException ex) {
            System.out.println("Error al devolver lista de visitas");
            System.out.println(ex);
            return null;
        }
        finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion");
                System.out.println(ex);
            }
        }
    }
}
