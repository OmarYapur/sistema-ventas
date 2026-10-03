/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gt.guatemarket.sistema.ventas.modelo;

/**
 *
 * @author omary
 */
public class Despachos {

    private String idOrdenDespacho;
    private String idVenta;
    private String fechaDespacho;
    private String estadoDespacho;

    public Despachos() {
    }

    public String getIdOrdenDespacho() {
        return idOrdenDespacho;
    }

    public void setIdOrdenDespacho(String idOrdenDespacho) {
        this.idOrdenDespacho = idOrdenDespacho;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(String fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    public String getEstadoDespacho() {
        return estadoDespacho;
    }

    public void setEstadoDespacho(String estadoDespacho) {
        this.estadoDespacho = estadoDespacho;
    }
}
