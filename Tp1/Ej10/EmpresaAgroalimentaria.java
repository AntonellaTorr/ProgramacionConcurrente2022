/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tp1.Ej10;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Antonella
 */
public class EmpresaAgroalimentaria {
    private String nombre;
    private Producto[] p= new Producto[100];

    public EmpresaAgroalimentaria(String nombre) {
        this.nombre=nombre;
        Date fechaE = new Date (2022,8,17);
        Date fechaC= new Date (2022,8,15);
        for (int i=0;i<p.length;i++){
            p[i]=new Producto("",fechaE, fechaC ,1, "Argentina");
         
        }
    }
    public Lista verificarProductos (){
        Lista vencidos= new Lista ();
        for (int i = 0; i < vencidos.longitud(); i++) {
            try{               
                  p[i].verificarVencimiento();
            }
            catch(ProductoVencido e){
               vencidos.insertar(p[i], vencidos.longitud());
            }
        }
        return vencidos;
    }

    
    public static void main(String[] args) {
        
        
    }
    
    
}
