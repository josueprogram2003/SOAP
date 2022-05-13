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
import pe.edu.upeu.ws001.dao.DetalleDao;
import pe.edu.upeu.ws001.model.Detalle;


/**
 *
 * @author Usuario
 */
public class DetalleDaoImpl implements DetalleDao{
   private PreparedStatement ps;
   private ResultSet rs;
   private Connection cx;

    @Override
    public int create(Detalle d) {
      String SQL = "insert into detalle(precio,cantidad,idproducto,idventa) values (?,?,?,?)";
        int x=0;
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setDouble(1, d.getPrecio());
            ps.setInt(2, d.getCantidad());
            ps.setInt(3, d.getIdproducto());
            ps.setInt(4, d.getIdventa());
            x=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;   
    }

    @Override
    public int update(Detalle d) {
      String SQL = "update detalle set precio = ? , cantidad = ? , idproducto = ? ,idventa = ? where iddetalle = ?";
        int x=0;
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setDouble(1, d.getPrecio());
            ps.setInt(2, d.getCantidad());
            ps.setInt(3, d.getIdproducto());
            ps.setInt(4, d.getIdventa());
            ps.setInt(5, d.getIddetalle());
            x=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;     
    }

    @Override
    public int delete(int iddetalle) {
         String SQL = "delete from detalle where iddetalle=?";
        int x=0;
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setInt(1, iddetalle);
            x=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x; 
    }

    @Override
    public Detalle read(int iddetalle) {
        String SQL = "select *from detalle where iddetalle=?";
        Detalle d = new Detalle();
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setInt(1, iddetalle);
            rs=ps.executeQuery();
            while (rs.next()) {                
               d.setIddetalle(rs.getInt("iddetalle"));
               d.setPrecio(rs.getDouble("precio"));
               d.setCantidad(rs.getInt("cantidad"));
               d.setIdproducto(rs.getInt("idproducto"));
               d.setIdventa(rs.getInt("idventa"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return d;   
    }

    @Override
    public List<Detalle> readAll() {
       String SQL = "select * from detalle";
        List<Detalle> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            rs=ps.executeQuery();
            while (rs.next()) {  
               Detalle d = new Detalle();
               d.setIddetalle(rs.getInt("iddetalle"));
               d.setPrecio(rs.getDouble("precio"));
               d.setCantidad(rs.getInt("cantidad"));
               d.setIdproducto(rs.getInt("idproducto"));
               d.setIdventa(rs.getInt("idventa"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;  
    }
}
