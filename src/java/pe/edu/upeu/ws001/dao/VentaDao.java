/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.ws001.dao;

import java.util.List;
import pe.edu.upeu.ws001.model.Venta;


/**s
 *
 * @author Usuario
 */
public interface VentaDao {
    int create(Venta v);
    int update(Venta v);
    int delete(int idventa);
    Venta read(int idventa);
    List<Venta> readAll();
}
