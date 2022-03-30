package co.com.donraul.app.repositories;

import co.com.donraul.app.models.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ClienteRepository extends ReactiveMongoRepository<Cliente, String> {
    Mono<Cliente> findByNumIdentificacion(String numIdentificacion);
    Flux<Cliente> findByNombre(String nombre);
}
