package com.projeto.confeitart.demo.services;



import com.projeto.confeitart.demo.model.Usuario;
import com.projeto.confeitart.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public abstract class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public  Usuario findById(Long id){
        Optional<Usuario> obj = usuarioRepository.findById(id);
        return obj.get();
    }
   public abstract void alterarSenha(long id , int novaSenha);


}
