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
public class Tienda {

    private String nombre;
    private List<Cliente> clientes;
    private Bodega bodega;
    private List<Pedido> pedidos;

    public Tienda() {
        
    }

    public Tienda(String nombre, List<Cliente> clientes, Bodega bodega, List<Pedido> pedidos) {
        this.nombre = nombre;
        this.clientes = clientes;
        this.bodega = bodega;
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

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }
    
    

}
