/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.ws001.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Usuario
 */

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class Venta {
    
       private int idventa;
       private String fecha;
       private String tipodoc;
       private String numdoc;
       private int idcliente;
               
}
