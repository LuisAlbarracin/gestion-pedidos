/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.luisalbarracin.gestionpedidos.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tk.luisalbarracin.gestionpedidos.modelo.Producto;
import tk.luisalbarracin.gestionpedidos.util.ConexionMySQL;

/**
 *
 * @author luis-albarracin
 */
public class ProductoDao {
      private ConexionMySQL conexion;
    
    private static final String INSERT_PRODUCTO_SQL = "INSERT INTO producto (codigo, nombre, precio_compra, precio_venta, cantidad, cantidad_minima, iva) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String DELETE_PRODUCTO_SQL = "DELETE FROM producto WHERE codigo = ?;";
    private static final String UPDATE_PRODUCTO_SQL = "UPDATE producto SET nombre = ?, precio_compra = ?, precio_venta = ?, cantidad = ?, cantidad_minima = ?, iva = ? WHERE codigo = ?;";
    private static final String SELECT_PRODUCTO_BY_ID_SQL = "SELECT * FROM producto WHERE codigo = ?;";
    private static final String SELECT_ALL_PRODUCTO_SQL = "SELECT codigo, nombre, precio_compra, precio_venta, cantidad, cantidad_minima, iva FROM producto;";
    
    public void insertar(Producto producto){
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_PRODUCTO_SQL);
            preparedStatement.setString(1, producto.getCodigo());
            preparedStatement.setString(2, producto.getNombre());
            preparedStatement.setFloat(3, producto.getPrecioCompra());
            preparedStatement.setFloat(4, producto.getPrecioVenta());
            preparedStatement.setInt(5, producto.getCantidad());
            preparedStatement.setInt(6, producto.getCantidadMinima());
            preparedStatement.setBoolean(7, producto.getIva());
            
            conexion.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public Producto buscar(String codigo){
        Producto producto = null;
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_PRODUCTO_BY_ID_SQL);
            preparedStatement.setString(1, codigo);
            ResultSet rs = conexion.query();
            
            while(rs.next()){
                String nombre = rs.getString("nombre");
                Float precioCompra = rs.getFloat("direccion");
                Float precioVenta = rs.getFloat("telefono");
                Integer cantidad = rs.getInt("correo");
                Integer cantidadMinima = rs.getInt("cantidad_minima");
                Boolean iva = rs.getBoolean("iva");
                
                producto = new Producto(codigo, nombre, precioCompra, precioVenta, cantidad, cantidadMinima, iva);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return producto;
    }
    
    public List<Producto> listar(){
        List<Producto> productos = new ArrayList<>();
        
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ALL_PRODUCTO_SQL);
            
            ResultSet rs = conexion.query();
            while(rs.next()){
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                Float precioCompra = rs.getFloat("direccion");
                Float precioVenta = rs.getFloat("telefono");
                Integer cantidad = rs.getInt("correo");
                Integer cantidadMinima = rs.getInt("cantidad_minima");
                Boolean iva = rs.getBoolean("iva");
                
                productos.add(new Producto(codigo, nombre, precioCompra, precioVenta, cantidad, cantidadMinima, iva));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return productos;
    }
    
    public void borrar(String codigo){
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(DELETE_PRODUCTO_SQL);
            preparedStatement.setString(1, codigo);
            conexion.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void actualizar(Producto producto){
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(UPDATE_PRODUCTO_SQL);
          
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setFloat(2, producto.getPrecioCompra());
            preparedStatement.setFloat(3, producto.getPrecioVenta());
            preparedStatement.setInt(4, producto.getCantidad());
            preparedStatement.setInt(5, producto.getCantidadMinima());
            preparedStatement.setBoolean(6, producto.getIva());
            preparedStatement.setString(7, producto.getCodigo());
            
            conexion.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
