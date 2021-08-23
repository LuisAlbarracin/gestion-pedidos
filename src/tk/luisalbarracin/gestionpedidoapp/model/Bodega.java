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
public class Bodega {
    private List<Producto> productos;
    

    public Bodega() {
    }

    public Bodega(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    
}
