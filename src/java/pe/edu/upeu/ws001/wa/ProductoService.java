/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package pe.edu.upeu.ws001.wa;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import pe.edu.upeu.ws001.dao.ProductoDao;
import pe.edu.upeu.ws001.daoImpl.ProductoDaoImpl;
import pe.edu.upeu.ws001.model.Producto;


/**
 *
 * @author Usuario
 */
@WebService(serviceName = "Producto")
public class ProductoService {
    
    ProductoDao pd = new ProductoDaoImpl();
    
    @WebMethod(operationName = "editarProducto")
    public int editar4(@WebParam(name = "nomprod") String nomprod , @WebParam(name = "precio") double precio , @WebParam(name = "stock") int stock, @WebParam(name = "idproducto") int idproducto) {
        Producto p = new Producto();
        p.setNomprod(nomprod);
        p.setPrecio(precio);
        p.setStock(stock);
        p.setIdproducto(idproducto);
        return pd.update(p);
    }

   
    @WebMethod(operationName = "insertarProducto")
    public int insertar4(@WebParam(name = "nomprod") String nomprod , @WebParam(name = "precio") double precio , @WebParam(name = "stock") int stock) {
        //TODO write your implementation code here:
        Producto p = new Producto();
        p.setNomprod(nomprod);
        p.setPrecio(precio);
        p.setStock(stock);
        return pd.create(p);
    }

  
    @WebMethod(operationName = "eliminarProducto")
    public int eliminar4(@WebParam(name = "idproducto") int idproducto) {
        //TODO write your implementation code here:
        return pd.delete(idproducto);
    }


   
    @WebMethod(operationName = "readAllProducto")
    public List<Producto> readAll4() {
        //TODO write your implementation code here:
        return pd.readAll();
    }

 
    @WebMethod(operationName = "readProducto")
    public Producto read4(@WebParam(name = "idproducto") int idproducto) {
        //TODO write your implementation code here:
        return pd.read(idproducto);
    }
    
}
