package com.proyect.ptics.medioVerificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;
@RestController
@RequestMapping("/medio-verificacion")
public class MedioVerificacionController {
    @Autowired
    MedioVerificacionRepository medioVerificacionRepository;
    @GetMapping()
    public ResponseEntity<Iterable<MedioVerificacion>> findAll() {return ResponseEntity.ok(medioVerificacionRepository.findAll());}

    @GetMapping("/{idMedioVerificacion}")
    public ResponseEntity<Optional<MedioVerificacion>> findById(@PathVariable Long idMedioVerificacion) {
        Optional<MedioVerificacion> MedioVerificacionOptional = medioVerificacionRepository.findById(idMedioVerificacion);
        if (MedioVerificacionOptional.isPresent()) {return ResponseEntity.ok(MedioVerificacionOptional);}
        else {return ResponseEntity.notFound().build();}
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody MedioVerificacion newMedioVerificacion,UriComponentsBuilder ucb) {
        MedioVerificacion savedMedioVerificacion = medioVerificacionRepository.save(newMedioVerificacion);
        URI uri =ucb
                .path("medio-verificacion/{idMedioVerificacion}")
                .buildAndExpand(savedMedioVerificacion.getIdMedioVerificacion())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping("/{idMedioVerificacion}")
    public ResponseEntity<Void> update(@PathVariable Long idMedioVerificacion, @RequestBody MedioVerificacion medioVerificacionAct) {
        MedioVerificacion medioVerificacionAnt = medioVerificacionRepository.findById(idMedioVerificacion).get();
        if (medioVerificacionAnt != null) {
            medioVerificacionAct.setIdMedioVerificacion(idMedioVerificacion);
            medioVerificacionRepository.save(medioVerificacionAct);
            return ResponseEntity.ok().build();
        }else {return ResponseEntity.notFound().build();}
    }

    @DeleteMapping("/{idMedioVerificacion}")
    public ResponseEntity<Void> delete(@PathVariable Long idMedioVerificacion) {
        if (medioVerificacionRepository.findById(idMedioVerificacion).get() != null) {
            medioVerificacionRepository.deleteById(idMedioVerificacion);
            return ResponseEntity.ok().build();
        }return ResponseEntity.notFound().build();
    }
}
