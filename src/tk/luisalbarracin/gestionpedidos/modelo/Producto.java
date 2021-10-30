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
public class Producto {
    private String codigo;
    private String nombre;
    private Float precioCompra;
    private Float precioVenta;
    private Integer cantidad;
    private Integer cantidadMinima;
    private Boolean iva;

    public Producto() {
    }

    public Producto(String codigo, String nombre, Float precioCompra, Float precioVenta, Integer cantidad, Integer cantidadMinima, Boolean iva) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.cantidad = cantidad;
        this.cantidadMinima = cantidadMinima;
        this.iva = iva;
    }

    public Producto(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(Integer cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public Boolean getIva() {
        return iva;
    }

    public void setIva(Boolean iva) {
        this.iva = iva;
    }
    
    
    
}
