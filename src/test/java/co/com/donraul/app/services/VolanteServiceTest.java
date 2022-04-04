package co.com.donraul.app.services;

import co.com.donraul.app.models.Producto;
import co.com.donraul.app.models.Proveedor;
import co.com.donraul.app.models.Volante;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VolanteServiceTest {

    @Autowired
    VolanteService volanteService;

    List<Producto> productos = new ArrayList<>();

    Producto producto = new Producto("1","producto",10,2,1,10,"NORMAL");

    Proveedor proveedor = new Proveedor("Camilo","3105263147","3456852");

    Volante volante = new Volante(LocalDate.now(),proveedor,productos);

    @Test
    void agregarVolante() {
        productos.add(producto);

        Mono<Volante> volanteAgregado = volanteService.agregarVolante(proveedor.getId(),productos);
        StepVerifier.create(volanteAgregado).expectNextMatches(response -> volante.getClass().equals(response.getClass())).thenCancel().verify();
    }

    @Test
    void buscarVolantes() {
        Flux<Volante> volanteBuscado = volanteService.buscarVolantes();
        StepVerifier.create(volanteBuscado).expectNextMatches(response -> volante.getClass().equals(response.getClass())).thenCancel().verify();
    }
}