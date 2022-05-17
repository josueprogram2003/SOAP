/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.ws001.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Usuario
 */
public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/bdsoap2";
	private static final String USER = "root";
	private static final String PASS = "root";
	private static final String DRIVER= "com.mysql.cj.jdbc.Driver";
	private static Connection cx = null;
	
	public static Connection getConexion() {		
		try {
			Class.forName(DRIVER);
			if(cx==null) {
				cx = DriverManager.getConnection(URL, USER, PASS);
			}		
		} catch (Exception e) {
			System.out.println(e);
		}
		return cx;
	}	
}
