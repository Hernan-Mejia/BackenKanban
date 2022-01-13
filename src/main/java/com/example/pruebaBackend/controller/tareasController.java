package com.example.pruebaBackend.controller;

import com.example.pruebaBackend.models.TareasModel;
import com.example.pruebaBackend.models.UsuarioModel;
import com.example.pruebaBackend.services.tareasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/tareas")
@RestController
public class tareasController {

    @Autowired
    tareasService tareasService;

    @PostMapping(value="/", consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> registrar(@RequestBody TareasModel tareasModel) {
        long resultado=0;
        try {
            resultado =tareasService.save(tareasModel);
        } catch (Exception e) {

            return new ResponseEntity<>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }


    @GetMapping(value = "/listado/{idUsuario}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TareasModel> getTareasPorUsuario(@PathVariable("idUsuario") long idUsuario) {
        List<TareasModel> listTareasModel = new ArrayList<>();
        try {
            listTareasModel = this.tareasService.getTareasPorUsuario(idUsuario);

        } catch (Exception e) {
            return new ResponseEntity<TareasModel>((TareasModel) listTareasModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<TareasModel>((TareasModel) listTareasModel, HttpStatus.OK);
    }


}
