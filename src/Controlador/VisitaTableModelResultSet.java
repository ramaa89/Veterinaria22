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
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MrLyoto
 */
public class VisitaTableModelResultSet extends AbstractTableModel {
    boolean status;
    Object[][] array;
    String[] columnNames;
    String parametroDeBusqueda;

    public VisitaTableModelResultSet(String buscar) {
        parametroDeBusqueda = buscar;
        array = resultSetToArray();

    }

    private Object[][] resultSetToArray() {
        Connection con = Conexion.getConexion();
        try {

            String sql = "SELECT id_visita, m.alias, c.nombre_apellido, t.nombre_trat, fecha, v.precio FROM visita v JOIN mascota m on m.id_masc = v.id_masc1 join tratamiento t on t.id_tratamiento = v.id_tratamiento1 JOIN cliente c on m.dni_cliente1 = c.dni_cliente where " + parametroDeBusqueda;                                  
            PreparedStatement stm = con.prepareStatement(sql);           
            System.out.println(stm.toString());
            ResultSet rs = stm.executeQuery();
            int columnCount = rs.getMetaData().getColumnCount();
            rs.last();
            int rowCount = rs.getRow();
            Object[][] resultArray = new Object[rowCount][columnCount];
            columnNames = new String[columnCount];

            rs.beforeFirst();

            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = rs.getMetaData().getColumnName(i);
            }

            while (rs.next()) {
                for (int i = 0; i < columnCount; i++) {
                    resultArray[rs.getRow() - 1][i] = rs.getObject(i + 1);
                }

            }
            if(rowCount == 0){
                JOptionPane.showMessageDialog(null, "No se encontraron resultados");
                throw new SQLException("No se encontraron coincidencias.");
                
            }
            return resultArray;
        } catch (SQLException ex) {
            System.out.println("Error al buscar datos de visitas");
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

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

}
