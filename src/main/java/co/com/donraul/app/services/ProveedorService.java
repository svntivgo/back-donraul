package co.com.donraul.app.services;

import co.com.donraul.app.models.Proveedor;
import co.com.donraul.app.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProveedorService {

    @Autowired
    ProveedorRepository proveedorRepository;

    public Mono<Proveedor> agregarProveedor (Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Mono<Proveedor> actualizarProveedor (Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public String eliminarProveedor (Long id) {
        proveedorRepository.deleteById(id);
        return "Se eliminó con éxito el proveedor con id: "+id;
    }

    public Mono<Proveedor> buscarProveedorPorId (Long id) {
        return proveedorRepository.findById(id);
    }

    public Flux<Proveedor> buscarProveedorPorNombre (String nombre) {
        return proveedorRepository.findByNombre(nombre);
    }

}
