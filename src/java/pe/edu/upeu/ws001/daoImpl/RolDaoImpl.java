/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.ws001.daoImpl;

import java.util.List;
import pe.edu.upeu.ws001.dao.RolDao;
import pe.edu.upeu.ws001.model.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import pe.edu.upeu.ws001.config.Conexion;

/**
 *
 * @author Usuario
 */
public class RolDaoImpl implements RolDao{
    
   private PreparedStatement ps;
   private ResultSet rs;
   private Connection cx;
   

    @Override
    public int create(Rol rol) {
        String SQL = "insert into rol(nombre) values (?)";
        int x=0;
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setString(1, rol.getNombre());
            x=ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int update(Rol rol) {
        String SQL = "update rol set nombre = ? where idrol = ?";
        int x=0;
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setString(1, rol.getNombre());
            ps.setInt(2, rol.getIdrol());
            x=ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int rol) {
        String SQL = "delete from rol where idrol=?";
        int x=0;
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setInt(1, rol);
            x=ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public Rol read(int id) {
       String SQL = "select *from rol where idrol=?";
        Rol rol = new Rol();
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs=ps.executeQuery();
            while (rs.next()) {                
                rol.setIdrol(rs.getInt("idrol"));
                rol.setNombre(rs.getString("nombre"));
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return rol;
    }

    @Override
    public List<Rol> readAll() {
        String SQL = "select * from rol";
        List<Rol> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps=cx.prepareStatement(SQL);
            rs=ps.executeQuery();
            while (rs.next()) {  
                Rol rol = new Rol();
                rol.setIdrol(rs.getInt("idrol"));
                rol.setNombre(rs.getString("nombre"));
                lista.add(rol);
            }
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }
    
}
