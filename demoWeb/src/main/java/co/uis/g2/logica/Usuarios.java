/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author jhona
 */
public class Usuarios implements CRUDUsuarios {
    private String correo;
    private String nombre;
    private String telefono;
    private int librosPrestados;
    
     public Usuarios() {
    }

    public Usuarios(String correo) {
        this.correo = correo;
    }

    public Usuarios(String correo, String nombre, String telefono, int librosPrestados) {
        this.correo = correo;
        this.nombre = nombre;
        this.telefono = telefono;
        this.librosPrestados = librosPrestados;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getLibrosPrestados() {
        return librosPrestados;
    }

    public void setLibrosPrestados(int librosPrestados) {
        this.librosPrestados = librosPrestados;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "correo=" + correo + ", nombre=" + nombre + ", telefono=" + telefono + ", librosPrestados=" + librosPrestados + '}';
    }

    @Override
    public boolean guardarUsuario() {
        ConexionBD conexion = new ConexionBD();
        boolean exito = false;
        String sql = "INSERT INTO usuarios (correo, nombre, telefono,librosPrestados) "
                + "VALUES('" + this.correo + "', '" + this.nombre + "', '" + this.telefono + "', '"+this.librosPrestados+"');";
        if (conexion.setAutoCommitBD(false)) {
            if (conexion.insertarBD(sql)) {
                conexion.commitBD();
                exito = true;
            } else {
                conexion.rollbackBD();
            }
        }
        conexion.cerrarConexion();
        return exito;
    }

    @Override
    public boolean eliminarUsuario() {
       ConexionBD conexion = new ConexionBD();
        boolean exito = false;
        String sql = "DELETE FROM usuarios WHERE correo='"+this.correo +"';";
        if (conexion.setAutoCommitBD(false)) {
            if (conexion.actualizarBD(sql)) {
                conexion.commitBD();
                exito = true;
            } else {
                conexion.rollbackBD();
            }
        }
        conexion.cerrarConexion();
        return exito;
    }

    @Override
    public boolean actualizarUsuario() {
        ConexionBD conexion = new ConexionBD();
        boolean exito = false;
        String sql = "UPDATE usuarios set nombre='" + this.nombre + "', telefono='" + this.telefono
                + "', librosPrestados='"+this.librosPrestados+"' WHERE correo='" + this.correo + "';";
        if (conexion.setAutoCommitBD(false)) {
            if (conexion.actualizarBD(sql)) {
                conexion.commitBD();
                exito = true;
            } else {
                conexion.rollbackBD();
            }
        }
        conexion.cerrarConexion();
        return exito;
    }

    @Override
    public List<Usuarios> listarUsuarios() {
        ConexionBD conexion = new ConexionBD();
        String query = "SELECT * FROM usuarios;";
        List<Usuarios> usuarios = new ArrayList<>();
        ResultSet rs = conexion.consultarBD(query);
        try {
            Usuarios u;
            while (rs.next()) {
                u = new Usuarios();
                u.setCorreo(rs.getString("correo"));
                u.setNombre(rs.getString("nombre"));
                u.setTelefono(rs.getString("telefono"));
                u.setLibrosPrestados(rs.getInt("librosPrestados"));
                usuarios.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.cerrarConexion();
        }
        return usuarios;
    }
}
