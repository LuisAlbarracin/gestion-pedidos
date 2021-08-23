/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.luisalbarracin.gestionpedidoapp.services;

import java.util.List;
import tk.luisalbarracin.gestionpedidoapp.dao.PedidoDao;
import tk.luisalbarracin.gestionpedidoapp.model.Cuenta;
import tk.luisalbarracin.gestionpedidoapp.model.Orden;
import tk.luisalbarracin.gestionpedidoapp.model.Pedido;

/**
 *
 * @author luis-albarracin
 */
public class ServicioPedidos {

    private ServicioClientes servicioCliente;
    private PedidoDao pedidoDao;

    public ServicioPedidos(PedidoDao pedidoDao) {
        this.pedidoDao = pedidoDao;
    }

    public Boolean cobrar(String id) {
        Boolean cobrado = false;
        Pedido pedido = this.pedidoDao.buscar(id);
        List<Cuenta> cuentas = pedido.getCliente().getCuentas();

        Integer cantProductos = 0;

        for (Orden or : pedido.getOrdenes()) {
            cantProductos += or.getCantidad();
        }

        if (cantProductos > 40) {
            cobrado = false;
        } else {

            for (Cuenta c : cuentas) {
                if (c.getCantidadDinero() >= pedido.getPrecioTotal()) {
                    this.servicioCliente.pagarPedido(pedido.getCliente().getIdentificacion(), pedido.getPrecioTotal());
                    pedido.setEstado("Aceptado");
                    this.pedidoDao.modificar(pedido);
                    cobrado = true;
                }
            }

            if (cobrado) {
                this.ordenarDistribuir(pedido.getId());
            } else {
                pedido.setEstado("Rechazado");
            }
        }
        return cobrado;
    }

    public Boolean ordenarDistribuir(String pedido_id) {

        Pedido pedido = this.pedidoDao.buscar(pedido_id);
        pedido.setEstado("Cobrado");
        this.pedidoDao.modificar(pedido);
        this.confirmar(pedido_id);

        return true;
    }

    public Boolean confirmar(String pedido_id) {
        Pedido pedido = this.pedidoDao.buscar(pedido_id);
        pedido.setEstado("Entregado");
        this.pedidoDao.modificar(pedido);

        return true;
    }

}
