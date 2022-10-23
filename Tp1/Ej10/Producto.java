/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp1.Ej10;
import java.util.Date;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

/**
 *
 * @author Antonella
 */
public class Producto {
    private  String denominacion;
    private Date fechaCaducidad;
    private Date fechaEnvasado;
    private int nroLote;
    private String paisOrigen;

    public Producto(String denominacion, Date fechaCaducidad, Date fechaEnvasado, int nroLote, String paisOrigen)
    {
        this.denominacion = denominacion;
        this.fechaCaducidad = fechaCaducidad;
        this.fechaEnvasado = fechaEnvasado;
        this.nroLote = nroLote;
        this.paisOrigen = paisOrigen;
        
     
    }
    public void verificarVencimiento ()throws ProductoVencido {
         if (fechaCaducidad.compareTo( new Date (System.currentTimeMillis()))<0)
            throw new ProductoVencido ();
    }
    
    


    public String getDenominacion() {
        return denominacion;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public int getNroLote() {
        return nroLote;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public void setNroLote(int nroLote) {
        this.nroLote = nroLote;
    }
    
  
}
