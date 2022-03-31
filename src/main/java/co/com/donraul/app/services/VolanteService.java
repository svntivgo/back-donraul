package co.com.donraul.app.services;

import co.com.donraul.app.models.Producto;
import co.com.donraul.app.models.Proveedor;
import co.com.donraul.app.models.Volante;
import co.com.donraul.app.repositories.ProveedorRepository;
import co.com.donraul.app.repositories.VolanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

        Proveedor proveedor = proveedorRepository.findByNumIdentificacion(numIdentificacion).block();
        productos.stream().map(producto ->
            productoService.actualizarProducto(producto.getId(), producto)
        );

        Volante volante = new Volante(LocalDate.now(),proveedor,productos);


        return volanteRepository.save(volante);
    }
}
