/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import clasesdata.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MrLyoto
 */
public class VisitaTableModelResultSet extends AbstractTableModel {
    Object[][] array;
    

    public VisitaTableModelResultSet() {
        
            array = resultSetToArray();
        
    }

    private Object[][] resultSetToArray(){
        Connection con = Conexion.getConexion();
        try {

            String sql = "SELECT id_visita, m.alias, t.nombre_trat, fecha, v.precio FROM visita v JOIN mascota m on m.id_masc = v.id_masc1 join tratamiento t on t.id_tratamiento = v.id_tratamiento1 where 1";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            int columnCount = rs.getMetaData().getColumnCount();
            rs.last();
            int rowCount = rs.getRow();
            Object[][] resultArray = new Object[rowCount][columnCount];

            rs.beforeFirst();

            while (rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    resultArray[rs.getRow() - 1][i] = rs.getObject(i + 1);
                }

            }
            return resultArray;
        } catch (SQLException ex) {
            System.out.println("Error al buscar datos de visitas");
            System.out.println(ex);
            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar la conexion");
            }
        }
    }

    ;

@Override
    public int getRowCount() {
        return array.length;

    }

    @Override
    public int getColumnCount() {
        return array[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return array[rowIndex][columnIndex];
    }
    
}
