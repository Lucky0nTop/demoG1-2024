/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uis.g2.logica;


import java.util.List;

/**
 *
 * @author CENTIC
 */
public class DemoConsultas {
    public static void main(String[] args) {
      /*  Autor a = new Autor("9999","Camilo","Peruano");
        a.guardarAutor();*/
       /* Autor a = new Autor("9999","Pedro","Boliviano");
        a.actualizarAutor();/*      
      */
       Autor a=new Autor("9999");
       a.eliminarAutor();        
        List<Autor> lista =a.listarAutores();        
        for (Autor autor : lista) {
            System.out.println(autor);
            
        }
        
    }
    
}
