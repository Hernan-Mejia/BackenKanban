package com.example.pruebaBackend.repository;

import com.example.pruebaBackend.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface usuarioRepository extends JpaRepository<UsuarioModel,Long> {

    @Query(value="select cast(usuario.pass as varchar(200)) clave from usuario where id=:idUsuario ",nativeQuery=true)
    String getPassword(@Param("idUsuario")Integer idUsuario);
}
