package com.proyect.ptics.unidadResponsable.jefesUnidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;
@RestController
@RequestMapping("/jefes-unidad")
public class JefesUnidadController {
    @Autowired
    JefesUnidadRepository jefesUnidadRepository;
    @GetMapping()
    public ResponseEntity<Iterable<JefesUnidad>> findAll() {return ResponseEntity.ok(jefesUnidadRepository.findAll());}
    @GetMapping("/{idJefesUnidad}")
    public ResponseEntity<JefesUnidad> findById(@PathVariable Long idJefesUnidad) {
        Optional<JefesUnidad> JefesUnidadOptional = jefesUnidadRepository.findById(idJefesUnidad);
        if (JefesUnidadOptional.isPresent()) {return ResponseEntity.ok(JefesUnidadOptional.get());}
        else {return ResponseEntity.notFound().build();}
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody JefesUnidad newJefesUnidad, UriComponentsBuilder ucb) {
        JefesUnidad savedJefesUnidad = jefesUnidadRepository.save(newJefesUnidad);
        URI uri =ucb
                .path("jefes-unidad/{idJefesUnidad}")
                .buildAndExpand(savedJefesUnidad.getIdJefesUnidad())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{idJefesUnidad}")
    public ResponseEntity<Void> update(@PathVariable Long idJefesUnidad, @RequestBody JefesUnidad jefesUnidadAct) {
        JefesUnidad jefesUnidadAnt = jefesUnidadRepository.findById(idJefesUnidad).get();
        if (jefesUnidadAnt != null) {
            jefesUnidadAct.setIdJefesUnidad(jefesUnidadAnt.getIdJefesUnidad());
            jefesUnidadRepository.save(jefesUnidadAnt);
            return ResponseEntity.ok().build();
        }
        else {return ResponseEntity.notFound().build();}
    }
    @DeleteMapping("/{idJefesUnidad}")
    public ResponseEntity<Void> delete(@PathVariable Long idJefesUnidad) {
        if (jefesUnidadRepository.findById(idJefesUnidad).get() != null) {
            jefesUnidadRepository.deleteById(idJefesUnidad);
            return ResponseEntity.noContent().build();
        }return ResponseEntity.notFound().build();
    }
}
