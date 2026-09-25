/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.guatemarket.sistema.ventas.controlador;

import gt.guatemarket.sistema.ventas.dao.CategoriaDAOImpl;
import gt.guatemarket.sistema.ventas.modelo.Categoria;
import java.util.List;

/**
 *
 * @author omary
 */
public class CategoriaController {

    CategoriaDAOImpl dao;

    public CategoriaController() {
        dao = new CategoriaDAOImpl();
    }

    public void Guardar(Categoria categoria) {
        dao.guardar(categoria);
    }

    public List<Categoria> GetCategoria() {
        return dao.listar();
    }

    public void Eliminar(int idCategoria) {
        dao.eliminar(idCategoria);
    }

    public Categoria BuscarPorId(int idCategoria) {
        return dao.buscarPorId(idCategoria);
    }
}
