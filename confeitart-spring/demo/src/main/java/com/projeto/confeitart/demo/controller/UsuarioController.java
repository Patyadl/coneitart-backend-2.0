package com.projeto.confeitart.demo.controller;

import com.projeto.confeitart.demo.model.Usuario;
import com.projeto.confeitart.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/usuario")
public class UsuarioController {

    @Autowired
private UsuarioService usuarioService;

    @GetMapping
    public  ResponseEntity<List<Usuario>> findAll() {
    List<Usuario> list = usuarioService.findAll();
    return ResponseEntity.ok().body(list);
    }
}
