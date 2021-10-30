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
public class Orden {
    private Integer id;
    private Pedido pedido;
    private Producto producto;
    private Float cantidad;

    public Orden() {
    }

    public Orden(Integer id, Pedido pedido, Producto producto, Float cantidad) {
        this.id = id;
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Orden(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
