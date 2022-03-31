package co.com.donraul.app.controllers;

import co.com.donraul.app.models.Producto;
import co.com.donraul.app.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @PostMapping("/producto")
    private Mono<Producto> agregar(@RequestBody Producto producto) {
        return productoService.agregarProducto(producto);
    }

    @PutMapping("/producto/")
    private Mono<Producto> actualizar(@RequestParam("id") String id, @RequestBody Producto producto) {
        return productoService.actualizarProducto(id, producto);
    }

    @DeleteMapping("/producto/")
    private Mono<Producto> eliminar(@RequestParam("id") String id) {
        return productoService.eliminarProducto(id);
    }

    @GetMapping("/producto/")
    private Flux<Producto> buscarPorEstado(@RequestParam("estado") String estado) {
        return productoService.buscarProductoPorEstado(estado);
    }
}