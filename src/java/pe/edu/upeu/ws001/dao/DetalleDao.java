/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.ws001.dao;

import java.util.List;
import pe.edu.upeu.ws001.model.Detalle;

/**
 *
 * @author Usuario
 */
public interface DetalleDao {
    int create(Detalle d);
    int update(Detalle d);
    int delete(int iddetalle);
    Detalle read(int iddetalle);
    List<Detalle> readAll();
}
