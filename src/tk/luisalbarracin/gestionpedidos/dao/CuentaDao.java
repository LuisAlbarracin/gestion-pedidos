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
import tk.luisalbarracin.gestionpedidos.modelo.Cuenta;
import tk.luisalbarracin.gestionpedidos.modelo.Orden;
import tk.luisalbarracin.gestionpedidos.modelo.Pedido;
import tk.luisalbarracin.gestionpedidos.modelo.Producto;
import tk.luisalbarracin.gestionpedidos.util.ConexionMySQL;

/**
 *
 * @author luis-albarracin
 */
public class CuentaDao {
       private ConexionMySQL conexion;
    
    private static final String INSERT_CUENTA_SQL = "INSERT INTO cuenta (cliente, numero_tarjeta, cantidad_dinero) VALUES (?, ?, ?);";
    private static final String DELETE_CUENTA_SQL = "DELETE FROM cuenta WHERE numero_tarjeta= ? AND cliente = ?;";
    private static final String UPDATE_CUENTA_SQL = "UPDATE cuenta SET cantidad_dinero = ? WHERE numero_tarjeta= ? AND cliente = ?;";
    private static final String SELECT_CUENTA_BY_ID_SQL = "SELECT * FROM cuenta WHERE numero_tarjeta= ? AND cliente = ?;";
    private static final String SELECT_ALL_CUENTA_BY_CLIENTE_SQL = "SELECT * FROM cuenta WHERE cliente = ?;";
    private static final String SELECT_ALL_CUENTA_SQL = "SELECT * FROM cuenta;";
    
    
    public void insertar(Cuenta cuenta){
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_CUENTA_SQL);
            preparedStatement.setString(1, cuenta.getCliente().getIdentificacion());
            preparedStatement.setString(2, cuenta.getNumeroTarjeta());
            preparedStatement.setFloat(3, cuenta.getCantidad());
            
            conexion.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public Cuenta buscar(Cliente cliente, String tarjeta){
        Cuenta cuenta = null;
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_CUENTA_BY_ID_SQL);
            preparedStatement.setString(1, tarjeta);
            preparedStatement.setString(2, cliente.getIdentificacion());
            ResultSet rs = conexion.query();
            
            while(rs.next()){
                
                Float cantidad = rs.getFloat("cantidad_dinero");
                
                
                cuenta = new Cuenta(cliente, tarjeta, cantidad);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cuenta;
    }
    
    public List<Cuenta> listar(Cliente cliente){
        List<Cuenta> cuentas = new ArrayList<>();
        
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ALL_CUENTA_BY_CLIENTE_SQL);
            preparedStatement.setString(1, cliente.getIdentificacion());
            
            ResultSet rs = conexion.query();
            while(rs.next()){
                
                String tarjeta = rs.getString("tarjeta_credito");
                Float cantidad = rs.getFloat("cantidad_dinero");
                
                cuentas.add(new Cuenta(cliente, tarjeta, cantidad));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cuentas;
    }
    
    public void borrar(Cliente cliente, String tarjeta){
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(DELETE_CUENTA_SQL);
            preparedStatement.setString(1, tarjeta);
            preparedStatement.setString(2, cliente.getIdentificacion());
            conexion.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void actualizar(Cuenta cuenta){
        try{
            PreparedStatement preparedStatement = conexion.setPreparedStatement(UPDATE_CUENTA_SQL);
          
            preparedStatement.setFloat(1, cuenta.getCantidad());
            preparedStatement.setString(2, cuenta.getNumeroTarjeta());
            preparedStatement.setString(3, cuenta.getCliente().getIdentificacion());
            
            conexion.execute();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
