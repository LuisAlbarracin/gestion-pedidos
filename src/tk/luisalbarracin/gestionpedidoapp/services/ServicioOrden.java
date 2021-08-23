/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.luisalbarracin.gestionpedidoapp.services;

import tk.luisalbarracin.gestionpedidoapp.dao.PedidoDao;
import tk.luisalbarracin.gestionpedidoapp.dao.ProductoDao;
import tk.luisalbarracin.gestionpedidoapp.model.Orden;
import tk.luisalbarracin.gestionpedidoapp.model.Pedido;
import tk.luisalbarracin.gestionpedidoapp.model.Producto;

/**
 *
 * @author luis-albarracin
 */
public class ServicioOrden {
    
    private PedidoDao pedidoDao;
    private ProductoDao productoDao;
    
    public Boolean agregar(Integer id,String producto_id, Integer cantidad, String pedido_id){
        
        Pedido pedido = this.pedidoDao.buscar(pedido_id);
        Producto producto = this.productoDao.buscar(producto_id);
        Float valor = 0.0f;
        
        if(cantidad <= producto.getCantidadBodega() ){
             valor = producto.getPrecioVenta() * cantidad;
        }else{
            return false;
        }
        
        pedido.getOrdenes().add(new Orden(id, producto, cantidad, valor));
        
        return true;
    }
    
    public Boolean eliminar(){
        
        return true;
    }

    public Boolean modificar(){
        
        return true;
    }
    
    public void listar(){
        
    }
    
    public void buscar(){
        
    }
    
}
