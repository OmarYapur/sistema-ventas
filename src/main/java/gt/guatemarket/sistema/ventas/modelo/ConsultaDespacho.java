/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.guatemarket.sistema.ventas.modelo;

/**
 *
 * @author omary
 */
public class ConsultaDespacho {

    private String idDespacho;
    private String idVenta;
    private String fechaDespacho;
    private String estadoDespacho;

    public ConsultaDespacho(String idDespacho, String idVenta, String fechaDespacho, String estadoDespacho) {
        this.idDespacho = idDespacho;
        this.idVenta = idVenta;
        this.fechaDespacho = fechaDespacho;
        this.estadoDespacho = estadoDespacho;
    }

    public String getIdDespacho() {
        return idDespacho;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public String getFechaDespacho() {
        return fechaDespacho;
    }

    public String getEstadoDespacho() {
        return estadoDespacho;
    }
}
