package com.tarea1.tarea1.Repository;

import com.tarea1.tarea1.Model.Encuesta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EncuestaRepository extends JpaRepository<Encuesta, Long> {
  List<Encuesta> findByNivelSatisfaccion(String nivelSatisfaccion);

}
