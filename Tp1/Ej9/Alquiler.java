/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp1.Ej9;
import Tp1.Ej9.Barco;
import java.util.Date;



/**
*
* @author Antito
*/
public class Alquiler {
   private Cliente clientecito;
   private Date fechaInicio, fechaFin;
   private Barco barquesito;
   private int posAmarre;
   private Puerto puertito;



   public Alquiler(Cliente clientecito, Date fechaInicio, Date fechaFin, Barco barquesito, int posAmarre)
   throws ExcepcionDias{
       int diasT=(int)(fechaFin.getTime()-fechaInicio.getTime());
       
       this.clientecito = clientecito;
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
       this.barquesito = barquesito;
       this.posAmarre = posAmarre;
       
       if (diasT>puertito.getCantDias()){
           throw new ExcepcionDias ();       
       }
   }



   public Cliente getClientecito() {
       return clientecito;
   }



   public void setClientecito(Cliente clientecito) {
       this.clientecito = clientecito;
   }



   public Date getFechaInicio() {
       return fechaInicio;
   }



   public void setFechaInicio(Date fechaInicio) {
       this.fechaInicio = fechaInicio;
   }



   public Date getFechaFin() {
       return fechaFin;
   }



   public void setFechaFin(Date fechaFin) {
       this.fechaFin = fechaFin;
   }



   public Barco getBarquesito() {
       return barquesito;
   }



   public void setBarquesito(Barco barquesito) {
       this.barquesito = barquesito;
   }



   public int getPosAmarre() {
       return posAmarre;
   }



   public void setPosAmarre(int posAmarre) {
       this.posAmarre = posAmarre;
   }









}

