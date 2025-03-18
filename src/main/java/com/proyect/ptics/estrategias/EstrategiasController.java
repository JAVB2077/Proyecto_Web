package com.proyect.ptics.estrategias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;
@RestController
@RequestMapping("/estrategias")
public class EstrategiasController {
    @Autowired
    EstrategiasRepository estrategiasRepository;
    @GetMapping()
    public ResponseEntity<Iterable<Estrategias>> findAll(){return ResponseEntity.ok(estrategiasRepository.findAll());}

    @GetMapping("/{idEstrategias}")
    public ResponseEntity<Estrategias> findById(@PathVariable Long idEstrategias){
        Optional <Estrategias> EstrategiasOptional = estrategiasRepository.findById(idEstrategias);
        if (EstrategiasOptional.isPresent()) {return ResponseEntity.ok(EstrategiasOptional.get());}
        else {return ResponseEntity.notFound().build();}
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Estrategias newEstrategias,UriComponentsBuilder ucb){
        Estrategias savedEstrategias = estrategiasRepository.save(new Estrategias());
        URI uri =ucb
                .path("estrategias/{idEstrategias}")
                .buildAndExpand(savedEstrategias.getIdEstrategias())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping("/{idEstrategias}")
    public ResponseEntity<Void> update(@PathVariable Long idEstrategias, @RequestBody Estrategias estrategiasAct){
        Estrategias estrategiasAnt = estrategiasRepository.findById(idEstrategias).get();
        if (estrategiasAnt!=null) {
            estrategiasAct.setIdEstrategias(estrategiasAnt.getIdEstrategias());
            estrategiasRepository.save(estrategiasAnt);
            return ResponseEntity.noContent().build();
        }else {return ResponseEntity.notFound().build();}
    }
    @DeleteMapping("/{idEstrategias}")
    public ResponseEntity<Void> delete(@PathVariable Long idEstrategias){
        if (estrategiasRepository.findById(idEstrategias).get() != null) {
            estrategiasRepository.deleteById(idEstrategias);
            return ResponseEntity.noContent().build();
        }return ResponseEntity.notFound().build();
    }
}
