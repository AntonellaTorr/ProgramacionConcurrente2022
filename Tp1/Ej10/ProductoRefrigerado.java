/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp1.Ej10;

import java.util.Date;

/**
 *
 * @author Antonella
 */
public class ProductoRefrigerado extends Producto{
   private int codigoOrganismo;
    private int tempMantenimiento;
    
    public ProductoRefrigerado(int codigoOrganismo, int tempMantenimiento, String denominacion, Date fechaCaducidad, Date fechaEnvasado, int nroLote, String paisOrigen)
      throws ProductoVencido{
        super(denominacion, fechaCaducidad, fechaEnvasado, nroLote, paisOrigen);
        this.codigoOrganismo = codigoOrganismo;
        this.tempMantenimiento = tempMantenimiento;
    }
 
    
    
}
