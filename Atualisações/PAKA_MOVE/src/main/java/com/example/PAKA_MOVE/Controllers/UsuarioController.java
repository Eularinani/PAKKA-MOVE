package com.example.PAKA_MOVE.Controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PAKA_MOVE.models.Usuario;
import com.example.PAKA_MOVE.models.exceptions.NotFoundException;


import com.example.PAKA_MOVE.Repository.UsuarioRepository;
@RestController
@RequestMapping(path = "/api/usuarios") 
public class UsuarioController {

    //o codigo abaixodevolve um grupo de coisa
private Logger logger = LoggerFactory.getLogger(UsuarioController.class);
@Autowired
private UsuarioRepository UsuarioRepository;


@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
public Usuario saveUsm(@RequestBody Usuario Usuario ) {
  Usuario savedUsuario = UsuarioRepository.save(Usuario);
  logger.info("Saving estado with id " + savedUsuario.getId());
  return savedUsuario;}


       //O codigo abaixo é para procurar uma unica coisa
       @GetMapping(path = "/{id:[0-9]+}", produces=MediaType.APPLICATION_JSON_VALUE)
       public Usuario getuUsuario(@PathVariable int id) {
       logger.info("Sending Usuario with id " + id); 
       Optional<Usuario> Usuario = UsuarioRepository.findById(id); 
       if 
       (Usuario.isEmpty())throw new NotFoundException("" + id, "Usuario", "id");
       else return Usuario.get(); }



}
