package com.proyect.ptics.notificacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface NotificacionRepository extends CrudRepository<Notificacion, Long> {
}
