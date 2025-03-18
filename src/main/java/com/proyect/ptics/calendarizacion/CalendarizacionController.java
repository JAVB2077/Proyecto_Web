package com.proyect.ptics.calendarizacion;
import com.proyect.ptics.calendarizacion.Calendarizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;
@RestController
@RequestMapping("/calendarizacion")
public class CalendarizacionController {
    @Autowired
    CalendarizacionRepository calendarizacionRepository;
    @GetMapping()
    public ResponseEntity<Iterable<Calendarizacion>> findAll() {return ResponseEntity.ok(calendarizacionRepository.findAll());}
    
    @GetMapping("/{idCalendarizacion}")
    public ResponseEntity<Calendarizacion> findById(@PathVariable Long idCalendarizacion) {
        Optional<Calendarizacion> CalendarizacionOptional = calendarizacionRepository.findById(idCalendarizacion);
        if (CalendarizacionOptional.isPresent()) {return ResponseEntity.ok(CalendarizacionOptional.get());}
        else {return ResponseEntity.notFound().build();}
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Calendarizacion newCalendarizacion, UriComponentsBuilder ucb) {
        Calendarizacion savedCalendarizacion = calendarizacionRepository.save(newCalendarizacion);
        URI uri =ucb
                .path("calendarizacion/{IdCalendarizacion}")
                .buildAndExpand(savedCalendarizacion.getIdCalendarizacion())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{idCalendarizacion}")
    public ResponseEntity<Void> update(@PathVariable Long idCalendarizacion, @RequestBody Calendarizacion calendarizacionAct) {
        Calendarizacion calendarizacionAnt = calendarizacionRepository.findById(idCalendarizacion).get();
        if (calendarizacionAnt != null) {
            calendarizacionAct.setIdCalendarizacion(calendarizacionAnt.getIdCalendarizacion());
            calendarizacionRepository.save(calendarizacionAct);
            return ResponseEntity.noContent().build();
        }
        else{return ResponseEntity.notFound().build();}
    }

    @DeleteMapping("/{idCalendarizacion}")
    public ResponseEntity<Void> delete(@PathVariable Long idCalendarizacion) {
        if (calendarizacionRepository.findById(idCalendarizacion).get() != null) {
            calendarizacionRepository.deleteById(idCalendarizacion);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
