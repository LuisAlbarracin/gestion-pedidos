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
public class Pedido {

    private String id;
    private static final Integer CANTIDAD_UNIDADES_MAX = 20;
    private Cliente cliente;
    private Float precioTotal;
    private Float precioSinIva;
    private List<Orden> ordenes;
    private String estado;

    public Pedido() {
    }

    public Pedido(Cliente cliente, Float precioTotal, Float precioSinIva, List<Orden> ordenes, String estado) {
        this.cliente = cliente;
        this.precioTotal = precioTotal;
        this.precioSinIva = precioSinIva;
        this.ordenes = ordenes;
        this.estado = estado;
    }

    public Pedido(Cliente cliente, Float precioTotal, Float precioSinIva, List<Orden> ordenes) {
        this.cliente = cliente;
        this.precioTotal = precioTotal;
        this.precioSinIva = precioSinIva;
        this.ordenes = ordenes;
    }

    public Pedido(String id, Cliente cliente, Float precioTotal, Float precioSinIva, List<Orden> ordenes, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.precioTotal = precioTotal;
        this.precioSinIva = precioSinIva;
        this.ordenes = ordenes;
        this.estado = estado;
    }

    public Pedido(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Float getPrecioSinIva() {
        return precioSinIva;
    }

    public void setPrecioSinIva(Float precioSinIva) {
        this.precioSinIva = precioSinIva;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
