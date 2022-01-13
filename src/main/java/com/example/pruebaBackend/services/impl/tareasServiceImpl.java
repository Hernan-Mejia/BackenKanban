package com.example.pruebaBackend.services.impl;

import com.example.pruebaBackend.models.TareasModel;
import com.example.pruebaBackend.repository.tareasRepository;
import com.example.pruebaBackend.services.tareasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class tareasServiceImpl implements tareasService {

    @Autowired
    tareasRepository tareasRepository;

    @Override
    public Long save(TareasModel tareasModel) {
        return this.tareasRepository.save(tareasModel).getId();
    }

    @Override
    public List<TareasModel> getTareasPorUsuario(Long idUsuario) {
        return this.tareasRepository.findAllById(idUsuario);
    }
}
