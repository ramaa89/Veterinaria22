/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesprincipales;

/**
 *
 * @author Usuario
 */
public class Tratamiento {
    
    private int idTratamient;
    private int nombreTrat;
    private vachar descripcion;
    private double precio;
    private tinyint activo;

    public Tratamiento(int idTratamient, int nombreTrat, vachar descripcion, double precio, tinyint activo) {
        this.idTratamient = idTratamient;
        this.nombreTrat = nombreTrat;
        this.descripcion = descripcion;
        this.precio = precio;
        this.activo = activo;
    }
public Tratamiento() { 
    
}  
    public int getIdTratamient() {
        return idTratamient;
    }

    public int getNombreTrat() {
        return nombreTrat;
    }

    public vachar getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public tinyint getActivo() {
        return activo;
    }

    public void setIdTratamient(int idTratamient) {
        this.idTratamient = idTratamient;
    }

    public void setNombreTrat(int nombreTrat) {
        this.nombreTrat = nombreTrat;
    }

    public void setDescripcion(vachar descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setActivo(tinyint activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Tratamiento{" + "idTratamient=" + idTratamient + ", nombreTrat=" + nombreTrat + ", descripcion=" + descripcion + ", precio=" + precio + ", activo=" + activo + '}';
    }
    
}

    

    

