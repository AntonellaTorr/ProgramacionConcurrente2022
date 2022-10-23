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
public class ProductoCongelado extends Producto {
    private double temperatura;


    public ProductoCongelado(double temperatura, String denominacion, Date fechaCaducidad, Date fechaEnvasado, int nroLote, String paisOrigen)
    throws ProductoVencido {
        super(denominacion, fechaCaducidad, fechaEnvasado, nroLote, paisOrigen);
        this.temperatura = temperatura;
    }
    
    
}
