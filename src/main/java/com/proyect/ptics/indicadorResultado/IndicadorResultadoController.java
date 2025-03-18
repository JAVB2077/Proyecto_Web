package com.proyect.ptics.indicadorResultado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/indicador-resultado")
public class IndicadorResultadoController {
    @Autowired
    IndicadorResultadoRepository indicadorResultadoRepository;
    @GetMapping
    public ResponseEntity<Iterable<IndicadorResultado>> findAll() {return ResponseEntity.ok(indicadorResultadoRepository.findAll());}

    @GetMapping("/{idIndicadorResultado}")
    public ResponseEntity<IndicadorResultado> findById(@PathVariable Long idIndicadorResultado) {
        Optional<IndicadorResultado> IndicadorResultadoOpptional = indicadorResultadoRepository.findById(idIndicadorResultado);
        if (IndicadorResultadoOpptional.isPresent()) {return ResponseEntity.ok(IndicadorResultadoOpptional.get());}
        else {return ResponseEntity.notFound().build();}
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody IndicadorResultado newIndicadorResultado, UriComponentsBuilder ucb) {
        IndicadorResultado savedIndicadorResultado = indicadorResultadoRepository.save(newIndicadorResultado);
        URI uri =ucb
                .path("indicador-resultado/{idIndicadorResultado")
                .buildAndExpand(savedIndicadorResultado.getIdIndicadorResultado())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/{idIndicadorResultado")
    public ResponseEntity<Void> update(@PathVariable Long idIndicadorResultado, @RequestBody IndicadorResultado indicadorResultadoAct) {
        IndicadorResultado indicadorResultadoAnt = indicadorResultadoRepository.findById(idIndicadorResultado).get();
        if (indicadorResultadoAnt != null) {
            indicadorResultadoAct.setIdIndicadorResultado(idIndicadorResultado);
            indicadorResultadoRepository.save(indicadorResultadoAct);
            return ResponseEntity.ok().build();
        }else {return ResponseEntity.notFound().build();}
    }

    @DeleteMapping("/{idIndicadorResultado}")
    public ResponseEntity<Void> delete(@PathVariable Long idIndicadorResultado) {
        if (indicadorResultadoRepository.findById(idIndicadorResultado).get() != null) {
            indicadorResultadoRepository.deleteById(idIndicadorResultado);
            return ResponseEntity.ok().build();
        }return ResponseEntity.notFound().build();
    }
}
