/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.ws001.model;

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
public class Detalle {
    
    private int iddetalle;
    private double precio;
    private int cantidad;
    private int idproducto;
    private int idventa;
}
