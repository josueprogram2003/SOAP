/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.ws001.config;

import com.google.gson.Gson;
import pe.edu.upeu.ws001.dao.ProductoDao;
import pe.edu.upeu.ws001.daoImpl.ProductoDaoImpl;

/**
 *
 * @author Usuario
 */
public class Test {
    static Gson gson = new Gson();
    static ProductoDao p = new ProductoDaoImpl();
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(Conexion.getConexion()!=null) {
			System.out.println("conectado");
		}else {
			System.out.println("Error");
		}
                System.out.println(gson.toJson(p.readAll()));
    }
}
