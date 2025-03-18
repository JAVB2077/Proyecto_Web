package com.proyect.ptics.unidadMedida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;
@RestController
@RequestMapping("/unidad-medida")
public class UnidadMedidaController {
    @Autowired
    UnidadMedidaRepository unidadMedidaRepository;
    @GetMapping()
    public ResponseEntity<Iterable<UnidadMedida>> findAll(){return ResponseEntity.ok(unidadMedidaRepository.findAll());}

    @GetMapping("/idUnidadMedida")
    public ResponseEntity<UnidadMedida> finById(@PathVariable Long idUnidadMedida){
        Optional<UnidadMedida> UnidadMedidaOptional = unidadMedidaRepository.findById(idUnidadMedida);
        if (UnidadMedidaOptional.isPresent()){return ResponseEntity.ok(UnidadMedidaOptional.get());}
        else{return ResponseEntity.notFound().build();}
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UnidadMedida newUnidadMedida, UriComponentsBuilder ucb){
        UnidadMedida savedUnidadMedida = unidadMedidaRepository.save(newUnidadMedida);
        URI uri =ucb
                .path("unidad-medida/{idUnidadMedida}")
                .buildAndExpand(savedUnidadMedida.getIdUnidadMedida())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping("/{idUnidadMedida}")
    public ResponseEntity<Void> update(@PathVariable Long idUnidadMedida, @RequestBody UnidadMedida unidadMedidaAct){
        UnidadMedida unidadMedidaAnt = unidadMedidaRepository.findById(idUnidadMedida).get();
        if (unidadMedidaAnt != null){
            unidadMedidaAct.setIdUnidadMedida(unidadMedidaAnt.getIdUnidadMedida());
            unidadMedidaRepository.save(unidadMedidaAct);
            return ResponseEntity.noContent().build();
        }else{return ResponseEntity.notFound().build();}
    }

    @DeleteMapping("/{idUnidadMedida}")
    public ResponseEntity<Void> delete(@PathVariable Long idUnidadMedida){
        if (unidadMedidaRepository.findById(idUnidadMedida).get() != null){
            unidadMedidaRepository.deleteById(idUnidadMedida);
            return ResponseEntity.noContent().build();
        }return ResponseEntity.notFound().build();
    }

}
