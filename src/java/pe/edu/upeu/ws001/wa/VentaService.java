/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.upeu.ws001.wa;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.upeu.ws001.dao.VentaDao;
import pe.edu.upeu.ws001.daoImpl.VentaDaoImpl;
import pe.edu.upeu.ws001.model.Venta;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "Venta")
public class VentaService {
    
    VentaDao vd = new VentaDaoImpl();
        
    @WebMethod(operationName = "editarVenta")
    public int editar5(@WebParam(name = "tipodoc") String tipodoc , @WebParam(name = "numdoc") String numdoc , @WebParam(name = "idcliente") int idcliente, @WebParam(name = "idventa") int idventa) {
        Venta v = new Venta();
        v.setTipodoc(tipodoc);
        v.setNumdoc(numdoc);
        v.setIdcliente(idcliente);
        v.setIdventa(idventa);
        return vd.update(v);
    }

   
    @WebMethod(operationName = "insertarVenta")
    public int insertar5(@WebParam(name = "tipodoc") String tipodoc , @WebParam(name = "numdoc") String numdoc , @WebParam(name = "idcliente") int idcliente) {
        //TODO write your implementation code here:
       Venta v = new Venta();
       v.setTipodoc(tipodoc);
       v.setNumdoc(numdoc);
       v.setIdcliente(idcliente);
        return vd.create(v);
    }

  
    @WebMethod(operationName = "eliminarVenta")
    public int eliminar5(@WebParam(name = "idventa") int idventa) {
        //TODO write your implementation code here:
        return vd.delete(idventa);
    }


   
    @WebMethod(operationName = "readAllVenta")
    public List<Venta> readAll5() {
        //TODO write your implementation code here:
        return vd.readAll();
    }

 
    @WebMethod(operationName = "readVenta")
    public Venta read5(@WebParam(name = "idventa") int idventa) {
        //TODO write your implementation code here:
        return vd.read(idventa);
    }
}
