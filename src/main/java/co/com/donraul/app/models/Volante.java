package co.com.donraul.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "volantes")
public class Volante {

    @Id
    private String id;
    private LocalDate fecha;
    private Proveedor proveedor;
    private List<Producto> productos;

    public Volante(LocalDate fecha, Proveedor proveedor, List<Producto> productos) {
        this.fecha = fecha;
        this.proveedor = proveedor;
        this.productos = productos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Volante{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", proveedor=" + proveedor +
                ", productos=" + productos +
                '}';
    }
}
