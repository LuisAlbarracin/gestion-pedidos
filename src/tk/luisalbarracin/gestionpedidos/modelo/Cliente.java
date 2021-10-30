/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.luisalbarracin.gestionpedidos.modelo;

/**
 *
 * @author luis-albarracin
 */
public class Cliente {
    private String identificacion;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;

    public Cliente() {
    }

    public Cliente(String identificacion, String nombre, String direccion, String telefono, String correo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Cliente(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}
