package com.example.pruebaBackend.services;

import com.example.pruebaBackend.Dto.LoginDTO;
import com.example.pruebaBackend.models.UsuarioModel;


import java.util.List;

public interface usuarioService {

    Long save (UsuarioModel usuarioModel);

    List<UsuarioModel> getUsuarios();

    UsuarioModel getUsuarioPorId(Long id);

    Integer login(LoginDTO login);


}
