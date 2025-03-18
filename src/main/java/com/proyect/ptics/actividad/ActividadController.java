package com.proyect.ptics.actividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
    import java.net.URI;
    import java.util.Optional;
@RestController
@RequestMapping("/actividad")
public class ActividadController {
    @Autowired
    ActividadRepository actividadRepository;
    @GetMapping()
    public ResponseEntity<Iterable<Actividad>> findAll() {
        return ResponseEntity.ok(actividadRepository.findAll());
    }

    @GetMapping("/{idActividad}")
    public ResponseEntity<Actividad> findById(@PathVariable Long idActividad) {
        Optional<Actividad> ActividadOptional = actividadRepository.findById(idActividad);
        if (ActividadOptional.isPresent()) {return ResponseEntity.ok(ActividadOptional.get());}
        else {return ResponseEntity.notFound().build();}
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Actividad newActividad, UriComponentsBuilder ucb) {
        Actividad savedActividad = actividadRepository.save(newActividad);
        URI uri =ucb
                .path("actividad/{IdActividad}")
                .buildAndExpand(savedActividad.getIdActividad())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{idActividad}")
    public ResponseEntity<Void> update(@PathVariable Long idActividad, @RequestBody Actividad actividadAct) {
        Actividad actividadAnt = actividadRepository.findById(idActividad).get();
        if (actividadAnt != null) {
            actividadAct.setIdActividad(actividadAnt.getIdActividad());
            actividadRepository.save(actividadAct);
            return ResponseEntity.noContent().build();
        }
        else{return ResponseEntity.notFound().build();}
    }

    @DeleteMapping("/{idActividad}")
    public ResponseEntity<Void> delete(@PathVariable Long idActividad) {
        if (actividadRepository.findById(idActividad).get() != null) {
            actividadRepository.deleteById(idActividad);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
