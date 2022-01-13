package com.example.pruebaBackend.controller;

import com.example.pruebaBackend.Dto.LoginDTO;
import com.example.pruebaBackend.models.UsuarioModel;
import com.example.pruebaBackend.services.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class usuarioController {

    @Autowired
    usuarioService usuarioService;

    @PostMapping(value="/", consumes= MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> registrar(@RequestBody UsuarioModel usuario) {
        long resultado=0;
        try {
            resultado =usuarioService.save(usuario);
        } catch (Exception e) {

            return new ResponseEntity<>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @GetMapping(value = "/listado", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsuarioModel>> listarUsuarios() {
        List<UsuarioModel> lstUsuarios = new ArrayList<>();
        try {
            lstUsuarios = this.usuarioService.getUsuarios();
        } catch (Exception e) {
            return new ResponseEntity<List<UsuarioModel>>(lstUsuarios, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<UsuarioModel>>(lstUsuarios, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioModel> getUsuariosPorId(@PathVariable("id") long id) {
        UsuarioModel usuarioModel = null;
        try {
            usuarioModel = this.usuarioService.getUsuarioPorId(id);

        } catch (Exception e) {
            return new ResponseEntity<UsuarioModel>(usuarioModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<UsuarioModel>(usuarioModel, HttpStatus.OK);
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> login(@RequestBody LoginDTO login) {
        int resultado = 0;

        try {
            resultado = usuarioService.login(login);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
    }

}
