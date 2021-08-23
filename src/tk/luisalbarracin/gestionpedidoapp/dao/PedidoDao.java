/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.luisalbarracin.gestionpedidoapp.dao;

import java.util.ArrayList;
import java.util.List;
import tk.luisalbarracin.gestionpedidoapp.model.Pedido;
import tk.luisalbarracin.gestionpedidoapp.model.Tienda;

/**
 *
 * @author luis-albarracin
 */
public class PedidoDao {

    private Tienda tienda;

    public Boolean crear(Pedido pedido) {

        return tienda.getPedidos().add(pedido);
    }

    public Boolean eliminar(String id) {

        Integer i = 0;
        for (Pedido p : tienda.getPedidos()) {
            return tienda.getPedidos().remove(i);
        }

        return false;
    }

    public Pedido modificar(Pedido p) {

        Pedido pe = null;

        for (Pedido pedi : this.tienda.getPedidos()) {
            if (pedi.getId().equals(p.getId())) {
                pedi.setCliente(p.getCliente());
                pedi.setEstado(p.getEstado());
                pedi.setOrdenes(p.getOrdenes());
                pedi.setPrecioSinIva(p.getPrecioSinIva());
                pedi.setPrecioTotal(p.getPrecioTotal());

                pe = pedi;
            }
        }

        return pe;
    }

    public Pedido buscar(String pe) {
        Pedido pedido = null;

        for (Pedido p : this.tienda.getPedidos()) {
            if (p.getId().equals(pe)) {
                pedido = p;
            }
        }

        return pedido;
    }

    public List<Pedido> listar() {
        return this.tienda.getPedidos();
    }

    public List<Pedido> listarEntregados() {

        List<Pedido> pedidos = new ArrayList<>();

        for (Pedido p : this.tienda.getPedidos()) {
            if (p.getEstado().equals("Entregado")) {
                pedidos.add(p);
            }
        }

        return pedidos;
    }

    public List<Pedido> listarAprobados() {

        List<Pedido> pedidos = new ArrayList<>();

        for (Pedido p : this.tienda.getPedidos()) {
            if (p.getEstado().equals("Aprobado")) {
                pedidos.add(p);
            }
        }

        return pedidos;
    }

    public List<Pedido> listarRechazados() {

        List<Pedido> pedidos = new ArrayList<>();

        for (Pedido p : this.tienda.getPedidos()) {
            if (p.getEstado().equals("Rechazado")) {
                pedidos.add(p);
            }
        }

        return pedidos;
    }

    public List<Pedido> listarCobrados() {

        List<Pedido> pedidos = new ArrayList<>();

        for (Pedido p : this.tienda.getPedidos()) {
            if (p.getEstado().equals("Cobrados")) {
                pedidos.add(p);
            }
        }

        return pedidos;
    }
}
