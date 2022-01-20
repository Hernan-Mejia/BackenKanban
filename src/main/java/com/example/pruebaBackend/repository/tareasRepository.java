package com.example.pruebaBackend.repository;

import com.example.pruebaBackend.models.TareasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface tareasRepository extends JpaRepository<TareasModel, Long> {
    List<TareasModel> findAllById(Long idUsuario);
}
