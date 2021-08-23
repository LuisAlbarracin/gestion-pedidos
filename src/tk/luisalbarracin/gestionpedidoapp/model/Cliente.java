/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.luisalbarracin.gestionpedidoapp.model;

import java.util.List;

/**
 *
 * @author luis-albarracin
 */
public class Cliente {

    private String identificacion;
    private String nombre;
    private String direccion;
    private String telefonoCelular;
    private String correo;
    private List<Cuenta> cuentas;

    public Cliente() {
    }

    public Cliente(String identificacion, String nombre, String direccion, String telefonoCelular, String correo, List<Cuenta> cuentas) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonoCelular = telefonoCelular;
        this.correo = correo;
        this.cuentas = cuentas;
    }

    public Cliente(String identificacion, String nombre, String direccion, String telefonoCelular, String correo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonoCelular = telefonoCelular;
        this.correo = correo;
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

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

}
