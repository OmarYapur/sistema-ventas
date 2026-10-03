package gt.guatemarket.sistema.ventas.modelo;

public class Venta extends Cliente {

    private String idVenta;
    private String fechaVenta;

    public Venta() {
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
}
