package co.com.donraul.app.repositories;

import co.com.donraul.app.models.Volante;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VolanteRepository extends ReactiveMongoRepository<Volante, String> {
}
