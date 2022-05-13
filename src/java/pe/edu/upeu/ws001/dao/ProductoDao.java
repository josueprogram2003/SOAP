/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.ws001.dao;

import java.util.List;
import pe.edu.upeu.ws001.model.Producto;

/**
 *
 * @author Usuario
 */
public interface ProductoDao {
    int create(Producto p);
    int update(Producto p);
    int delete(int idproducto);
    Producto read(int idproducto);
    List<Producto> readAll();
}
