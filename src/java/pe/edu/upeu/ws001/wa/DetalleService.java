/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.upeu.ws001.wa;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.upeu.ws001.dao.DetalleDao;
import pe.edu.upeu.ws001.daoImpl.DetalleDaoImpl;
import pe.edu.upeu.ws001.model.Detalle;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "Detalle")
public class DetalleService {
    
    DetalleDao dd = new DetalleDaoImpl();
    
     /**
     * This is a sample web service operation
     */
    
    @WebMethod(operationName = "helloDetalle")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "editarDetalle")
    public int editar(@WebParam(name = "precio") double precio , @WebParam(name = "cantidad") int cantidad, @WebParam(name = "idproducto") int idproducto  , @WebParam(name = "iddetalle") int iddetalle, @WebParam(name = "idventa") int idventa) {
        Detalle d = new Detalle();
        d.setIddetalle(iddetalle);
        d.setPrecio(precio);
        d.setCantidad(cantidad);
        d.setIdproducto(idproducto);
        d.setIdventa(idventa);
        return dd.update(d);
    }

   
    @WebMethod(operationName = "insertarDetalle")
    public int insertar(@WebParam(name = "precio") double precio , @WebParam(name = "cantidad") int cantidad, @WebParam(name = "idproducto") int idproducto  , @WebParam(name = "idventa") int idventa) {
        //TODO write your implementation code here:
        Detalle d = new Detalle();
        d.setPrecio(precio);
        d.setCantidad(cantidad);
        d.setIdproducto(idproducto);
        d.setIdventa(idventa);
        return dd.create(d);
    }

  
    @WebMethod(operationName = "eliminarDetalle")
    public int eliminar(@WebParam(name = "iddetalle") int iddetalle) {
        //TODO write your implementation code here:
        return dd.delete(iddetalle);
    }


   
    @WebMethod(operationName = "readAllDetalle")
    public List<Detalle> readAll() {
        //TODO write your implementation code here:
        return dd.readAll();
    }

 
    @WebMethod(operationName = "readDetalle")
    public Detalle read(@WebParam(name = "iddetalle") int iddetalle) {
        //TODO write your implementation code here:
        return dd.read(iddetalle);
    }
    
}
