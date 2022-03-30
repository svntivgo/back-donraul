package co.com.donraul.app.services;

import co.com.donraul.app.models.Vendedor;
import co.com.donraul.app.repositories.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VendedorService {

    @Autowired
    VendedorRepository vendedorRepository;

    public Mono<Vendedor> agregarVendedor(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public Mono<Vendedor> actualizarVendedor (String id, Vendedor vendedor) {
        return vendedorRepository.findById(id).flatMap(vende -> {
            vendedor.setId(id);
            return agregarVendedor(vendedor);
        });
    }

    public Mono<Vendedor> eliminarVendedor (String id) {
        return vendedorRepository.findById(id).flatMap(vendedor ->
                vendedorRepository.deleteById(vendedor.getId()).thenReturn(vendedor)
        );
    }

    public Mono<Vendedor> buscarVendedorPorNumIdentificacion (String numIdentificacion) {
        return vendedorRepository.findByNumIdentificacion(numIdentificacion);
    }

    public Flux<Vendedor> buscarVendedorPorNombre (String nombre) {
        return vendedorRepository.findByNombre(nombre);
    }
}
