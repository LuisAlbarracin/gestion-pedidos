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
import tk.luisalbarracin.gestionpedidos.modelo.Cliente;
import tk.luisalbarracin.gestionpedidos.modelo.Pedido;
import tk.luisalbarracin.gestionpedidos.util.ConexionMySQL;

/**
 *
 * @author luis-albarracin
 */
public class PedidoDao {
     private ConexionMySQL conexion;
    
    private static final String INSERT_PEDIDO_SQL = "INSERT INTO pedido (cliente, estado) VALUES (?, ?);";
    private static final String DELETE_PEDIDO_SQL = "DELETE FROM pedido WHERE id = ?;";
    private static final String UPDATE_PEDIDO_SQL = "UPDATE pedido SET estado = ? WHERE id = ?;";
    private static final String SELECT_PEDIDO_BY_ID_SQL = "SELECT * FROM pedido WHERE id = ?;";
    private static final String SELECT_ALL_PEDIDO_SQL = "SELECT id, cliente, estado FROM pedido;";
    private static final String SELECT_ALL_PEDIDO_BY_CLIENTE_SQL = "SELECT id, cliente, estado FROM pedido WHERE cliente = ?;";
    
    public void insertar(Pedido pedido){
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_PEDIDO_SQL);
            preparedStatement.setString(1, pedido.getCliente().getIdentificacion());
            preparedStatement.setString(2, pedido.getEstado());
            
            conexion.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public Pedido buscar(Integer id){
        Pedido pedido = null;
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_PEDIDO_BY_ID_SQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = conexion.query();
            
            while(rs.next()){
                String cliente = rs.getString("cliente");
                String estado = rs.getString("estado");;
                
                pedido = new Pedido(id, new Cliente(cliente), estado);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return pedido;
    }
    
    public List<Pedido> listar(){
        List<Pedido> pedidos = new ArrayList<>();
        
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ALL_PEDIDO_SQL);
            
            ResultSet rs = conexion.query();
            while(rs.next()){
                Integer id = rs.getInt("id");
                String cliente = rs.getString("cliente");
                String estado = rs.getString("estado");
                
                pedidos.add(new Pedido(id, new Cliente(cliente), estado));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return pedidos;
    }
    
    public List<Pedido> listarByCliente(String cliente){
        List<Pedido> pedidos = new ArrayList<>();
        
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ALL_PEDIDO_BY_CLIENTE_SQL);
            preparedStatement.setString(1, cliente);
            
            ResultSet rs = conexion.query();
            
            while(rs.next()){
                Integer id = rs.getInt("id");
                String estado = rs.getString("estado");
                
                pedidos.add(new Pedido(id, new Cliente(cliente), estado));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return pedidos;
    }
    
    public void borrar(Integer id){
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(DELETE_PEDIDO_SQL);
            preparedStatement.setInt(1, id);
            conexion.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void actualizar(Pedido pedido){
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(UPDATE_PEDIDO_SQL);
          
            preparedStatement.setString(1, pedido.getEstado());
            preparedStatement.setInt(2, pedido.getId());
            
            conexion.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
