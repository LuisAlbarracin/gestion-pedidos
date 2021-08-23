/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.luisalbarracin.gestionpedidoapp.dao;

import java.util.List;
import tk.luisalbarracin.gestionpedidoapp.model.Bodega;
import tk.luisalbarracin.gestionpedidoapp.model.Producto;

/**
 *
 * @author luis-albarracin
 */
public class ProductoDao {
    private Bodega bodega;

    public ProductoDao(Bodega bodega) {
        this.bodega = bodega;
    }
    
    public Boolean agregar(Producto producto){
        return this.bodega.getProductos().add(producto);
        
    }
    
    public Boolean eliminar(String codigo){
        Boolean productoEliminado = false;
        Integer i = 0;
        for(Producto producto : this.bodega.getProductos()){
            if(producto.getCodigo().equals(codigo)){
                productoEliminado = this.bodega.getProductos().remove(i);
            }
            i++;
        }
        
        return productoEliminado;
    }  
    
    public Producto modificado(Producto producto){
        
        Producto product = null;
        
        for(Producto p : this.bodega.getProductos()){
            if(p.getCodigo().equals(producto.getCodigo())){
                p.setCantidadBodega(producto.getCantidadBodega());
                p.setCantidadMinimaBodega(producto.getCantidadMinimaBodega());
                p.setIva(producto.getIva());
                p.setNombre(producto.getNombre());
                p.setPrecioCompra(producto.getPrecioCompra());
                p.setPrecioVenta(producto.getPrecioVenta());
                product = p;
            }
        }
        
        return product;
    }
    
    public Producto buscar(String identificacion){
        Producto product = null;
        
        for(Producto p : this.bodega.getProductos()){
            if(p.getCodigo().equals(identificacion)){
                product = p;
            }
        }
        
        return product;
    }
    
    public List<Producto> listar(){
        
        return this.bodega.getProductos();
    }
}
