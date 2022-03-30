package co.com.donraul.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vendedores")
public class Vendedor {

    @Id
    private Long id;
    private String nombre;
    private String celular;
    private String numIdentificacion;

    public Vendedor(String nombre, String celular, String numIdentificacion) {
        this.nombre = nombre;
        this.celular = celular;
        this.numIdentificacion = numIdentificacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNumIdentificacion() {
        return numIdentificacion;
    }

    public void setNumIdentificacion(String numIdentificacion) {
        this.numIdentificacion = numIdentificacion;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", celular='" + celular + '\'' +
                ", numIdentificacion='" + numIdentificacion + '\'' +
                '}';
    }
}
