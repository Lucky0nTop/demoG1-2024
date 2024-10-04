/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.uis.g2.logica;

import co.uis.g2.persistencia.ConexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CENTIC
 */
public class Autor implements CRUDAutor {

    private String codigo;
    private String nombre;
    private String nacionalidad;

    public Autor() {
    }

    public Autor(String codigo) {
        this.codigo = codigo;
    }

    public Autor(String codigo, String nombre, String nacionalida) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nacionalidad = nacionalida;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString() {
        return "Autor{" + "codigo=" + codigo + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + '}';
    }
    
    

    @Override
    public boolean guardarAutor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarAutor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizarAutor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Autor> listarAutores() {
        ConexionBD conexion = new ConexionBD();
        String query = "SELECT * FROM autores;";
        List<Autor> autores = new ArrayList<>();
        ResultSet rs = conexion.consultarBD(query);
        try {        
            Autor a;
            while (rs.next()) {
                a= new Autor();
                a.setCodigo(rs.getString("codigo"));
                a.setNombre(rs.getString("nombre"));
                a.setNacionalidad(rs.getString("nacionalidad"));
                autores.add(a);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Autor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {           
            //conexion.closeConnection();
             return autores;
        }

        
    }

}
