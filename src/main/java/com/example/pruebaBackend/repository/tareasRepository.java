package com.example.pruebaBackend.repository;

import com.example.pruebaBackend.models.TareasModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface tareasRepository extends JpaRepository<TareasModel, Long> {
    List<TareasModel> findAllById(Long idUsuario);
}
