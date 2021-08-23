/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.luisalbarracin.gestionpedidoapp.services;

import java.util.List;
import tk.luisalbarracin.gestionpedidoapp.dao.ClienteDao;
import tk.luisalbarracin.gestionpedidoapp.model.Cliente;
import tk.luisalbarracin.gestionpedidoapp.model.Cuenta;

/**
 *
 * @author luis-albarracin
 */
public class ServicioClientes {
    private ClienteDao clienteDao;
    
    public Boolean agregar(String identificacion, String nombre, String direccion, String telefonoCelular, String correo){
        this.clienteDao.agregar(new Cliente(identificacion, nombre, direccion, telefonoCelular, correo));
        
        return true;
    }
    
    public Boolean eliminar(String identificacion){
        return this.clienteDao.eliminar(identificacion);
    }
    
    public Boolean modificar(String identificacion, String nombre, String direccion, String telefonoCelular, String correo){
        Boolean exito = false;
        Cliente cliente = this.clienteDao.modificar(new Cliente(identificacion, nombre, direccion, telefonoCelular, correo));
        
        if(cliente != null){
            exito = true;
        }
        
        return exito;
    }
    
    public List<Cliente> listar(){
        
        return this.clienteDao.listar();
    }
    
    public Cliente buscar(String identificacion){
        return clienteDao.buscar(identificacion);
    }
    
    public void pagarPedido(String cliente,Float cantidadDinero){
        this.clienteDao.sacarDinero(this.buscar(cliente), cantidadDinero);
    }
    
    public Boolean agregarCuenta(String cliente_id, String tarjeta, Float dinero){
        Boolean exito = false;
        Cliente cliente = this.clienteDao.buscar(cliente_id);
        cliente.getCuentas().add(new Cuenta(tarjeta, dinero));
        
        cliente = this.clienteDao.modificar(cliente);
        if(cliente != null){
            exito = true;
        }
        
        return exito;
    }
    
}
