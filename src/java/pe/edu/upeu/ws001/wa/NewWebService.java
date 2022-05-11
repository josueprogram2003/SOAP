/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.upeu.ws001.wa;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.upeu.ws001.daoImpl.RolDaoImpl;
import pe.edu.upeu.ws001.model.Rol;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {
    
    RolDaoImpl rd = new RolDaoImpl();
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
 
    @WebMethod(operationName = "editar")
    public int editar(@WebParam(name = "idrol") int idrol, @WebParam(name = "nombre") String nombre) {
        Rol r = new Rol();
        r.setNombre(nombre);
        r.setIdrol(idrol);
        return rd.update(r);
    }

   
    @WebMethod(operationName = "insertar")
    public int insertar(@WebParam(name = "nombre") String nombre) {
        //TODO write your implementation code here:
        Rol r = new Rol();
        r.setNombre(nombre);
        return rd.create(r);
    }

  
    @WebMethod(operationName = "eliminar")
    public int eliminar(@WebParam(name = "idrol") int idrol) {
        //TODO write your implementation code here:
        return rd.delete(idrol);
    }


   
    @WebMethod(operationName = "readAll")
    public List<Rol> readAll() {
        //TODO write your implementation code here:
        return rd.readAll();
    }

 
    @WebMethod(operationName = "read")
    public Rol read(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        return rd.read(id);
    }
    
    
}
