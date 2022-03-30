package co.com.donraul.app.services;

import co.com.donraul.app.models.Proveedor;
import co.com.donraul.app.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public Mono<Proveedor> agregarProveedor (Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Mono<Proveedor> actualizarProveedor (String id, Proveedor proveedor) {
        return proveedorRepository.findById(id).flatMap(prov -> {
            proveedor.setId(id);
            return agregarProveedor(proveedor);
        });
    }

    public String eliminarProveedor (String id) {
        proveedorRepository.deleteById(id);
        return "Se eliminó con éxito el proveedor con id: "+id;
    }

    public Mono<Proveedor> buscarProveedorPorNumIdentificacion (String numIdentificacion) {
        return proveedorRepository.findByNumIdentificacion(numIdentificacion);
    }

    public Flux<Proveedor> buscarProveedorPorNombre (String nombre) {
        return proveedorRepository.findByNombre(nombre);
    }

}
