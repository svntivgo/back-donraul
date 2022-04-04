package co.com.donraul.app.controllers;

import co.com.donraul.app.models.Producto;
import co.com.donraul.app.models.Volante;
import co.com.donraul.app.services.VolanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class VolanteController {

    @Autowired
    VolanteService volanteService;

    @PostMapping("/volante/")
    private Mono<Volante> agregar (@RequestParam("numIdentificacion") String numIdentificacion, @RequestBody List<Producto> productos) {
        return volanteService.agregarVolante(numIdentificacion,productos);
    }

    @GetMapping("/volante/")
    private Mono<Volante> buscarPorId (@RequestParam("id") String id) {
        return volanteService.buscarVolantePorId(id);
    }

    @GetMapping("/volantes")
    private Flux<Volante> buscarTodo () {
        return volanteService.buscarVolantes();
    }
}
