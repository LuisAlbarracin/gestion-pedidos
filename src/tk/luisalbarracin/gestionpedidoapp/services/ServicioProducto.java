/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.luisalbarracin.gestionpedidoapp.services;

import tk.luisalbarracin.gestionpedidoapp.dao.ProductoDao;
import tk.luisalbarracin.gestionpedidoapp.model.Producto;

/**
 *
 * @author luis-albarracin
 */

public class ServicioProducto {

    private ProductoDao productoDao;

    public ServicioProducto(ProductoDao productoDao) {
        this.productoDao = productoDao;
    }

    public Boolean agregar(String codigo, String nombre, Float precioCompra, Float precioVenta, Integer cantidadBodega, Integer cantidadMinimaBodega, Boolean iva) {
        
        this.productoDao.agregar(new Producto(codigo, nombre, precioCompra, precioVenta, cantidadBodega, cantidadMinimaBodega, iva));
        
        return true;
    }

    public Boolean eliminar(String codigo) {
        
        return this.productoDao.eliminar(codigo);

    }

    public Boolean modificar(String codigo, String nombre, Float precioCompra, Float precioVenta, Integer cantidadBodega, Integer cantidadMinimaBodega, Boolean iva) {

        Producto pr = this.productoDao.modificado(new Producto(codigo, nombre, precioCompra, precioVenta, cantidadBodega, cantidadMinimaBodega, iva));
        if(pr!=null){
            return true;
        }else{
            return false;
        }
    }

    public String listar() {
        String productos = "";
        
        for(Producto pr : this.productoDao.listar()){
            productos += pr.toString();
        }
        return productos;
    }

    public String buscar(String codigo) {
        
        return this.productoDao.buscar(codigo).toString();
    }

}
