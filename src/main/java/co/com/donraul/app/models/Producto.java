package co.com.donraul.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inventario")
public class Producto {

    @Id
    private String id;
    private String nombre;
    private Integer precio;
    private Integer cantidad;
    private Integer cantidadMinima;
    private Integer cantidadMaxima;
    private String estado;
    private enum medida {BAJO, NORMAL, ALTO};

    public Producto(String nombre, Integer precio, Integer cantidad, Integer cantidadMinima, Integer cantidadMaxima, String estado) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.cantidadMinima = cantidadMinima;
        this.cantidadMaxima = cantidadMaxima;
        this.estado = setEstado();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima(Integer cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public Integer getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(Integer cantidadMaxima) {
        this.cantidadMaxima = cantidadMaxima;
    }

    public String getEstado() {
        return estado;
    }

    public String setEstado() {
        if (this.cantidad<=cantidadMinima) return this.estado = medida.BAJO.toString();
        if (this.cantidad>=cantidadMaxima) return this.estado = medida.ALTO.toString();
        if (this.cantidad < cantidadMaxima && this.cantidad > cantidadMinima ) return this.estado = medida.NORMAL.toString();
        return "Sin actualizar";
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", cantidadMinima=" + cantidadMinima +
                ", cantidadMaxima=" + cantidadMaxima +
                ", estado='" + estado + '\'' +
                '}';
    }
}
