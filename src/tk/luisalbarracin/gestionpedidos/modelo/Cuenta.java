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
public class Cuenta {
    private Cliente cliente;
    private String numeroTarjeta;
    private Float cantidad;

    public Cuenta() {
    }

    public Cuenta(Cliente cliente, String numeroTarjeta, Float cantidad) {
        this.cliente = cliente;
        this.numeroTarjeta = numeroTarjeta;
        this.cantidad = cantidad;
    }

    public Cuenta(Cliente cliente, String numeroTarjeta) {
        this.cliente = cliente;
        this.numeroTarjeta = numeroTarjeta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
