/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.luisalbarracin.gestionpedidoapp.model;

/**
 *
 * @author luis-albarracin
 */
public class Producto {
    private String codigo;
    private String nombre;
    private Float precioCompra;
    private Float precioVenta;
    private Integer cantidadBodega;
    private Integer cantidadMinimaBodega;
    private Boolean iva;

    public Producto(String codigo, String nombre, Float precioCompra, Float precioVenta, Integer cantidadBodega, Integer cantidadMinimaBodega, Boolean iva) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.cantidadBodega = cantidadBodega;
        this.cantidadMinimaBodega = cantidadMinimaBodega;
        this.iva = iva;
    }

    public Producto() {
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

    public Integer getCantidadBodega() {
        return cantidadBodega;
    }

    public void setCantidadBodega(Integer cantidadBodega) {
        this.cantidadBodega = cantidadBodega;
    }

    public Integer getCantidadMinimaBodega() {
        return cantidadMinimaBodega;
    }

    public void setCantidadMinimaBodega(Integer cantidadMinimaBodega) {
        this.cantidadMinimaBodega = cantidadMinimaBodega;
    }

    public Boolean getIva() {
        return iva;
    }

    public void setIva(Boolean iva) {
        this.iva = iva;
    }
    
    
    
    
    
}
