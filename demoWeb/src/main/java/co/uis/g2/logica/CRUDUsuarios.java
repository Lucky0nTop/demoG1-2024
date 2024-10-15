/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.uis.g2.logica;

import java.util.List;

/**
 *
 * @author jhona
 */
public interface CRUDUsuarios {
    public boolean guardarUsuario();

    public boolean eliminarUsuario();

    public boolean actualizarUsuario();

    public List<Usuarios> listarUsuarios();
    
}
