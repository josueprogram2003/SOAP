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
import pe.edu.upeu.ws001.dao.VentaDao;
import pe.edu.upeu.ws001.model.Venta;

/**
 *
 * @author Usuario
 */
public class VentaDaoImpl implements VentaDao{
   private PreparedStatement ps;
   private ResultSet rs;
   private Connection cx;

    @Override
    public int create(Venta v) {
        String SQL = "insert into venta(fecha,tipodoc,numdoc,idcliente) values (now(),?,?,?)";
        int x=0;
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setString(1, v.getTipodoc());
            ps.setString(2, v.getNumdoc());
            ps.setInt(3, v.getIdcliente());
            x=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x; 
    }

    @Override
    public int update(Venta v) {
        String SQL = "update venta set fecha = now() , tipodoc = ? , numdoc = ? , idcliente = ?  where idventa = ?";
        int x=0;
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setString(1, v.getTipodoc());
            ps.setString(2, v.getNumdoc());
            ps.setInt(3, v.getIdcliente());
            ps.setInt(4, v.getIdventa());
            x=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;   
    }

    @Override
    public int delete(int idventa) {
        String SQL = "delete from venta where idventa=?";
        int x=0;
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setInt(1, idventa);
            x=ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x; 
    }

    @Override
    public Venta read(int idventa) {
      String SQL = "select *from venta where idventa=?";
        Venta v = new Venta();
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setInt(1, idventa);
            rs=ps.executeQuery();
            while (rs.next()) {                
               v.setIdventa(rs.getInt("idventa"));
               v.setFecha(rs.getString("fecha"));
               v.setTipodoc(rs.getString("tipodoc"));
               v.setNumdoc(rs.getString("numdoc"));
               v.setIdcliente(rs.getInt("idcliente"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return v;     
    }

    @Override
    public List<Venta> readAll() {
       String SQL = "select * from venta";
        List<Venta> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            rs=ps.executeQuery();
            while (rs.next()) {  
               Venta v = new Venta();
               v.setIdventa(rs.getInt("idventa"));
               v.setFecha(rs.getString("fecha"));
               v.setTipodoc(rs.getString("tipodoc"));
               v.setNumdoc(rs.getString("numdoc"));
               v.setIdcliente(rs.getInt("idcliente"));
               lista.add(v);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;   
    }
   
   
   
}
