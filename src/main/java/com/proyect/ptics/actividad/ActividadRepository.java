package com.proyect.ptics.actividad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ActividadRepository extends CrudRepository<Actividad, Long> {
}
