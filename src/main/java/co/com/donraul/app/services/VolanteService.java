package co.com.donraul.app.services;

import co.com.donraul.app.models.Producto;
import co.com.donraul.app.models.Proveedor;
import co.com.donraul.app.models.Volante;
import co.com.donraul.app.repositories.ProductoRepository;
import co.com.donraul.app.repositories.ProveedorRepository;
import co.com.donraul.app.repositories.VolanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

@Service
public class VolanteService {

    @Autowired
    VolanteRepository volanteRepository;
    @Autowired
    ProveedorRepository proveedorRepository;
    @Autowired
    ProductoService productoService;

    public Mono<Volante> agregarVolante (String numIdentificacion, List<Producto> productos) {
        List<Producto> sinModificar = productos;
        Proveedor proveedor = proveedorRepository.findByNumIdentificacion(numIdentificacion).block();

        for (int i = 0; i < sinModificar.size(); i++) {
            productoService.actualizarProducto(sinModificar.get(i).getId(), sinModificar.get(i)).subscribe();
        }

        Volante volante = new Volante(LocalDate.now(),proveedor,productos);

        return volanteRepository.save(volante);

    }

    public Mono<Volante> buscarVolantePorId (String id) {
        return volanteRepository.findById(id);
    }

    public Flux<Volante> buscarVolantes () {
        return volanteRepository.findAll();
    }
}
