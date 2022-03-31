package co.com.donraul.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "facturas")
public class Factura {

    @Id
    private String id;
    private LocalDate fecha;
    private Cliente cliente;
    private Vendedor vendedor;
    private List<Producto> productos;
    private Integer total;

    public Factura(LocalDate fecha, Cliente cliente, Vendedor vendedor, List<Producto> productos) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.productos = productos;
        this.total = setTotal();
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer setTotal() {
        Integer subtotal = 0;
        for (int i = 0; i < this.productos.size(); i++) {
            subtotal = subtotal + (productos.get(i).getPrecio() * productos.get(i).getCantidad());
        }
        return this.total = subtotal;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", cliente=" + cliente +
                ", vendedor=" + vendedor +
                ", productos=" + productos +
                ", total=" + total +
                '}';
    }
}
