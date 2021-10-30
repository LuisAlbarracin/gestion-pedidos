/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.luisalbarracin.gestionpedidos.modelo;

import java.util.List;

/**
 *
 * @author luis-albarracin
 */
public class Tienda {
    private String nombre;
    private List<Producto> productos;
    private List<Cliente> clientes;
    private List<Pedido> pedidos;

    public Tienda() {
    }

    public Tienda(String nombre, List<Producto> productos, List<Cliente> clientes, List<Pedido> pedidos) {
        this.nombre = nombre;
        this.productos = productos;
        this.clientes = clientes;
        this.pedidos = pedidos;
    }

    public Tienda(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    
    
}
