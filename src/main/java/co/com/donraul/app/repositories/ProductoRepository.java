package co.com.donraul.app.repositories;

import co.com.donraul.app.models.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ProductoRepository extends ReactiveMongoRepository<Producto, String> {
    Flux<Producto> findByEstado(String estado);
}
