package co.com.donraul.app.controllers;

import co.com.donraul.app.models.Vendedor;
import co.com.donraul.app.services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:3000")
public class VendedorController {

    @Autowired
    VendedorService vendedorService;

    @PostMapping("/vendedor")
    private Mono<Vendedor> agregar(@RequestBody Vendedor vendedor) {
        return vendedorService.agregarVendedor(vendedor);
    }

    @PutMapping("/vendedor/")
    private Mono<Vendedor> actualizar(@RequestParam("id") String id, @RequestBody Vendedor vendedor) {
        return vendedorService.actualizarVendedor(id, vendedor);
    }

    @DeleteMapping("/vendedor/")
    private Mono<Vendedor> eliminar(@RequestParam("id") String id) {
        return vendedorService.eliminarVendedor(id);
    }

    @GetMapping("/vendedores")
    private Flux<Vendedor> buscarTodo() {
        return vendedorService.buscarVendedores();
    }

    @GetMapping("/vendedor/")
    private Mono<Vendedor> buscar(@RequestParam("numIdentificacion") String numIdentificacion) {
        return vendedorService.buscarVendedorPorNumIdentificacion(numIdentificacion);
    }

    @GetMapping("/vendedor/nombre/")
    private Flux<Vendedor> buscarPorNombre(@RequestParam("nombre") String nombre) {
        return vendedorService.buscarVendedorPorNombre(nombre);
    }
}
