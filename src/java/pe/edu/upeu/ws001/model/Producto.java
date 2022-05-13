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
public class Producto {
    private int idproducto;
    private String nomprod;
    private double precio;
    private int stock;
            
}
