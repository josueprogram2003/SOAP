/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.ws001.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.ws001.config.Conexion;
import pe.edu.upeu.ws001.dao.ClienteDao;
import pe.edu.upeu.ws001.model.Cliente;

/**
 *
 * @author Usuario
 */
public class ClienteDaoImpl implements ClienteDao{
   private PreparedStatement ps;
   private ResultSet rs;
   private Connection cx;
 

    @Override
    public int create(Cliente c) {
        String SQL = "insert into cliente(nombres,apellidos,dni,direccion) values (?,?,?,?)";
        int x=0;
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setString(1, c.getNombres());
            ps.setString(2, c.getApellidos());
            ps.setString(3, c.getDni());
            ps.setString(4, c.getDireccion());
            x=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x; 
    }

    @Override
    public int update(Cliente c) {
       String SQL = "update cliente set nombres = ? , apellidos = ? , dni = ?, direccion = ?  where idcliente = ?";
        int x=0;
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setString(1, c.getNombres());
            ps.setString(2, c.getApellidos());
            ps.setString(3, c.getDni());
            ps.setString(4, c.getDireccion());
            ps.setInt(5, c.getIdcliente());
            x=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x; 
    }

    @Override
    public int delete(int idcliente) {
        String SQL = "delete from cliente where idcliente=?";
        int x=0;
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setInt(1, idcliente);
            x=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public Cliente read(int idcliente) {
        String SQL = "select *from cliente where idcliente=?";
        Cliente c = new Cliente();
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setInt(1, idcliente);
            rs=ps.executeQuery();
            while (rs.next()) {                
                c.setIdcliente(rs.getInt("idcliente"));
                c.setNombres(rs.getString("nombres"));
                c.setApellidos(rs.getString("apellidos"));
                c.setDni(rs.getString("dni"));
                c.setDireccion(rs.getString("direccion"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return c;
    }

    @Override
    public List<Cliente> readAll() {
         String SQL = "select * from cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            rs=ps.executeQuery();
            while (rs.next()) {  
                Cliente c = new Cliente();
                c.setIdcliente(rs.getInt("idcliente"));
                c.setNombres(rs.getString("nombres"));
                c.setApellidos(rs.getString("apellidos"));
                c.setDni(rs.getString("dni"));
                c.setDireccion(rs.getString("direccion"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }
   
}
