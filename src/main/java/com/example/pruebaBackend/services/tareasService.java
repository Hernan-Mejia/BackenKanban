package com.example.pruebaBackend.services;

import com.example.pruebaBackend.models.TareasModel;
import com.example.pruebaBackend.models.UsuarioModel;

import java.util.List;

public interface tareasService {

    Long save (TareasModel tareasModel);

    List<TareasModel> getTareasPorUsuario(Long idUsuario);

}
