package com.example.PAKA_MOVE.Controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.PAKA_MOVE.Repository.MaquinaRepository;
import com.example.PAKA_MOVE.models.Maquina;
import com.example.PAKA_MOVE.models.Views.MaquinaViews;
import com.example.PAKA_MOVE.models.exceptions.NotFoundException;
    @RestController
    @RequestMapping(path = "/api/maquina") 
public class MaquinaController {
    private Logger logger = LoggerFactory.getLogger(MaquinaController.class);
    @Autowired
    private MaquinaRepository MaquinaRepository;
    // o codigo abaixo é para guardar um local
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) 
    public Maquina saveMaquina(@RequestBody Maquina maquina) { 
        Maquina savedMaquina = MaquinaRepository.save(maquina); 
        logger.info("Saving unit with id " + savedMaquina.getId()); 
        return savedMaquina; 
    } 
     //o codigo abaixo e só para devolver todas as maquinas
     @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) 
     public Iterable<Maquina> getMaquina() { 
         logger.info("Sending all Maquina"); 
         return MaquinaRepository.findAll(); 
     } 

      //o codigo abaixo e só para devolver todas as maquinas
      @GetMapping(path = "/Mestados", produces = MediaType.APPLICATION_JSON_VALUE) 
      public Iterable<MaquinaViews> getMaquinaViews() { 
          logger.info("Sending all Maquina"); 
          logger.info("aqui: "+  MaquinaRepository.findAllmestados().toString());
          return MaquinaRepository.findAllmestados(); 
      } 

     

             



}
