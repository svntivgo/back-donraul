package co.com.donraul.app.repositories;

import co.com.donraul.app.models.Proveedor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ProveedorRepository extends ReactiveMongoRepository<Proveedor, Long> {
    Mono<Proveedor> findByNumIdentificacion(String numIdentificacion);
    Flux<Proveedor> findByNombre(String nombre);
}
