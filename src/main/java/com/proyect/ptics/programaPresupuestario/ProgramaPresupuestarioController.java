package com.proyect.ptics.programaPresupuestario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;
@RestController
@RequestMapping("/programa-presupuestario")
public class ProgramaPresupuestarioController {
    @Autowired
    ProgramaPresupuestarioRepository programaPresupuestarioRepository;
    @GetMapping
    public ResponseEntity<Iterable<ProgramaPresupuestario>> findAll() {return ResponseEntity.ok(programaPresupuestarioRepository.findAll());}

    @GetMapping("/{idProgramaPresupuestario}")
    public ResponseEntity<ProgramaPresupuestario> findById(@PathVariable Long idProgramaPresupuestario) {
        Optional<ProgramaPresupuestario> ProgramaPresupuestarioOptional =programaPresupuestarioRepository.findById(idProgramaPresupuestario);
        if (ProgramaPresupuestarioOptional.isPresent()) {return ResponseEntity.ok(ProgramaPresupuestarioOptional.get());}
        else {return ResponseEntity.notFound().build();}
    }
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ProgramaPresupuestario newProgramaPresupuestario,UriComponentsBuilder ucb) {
        ProgramaPresupuestario savedProgramaPresupuestario = programaPresupuestarioRepository.save(newProgramaPresupuestario);
        URI uri =ucb
                .path("programa-presupuestario/{idProgramaPresupuestario}")
                .buildAndExpand(savedProgramaPresupuestario.getIdProgramaPresupuestario())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{idProgramaPresupuestario}")
    public ResponseEntity<Void> update(@PathVariable Long idProgramaPresupuestario, @RequestBody ProgramaPresupuestario programaPresupuestarioAct) {
        ProgramaPresupuestario programaPresupuestarioAnt = programaPresupuestarioRepository.findById(idProgramaPresupuestario).get();
        if (programaPresupuestarioAnt != null) {
            programaPresupuestarioAct.setIdProgramaPresupuestario(programaPresupuestarioAnt.getIdProgramaPresupuestario());
            programaPresupuestarioRepository.save(programaPresupuestarioAct);
            return ResponseEntity.ok().build();
        }else {return ResponseEntity.notFound().build();}
    }
    @DeleteMapping("/{idProgramaPresupuestario}")
    public ResponseEntity<Void> delete(@PathVariable Long idProgramaPresupuestario) {
        if (programaPresupuestarioRepository.findById(idProgramaPresupuestario).get() != null) {
            programaPresupuestarioRepository.deleteById(idProgramaPresupuestario);
            return ResponseEntity.ok().build();
        }return ResponseEntity.notFound().build();
    }
}

