/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gt.guatemarket.sistema.ventas.dao;

import gt.guatemarket.sistema.ventas.modelo.Categoria;
import java.util.List;

/**
 *
 * @author omary
 */
public interface CategoriaDAO {
    void guardar(Categoria categoria);

    List<Categoria> listar();

    Categoria buscarPorId(int id);

    void actualizar(Categoria categoria);

    void eliminar(int id);
}
