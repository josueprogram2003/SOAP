/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.ws001.dao;

import java.util.List;
import pe.edu.upeu.ws001.model.Cliente;

/**
 *
 * @author Usuario
 */
public interface ClienteDao {
    int create(Cliente c);
    int update(Cliente c);
    int delete(int idcliente);
    Cliente read(int idcliente);
    List<Cliente> readAll();
}
