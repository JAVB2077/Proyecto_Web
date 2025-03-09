package com.proyect.ptics.reporte;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ReporteRepository extends CrudRepository<Reporte, Long> {
}
