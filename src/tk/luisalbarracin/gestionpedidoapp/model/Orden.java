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
public class Orden {

    private Integer id;
    private Producto producto;
    private Integer cantidad;
    private Float valor;

    public Orden() {
    }

    public Orden(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Orden(Producto producto, Integer cantidad, Float valor) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    public Orden(Integer id, Producto producto, Integer cantidad, Float valor) {
        this.id = id;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
