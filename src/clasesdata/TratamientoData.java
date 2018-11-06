package clasesdata; 

import clasesprincipales.Tratamiento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

 
public class TratamientoData {
    private Connection con;
    private Object Nombretrat;

   
      public TratamientoData(Conexion conexion) {
          con = conexion.getConexion();
    }

    

    public void guardarTratamiento (Tratamiento tratamiento){
        try {
            
            String sql = "INSERT INTO tratamiento (idTratamient, nombreTrat, descripcion, precio, activo) VALUES ( ? , ? , ? , ? , ?);";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           
            ps.setInt(1, tratamient.getIdTratamient());
            ps.setInt(2, tratamiento.valueOf(tratamiento.getNombreTrat()));
            ps.setString(3, tratamiento.setDescripcion);
            ps.setDouble(4, tratamiento.getPrecio())
            ps.setTinyint(5, tratamiento.getActivo());
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                tratamiento.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo obtener el id luego de insertar un tratamiento");
            }
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un tratamiento: " + ex.getMessage());
        }
    }
    
    public List<Tratamiento> obtenerTratamientos(){
        List<Tratamiento> tratamientos = new ArrayList<Tratamiento>();
            

        try {
            String sql = "SELECT * FROM tratamiento;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Tratamiento tratamiento;
            while(resultSet.next()){
                tratamiento = new Tratamiento();
                tratamiento.setIdTratamient(resultSet.getInt("idTratamient"));
                tratamiento.setNombreTrat(resultSet.getInt"nombreTrat"));
                tratamiento.setDescripcion(resultSet.getString("descripcion"));
                tratamiento.setPrecio(resultSet.getDouble("precio"));
                tratamiento.setActivo(resultSet.getTinyint("activo"));

                tratamientos.add(tratamiento);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los tratamientos: " + ex.getMessage());
        }
        
        
        return tratamientos;
    }
    
    public void borrarTratamiento(int idTratamient){
    try {
            
            String sql = "DELETE FROM alumno WHERE id =?;";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
                      
            ps.executeUpdate();
                        
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un tratamiento: " + ex.getMessage());
        }
        
    
    }
    
    public void actualizarTratamiento(Tratamiento tratamiento){
    
        try {
            
            String sql = "UPDATE tratamiento SET idTratamient = ?, nombreTrat = ? , descripcion = ? , precio = ? " 
                    + "activo  =? WHERE id = ?;";
PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, tratamient.getIdTratamient());
            ps.setInt(2, tratamiento.valueOf(tratamiento.getNombreTrat()));
            ps.setString(3, tratamiento.setDescripcion);
            ps.setDouble(4, tratamiento.getPrecio())
            ps.setTinyint(5, tratamiento.getActivo());
            ps.executeUpdate();

            
          
            ps.close();
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un tratamiento: " + ex.getMessage());
        }
    
    }
    
    public Tratamiento buscarTratamiento(int id){
    Tratamiento tratamiento=null;
    try {
            
            String sql = "SELECT * FROM tratamiento WHERE id =?;";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
           
            
            ResultSet resultSet=ps.executeQuery();
            
            while(resultSet.next()){
                tratamiento = new Tratamiento();
                tratamiento.setIdTratamient(resultSet.getInt("idTratamient"));
                tratamiento.setNombreTrat(resultSet.getInt("nombreTrat"));
                tratamiento.setDescripcion(resultSet.getString("descripcion"));
                tratamiento.setPrecio(resultSet.getDouble("precio"));
                tratamiento.setActivo(resultSet.getTinyint("activo"));

                
            }      
            ps.close();
            
            
            
            
    
        } catch (SQLException ex) {
            System.out.println("Error al insertar un tratamiento: " + ex.getMessage());
        }
        
        return tratamiento;
    }
    
}

