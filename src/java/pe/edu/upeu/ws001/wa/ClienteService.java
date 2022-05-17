/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.upeu.ws001.wa;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.upeu.ws001.dao.ClienteDao;
import pe.edu.upeu.ws001.daoImpl.ClienteDaoImpl;
import pe.edu.upeu.ws001.model.Cliente;



/**
 *
 * @author Usuario
 */
@WebService(serviceName = "Cliente")
public class ClienteService {
    ClienteDao cd = new ClienteDaoImpl();
    
    @WebMethod(operationName = "editarCliente")
    public int editar1(@WebParam(name = "nombres") String nombres , @WebParam(name = "apellidos") String apellidos , @WebParam(name = "dni") String dni, @WebParam(name = "direccion") String direccion, @WebParam(name = "idcliente") int idcliente) {
        Cliente c = new Cliente();
        c.setNombres(nombres);
        c.setApellidos(apellidos);
        c.setDni(dni);
        c.setDireccion(direccion);
        c.setIdcliente(idcliente);
        return cd.update(c);
    }

   
    @WebMethod(operationName = "insertarCliente")
    public int insertar1(@WebParam(name = "nombres") String nombres , @WebParam(name = "apellidos") String apellidos , @WebParam(name = "dni") String dni, @WebParam(name = "direccion") String direccion) {
        //TODO write your implementation code here:
        Cliente c = new Cliente();
        c.setNombres(nombres);
        c.setApellidos(apellidos);
        c.setDni(dni);
        c.setDireccion(direccion);
        return cd.create(c);
    }

  
    @WebMethod(operationName = "eliminarCliente")
    public int eliminar1(@WebParam(name = "idcliente") int idcliente) {
        //TODO write your implementation code here:
        return cd.delete(idcliente);
    }


   
    @WebMethod(operationName = "readAllCliente")
    public List<Cliente> readAll1() {
        //TODO write your implementation code here:
        return cd.readAll();
    }

    @WebMethod(operationName = "readCliente")
    public Cliente read1(@WebParam(name = "idcliente") int idcliente) {
        //TODO write your implementation code here:
        return cd.read(idcliente);
    }
}
