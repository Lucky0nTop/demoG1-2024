/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uis.g2.logica;

/**
 *
 * @author CENTIC
 */
public class Libro {
    private String sbn;
    private String nombre;
    private int numeroDePaginas;
    private int annio;

    public Libro(String sbn, String nombre, int numeroDePaginas, int annio) {
        this.sbn = sbn;
        this.nombre = nombre;
        this.numeroDePaginas = numeroDePaginas;
        this.annio = annio;
    }

    public Libro(String sbn) {
        this.sbn = sbn;
    }

    public String getSbn() {
        return sbn;
    }

    public void setSbn(String sbn) {
        this.sbn = sbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public int getAnnio() {
        return annio;
    }

    public void setAnnio(int annio) {
        this.annio = annio;
    }
    
    
}
