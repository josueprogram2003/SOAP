/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.ws001.dao;

import java.util.List;
import pe.edu.upeu.ws001.model.Rol;

/**
 *
 * @author Usuario
 */
public interface RolDao {
    int create(Rol rol);
    int update(Rol rol);
    int delete(int rol);
    Rol read(int id);
    List<Rol> readAll();
    
}
