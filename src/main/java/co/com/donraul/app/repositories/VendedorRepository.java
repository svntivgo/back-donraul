package co.com.donraul.app.repositories;

import co.com.donraul.app.models.Proveedor;
import co.com.donraul.app.models.Vendedor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface VendedorRepository extends ReactiveMongoRepository<Vendedor, String> {
    Mono<Vendedor> findByNumIdentificacion(String numIdentificacion);
    Flux<Vendedor> findByNombre(String nombre);
}
