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

import pe.edu.upeu.ws001.dao.ProductoDao;
import pe.edu.upeu.ws001.model.Producto;

/**
 *
 * @author Usuario
 */
public class ProductoDaoImpl implements ProductoDao{
   private PreparedStatement ps;
   private ResultSet rs;
   private Connection cx;

    @Override
    public int create(Producto p) {
        String SQL = "insert into producto(nomprod,precio,stock) values (?,?,?)";
        int x=0;
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setString(1, p.getNomprod());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            x=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x; 
    }

    @Override
    public int update(Producto p) {
      String SQL = "update producto set nomprod = ? , precio = ? , stock = ?  where idproducto = ?";
        int x=0;
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setString(1, p.getNomprod());
            ps.setDouble(2, p.getPrecio());
            ps.setInt(3, p.getStock());
            ps.setInt(4, p.getIdproducto());
            x=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;   
    }

    @Override
    public int delete(int idproducto) {
        String SQL = "delete from producto where idproducto=?";
        int x=0;
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setInt(1, idproducto);
            x=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x; 
    }

    @Override
    public Producto read(int idproducto) {
     String SQL = "select *from producto where idproducto=?";
        Producto p = new Producto();
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setInt(1, idproducto);
            rs=ps.executeQuery();
            while (rs.next()) {                
               p.setIdproducto(rs.getInt("idproducto"));
               p.setNomprod(rs.getString("nomprod"));
               p.setPrecio(rs.getDouble("precio"));
               p.setStock(rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return p;   
    }

    @Override
    public List<Producto> readAll() {
        String SQL = "select * from producto";
        List<Producto> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            rs=ps.executeQuery();
            while (rs.next()) {  
                Producto p = new Producto();
                p.setIdproducto(rs.getInt("idproducto"));
                p.setNomprod(rs.getString("nomprod"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista; 
    }
}
