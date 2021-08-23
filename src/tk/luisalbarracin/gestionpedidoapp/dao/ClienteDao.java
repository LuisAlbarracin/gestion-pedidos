/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.luisalbarracin.gestionpedidoapp.dao;

import java.util.List;
import tk.luisalbarracin.gestionpedidoapp.model.Cliente;
import tk.luisalbarracin.gestionpedidoapp.model.Cuenta;
import tk.luisalbarracin.gestionpedidoapp.model.Tienda;

/**
 *
 * @author luis-albarracin
 */
public class ClienteDao {

    private Tienda tienda;

    public Boolean agregar(Cliente cliente) {
        return this.tienda.getClientes().add(cliente);
    }

    public Boolean eliminar(String identificacion) {
        Boolean remove = false;
        Integer i = 0;
        for (Cliente cliente : this.tienda.getClientes()) {
            if (cliente.getIdentificacion().equals(identificacion)) {
                remove = tienda.getClientes().remove(i);
                break;
            }
            i++;
        }

        return remove;
    }

    public Cliente modificar(Cliente cliente) {
        Cliente clienteModificado = null;

        for (Cliente cli : this.tienda.getClientes()) {
            if (cli.getIdentificacion().equals(cliente.getIdentificacion())) {

                cli.setCorreo(cliente.getCorreo());
                cli.setDireccion(cliente.getDireccion());
                cli.setNombre(cliente.getNombre());
                cli.setTelefonoCelular(cliente.getTelefonoCelular());
                cli.setCuentas(cliente.getCuentas());
                clienteModificado = cli;
            }

        }

        return clienteModificado;
    }

    public Cliente buscar(String identificacion) {
        Cliente cliente = null;

        for (Cliente cli : this.tienda.getClientes()) {
            if (cli.getIdentificacion().equals(identificacion)) {
                cliente = cli;
            }
        }

        return cliente;
    }

    public List<Cliente> listar() {

        return this.tienda.getClientes();
    }

    public Boolean sacarDinero(Cliente cliente, Float dinero) {
        Boolean exito = false;
        
        for (Cuenta cuenta : cliente.getCuentas()) {
            if (cuenta.getCantidadDinero() > dinero) {
                cuenta.setCantidadDinero(cuenta.getCantidadDinero() - dinero);
                exito = true;
                break;
            }
        }
        
        return exito;
    }

}
