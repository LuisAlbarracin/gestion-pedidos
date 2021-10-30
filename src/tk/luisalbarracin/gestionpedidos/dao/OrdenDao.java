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
import tk.luisalbarracin.gestionpedidos.modelo.Orden;
import tk.luisalbarracin.gestionpedidos.modelo.Pedido;
import tk.luisalbarracin.gestionpedidos.modelo.Producto;
import tk.luisalbarracin.gestionpedidos.util.ConexionMySQL;

/**
 *
 * @author luis-albarracin
 */
public class OrdenDao {
       private ConexionMySQL conexion;
    
    private static final String INSERT_ORDEN_SQL = "INSERT INTO orden (pedido, producto, cantidad) VALUES (?, ?, ?);";
    private static final String DELETE_ORDEN_SQL = "DELETE FROM orden WHERE id = ?;";
    private static final String UPDATE_ORDEN_SQL = "UPDATE orden SET producto = ?, cantidad = ? WHERE id = ?;";
    private static final String SELECT_ORDEN_BY_ID_SQL = "SELECT * FROM orden WHERE id = ?;";
    private static final String SELECT_ALL_ORDEN_SQL = "SELECT * FROM orden WHERE pedido = ?;";
    
    public void insertar(Orden orden){
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_ORDEN_SQL);
            preparedStatement.setInt(1, orden.getPedido().getId());
            preparedStatement.setString(2, orden.getProducto().getCodigo());
            preparedStatement.setFloat(3, orden.getCantidad());
            
            conexion.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public Orden buscar(Integer id){
        Orden orden = null;
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ORDEN_BY_ID_SQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = conexion.query();
            
            while(rs.next()){
                String producto = rs.getString("producto");
                Float cantidad = rs.getFloat("cantidad");
                Integer pedido = rs.getInt("pedido");
                
                
                orden = new Orden(id, new Pedido(pedido), new Producto(producto), cantidad);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return orden;
    }
    
    public List<Orden> listar(Integer ped){
        List<Orden> ordenes = new ArrayList<>();
        
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ALL_ORDEN_SQL);
            preparedStatement.setInt(1, ped);
            
            ResultSet rs = conexion.query();
            while(rs.next()){
                Integer id = rs.getInt("id");
                String producto = rs.getString("producto");
                Float cantidad = rs.getFloat("cantidad");
                Integer pedido = rs.getInt("pedido");
                
                ordenes.add(new Orden(id, new Pedido(pedido), new Producto(producto), cantidad));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return ordenes;
    }
    
    public void borrar(Integer id){
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(DELETE_ORDEN_SQL);
            preparedStatement.setInt(1, id);
            conexion.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void actualizar(Orden orden){
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(UPDATE_ORDEN_SQL);
          
            preparedStatement.setString(1, orden.getProducto().getCodigo());
            preparedStatement.setFloat(2, orden.getCantidad());
            preparedStatement.setInt(3, orden.getId());
            
            conexion.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
