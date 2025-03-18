package com.proyect.ptics.unidadResponsable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;
@RestController
@RequestMapping("/unidad-responsable")
public class UnidadResponsableController {
    @Autowired
    UnidadResponsableRepository unidadResponsableRepository;
    @GetMapping()
    public ResponseEntity<Iterable<UnidadResponsable>> findAll() {return ResponseEntity.ok(unidadResponsableRepository.findAll());}

    @GetMapping("/{idUnidadResponsable}")
    public ResponseEntity<UnidadResponsable> findById(@PathVariable Long idUnidadResponsable) {
        Optional<UnidadResponsable> UnidadResponsableOptional = unidadResponsableRepository.findById(idUnidadResponsable);
        if (UnidadResponsableOptional.isPresent()) {return ResponseEntity.ok(UnidadResponsableOptional.get());}
        else {return ResponseEntity.notFound().build();}
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UnidadResponsable newUnidadResponsable, UriComponentsBuilder ucb) {
        UnidadResponsable savedUnidadResponsable = unidadResponsableRepository.save(newUnidadResponsable);
        URI uri =ucb
                .path("unidad-responsable/{idUnidadResponsable}")
                .buildAndExpand(savedUnidadResponsable.getIdUnidadResponsable())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{idUnidadResponsable}")
    public ResponseEntity<Void> update(@PathVariable Long idUnidadResponsable, @RequestBody UnidadResponsable unidadResponsableAct) {
        UnidadResponsable unidadResponsableAnt = unidadResponsableRepository.findById(idUnidadResponsable).get();
        if (unidadResponsableAnt != null) {
            unidadResponsableAct.setIdUnidadResponsable(unidadResponsableAnt.getIdUnidadResponsable());
            unidadResponsableRepository.save(unidadResponsableAnt);
            return ResponseEntity.ok().build();
        }
        else {return ResponseEntity.notFound().build();}
    }

    @DeleteMapping("/{idUnidadResponsable}")
    public ResponseEntity<Void> delete(@PathVariable Long idUnidadResponsable) {
        if (unidadResponsableRepository.findById(idUnidadResponsable).get() != null) {
            unidadResponsableRepository.deleteById(idUnidadResponsable);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
