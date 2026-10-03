/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.guatemarket.sistema.ventas.controlador;

import gt.guatemarket.sistema.ventas.dao.ClienteDAOImpl;
import gt.guatemarket.sistema.ventas.modelo.Cliente;
import java.util.List;

/**
 *
 * @author omary
 */
public class ClienteController {

    ClienteDAOImpl dao;

    public ClienteController() {
        dao = new ClienteDAOImpl();
    }

    public void Guardar(Cliente cliente) {
        dao.guardar(cliente);
    }

    public List<Cliente> GetCliente() {
        return dao.listar();
    }

    public void Eliminar(int codigoCliente) {
        dao.eliminar(codigoCliente);
    }

    public Cliente BuscarPorId(int codigoCliente) {
        return dao.buscarPorId(codigoCliente);
    }
}
