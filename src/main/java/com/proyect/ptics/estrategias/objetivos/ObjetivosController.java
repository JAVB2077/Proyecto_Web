package com.proyect.ptics.estrategias.objetivos;
import com.proyect.ptics.actividad.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;
@RestController
@RequestMapping("/objetivos")
public class ObjetivosController {
    @Autowired
    ObjetivosRepository objetivosRepository;
    @Autowired
    private ActividadRepository actividadRepository;
    @GetMapping()
    public ResponseEntity<Iterable<Objetivos>> findObjetivos(){return ResponseEntity.ok(objetivosRepository.findAll());}

    @GetMapping("/{idObjetivos}")
    public ResponseEntity<Objetivos> findById(@PathVariable Long idObjetivos){
        Optional<Objetivos> ObjetivosOptional = objetivosRepository.findById(idObjetivos);
        if(ObjetivosOptional.isPresent()){return ResponseEntity.ok(ObjetivosOptional.get());}
        else{return ResponseEntity.notFound().build();}
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Objetivos newObjetivos, UriComponentsBuilder ucb){
        Objetivos savedObjetivos = objetivosRepository.save(newObjetivos);
        URI uri =ucb
                .path("/objetivos/{idObjetivos}")
                .buildAndExpand(savedObjetivos.getIdObjetivos())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{idObjetivos}")
    public ResponseEntity<Void> Update(@PathVariable Long idObjetivos, @RequestBody Objetivos objetivosAct){
        Objetivos objetivosAnt = objetivosRepository.findById(idObjetivos).get();
        if(objetivosAnt != null){
            objetivosAct.setIdObjetivos(objetivosAnt.getIdObjetivos());
            objetivosRepository.save(objetivosAct);
            return ResponseEntity.noContent().build();
        }
        else {return ResponseEntity.notFound().build();}
    }

    @DeleteMapping("/{idObjetivos}")
    public ResponseEntity<Void> delete(@PathVariable Long idObjetivos){
        if(objetivosRepository.findById(idObjetivos).get() != null){
            objetivosRepository.deleteById(idObjetivos);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
