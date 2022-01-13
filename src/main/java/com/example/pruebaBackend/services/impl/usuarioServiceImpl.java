package com.example.pruebaBackend.services.impl;

import com.example.pruebaBackend.Dto.LoginDTO;
import com.example.pruebaBackend.models.UsuarioModel;
import com.example.pruebaBackend.repository.usuarioRepository;
import com.example.pruebaBackend.services.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

@Service
public class usuarioServiceImpl implements usuarioService {

    @Autowired
    usuarioRepository usuarioRepository;

    @Override
    public Long save(UsuarioModel usuarioModel) {
        return this.usuarioRepository.save(usuarioModel).getId();
    }

    @Override
    public List<UsuarioModel> getUsuarios() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public UsuarioModel getUsuarioPorId(Long id) {
        return this.usuarioRepository.findById(id).get();
    }

    @Override
    public Integer login(LoginDTO login) {
        // TODO Auto-generated method stub
        Integer valido=0;
        String password="";
        password=this.usuarioRepository.getPassword(login.getIdUsuario());


        String passInput=this.getEncryptedPassword(login.getPassword());
        if(passInput.equals(password)) {
            valido=1;
        }else {
            valido=0;
        }

        return valido;
    }

    public String getEncryptedPassword(String password) {
        return DigestUtils.sha512Hex(DigestUtils.sha256Hex(password));
    }
}
