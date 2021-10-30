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
public class Pedido {

    private Integer id;
    private Cliente cliente;
    private String estado;
    private List<Orden> ordenes;

    public Pedido() {
    }

    public Pedido(Integer id, Cliente cliente, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.estado = estado;
    }

    public Pedido(Integer id, Cliente cliente, String estado, List<Orden> ordenes) {
        this.id = id;
        this.cliente = cliente;
        this.estado = estado;
        this.ordenes = ordenes;
    }

    public Pedido(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

}
