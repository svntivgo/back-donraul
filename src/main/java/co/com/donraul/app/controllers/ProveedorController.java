package co.com.donraul.app.controllers;

import co.com.donraul.app.models.Proveedor;
import co.com.donraul.app.services.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://don-raul.web.app")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @PostMapping("/proveedor")
    private Mono<Proveedor> agregar(@RequestBody Proveedor proveedor) {
        return proveedorService.agregarProveedor(proveedor);
    }

    @PutMapping("/proveedor/")
    private Mono<Proveedor> actualizar(@RequestParam("id") String id, @RequestBody Proveedor proveedor) {
        return proveedorService.actualizarProveedor(id, proveedor);
    }

    @DeleteMapping("/proveedor/")
    private Mono<Proveedor> eliminar(@RequestParam("id") String id) {
        return proveedorService.eliminarProveedor(id);
    }

    @GetMapping("/proveedores")
    private Flux<Proveedor> buscarTodo() {
        return proveedorService.buscarProveedores();
    }

    @GetMapping("/proveedor/")
    private Mono<Proveedor> buscar(@RequestParam("numIdentificacion") String numIdentificacion) {
        return proveedorService.buscarProveedorPorNumIdentificacion(numIdentificacion);
    }

    @GetMapping("/proveedor/nombre/")
    private Flux<Proveedor> buscarPorNombre(@RequestParam("nombre") String nombre) {
        return proveedorService.buscarProveedorPorNombre(nombre);
    }
}
