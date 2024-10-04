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
public interface CRUDAutor {

    public boolean guardarAutor();

    public boolean eliminarAutor();

    public boolean actualizarAutor();

    public List<Autor> listarAutores();

}
