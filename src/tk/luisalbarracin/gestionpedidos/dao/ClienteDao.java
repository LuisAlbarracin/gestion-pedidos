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
import tk.luisalbarracin.gestionpedidos.util.ConexionMySQL;

/**
 *
 * @author luis-albarracin
 */
public class ClienteDao {
    private ConexionMySQL conexion;
    
    private static final String INSERT_CLIENTE_SQL = "INSERT INTO cliente (identificacion, nombre, direccion, telefono, correo) VALUES (?, ?, ?, ?, ?);";
    private static final String DELETE_CLIENTE_SQL = "DELETE FROM cliente WHERE identificacion = ?;";
    private static final String UPDATE_CLIENTE_SQL = "UPDATE cliente SET nombre = ?, direccion = ?, telefono = ?, correo = ? WHERE identificacion = ?;";
    private static final String SELECT_CLIENTE_BY_ID_SQL = "SELECT * FROM cliente WHERE identificacion = ?;";
    private static final String SELECT_ALL_CLIENTE_SQL = "SELECT identificacion, nombre, direccion, telefono, correo FROM cliente;";
    
    public void insertar(Cliente cliente){
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_CLIENTE_SQL);
            preparedStatement.setString(1, cliente.getIdentificacion());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getDireccion());
            preparedStatement.setString(4, cliente.getTelefono());
            preparedStatement.setString(5, cliente.getCorreo());
            
            conexion.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public Cliente buscar(String identificacion){
        Cliente cliente = null;
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_CLIENTE_BY_ID_SQL);
            preparedStatement.setString(1, identificacion);
            ResultSet rs = conexion.query();
            
            while(rs.next()){
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                
                cliente = new Cliente(identificacion, nombre, direccion, telefono, correo);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cliente;
    }
    
    public List<Cliente> listar(){
        List<Cliente> clientes = new ArrayList<>();
        
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ALL_CLIENTE_SQL);
            
            ResultSet rs = conexion.query();
            while(rs.next()){
                String identificacion = rs.getString("identificacion");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                
                clientes.add(new Cliente(identificacion, nombre, direccion, telefono, correo));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return clientes;
    }
    
    public void borrar(String identificacion){
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(DELETE_CLIENTE_SQL);
            preparedStatement.setString(1, identificacion);
            conexion.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void actualizar(Cliente cliente){
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(UPDATE_CLIENTE_SQL);
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getDireccion());
            preparedStatement.setString(3, cliente.getTelefono());
            preparedStatement.setString(4, cliente.getCorreo());
            preparedStatement.setString(5, cliente.getIdentificacion());
            
            conexion.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
