package com.proyect.ptics.usuario.rol;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RolRepository extends CrudRepository<Rol, Long> {
}
