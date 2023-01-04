package com.example.PAKA_MOVE.Controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PAKA_MOVE.models.Usm;
import com.example.PAKA_MOVE.models.exceptions.NotFoundException;
import com.example.PAKA_MOVE.Repository.UsmRepository;;

@RestController
@RequestMapping(path = "/api/usm") 
public class UsmController {

private Logger logger = LoggerFactory.getLogger(UsmController.class);
 @Autowired
    private UsmRepository UsmRepository;

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Usm saveUsm(@RequestBody Usm Usm ) {
      Usm savedUsm = UsmRepository.save(Usm);
      logger.info("Saving estado with id " + savedUsm.getId());
      return savedUsm;}

      @GetMapping(path = "/{id:[0-9]+}", produces=MediaType.APPLICATION_JSON_VALUE)
      public Usm getuUsm(@PathVariable int id) {
      logger.info("Sending estado with id " + id); 
      Optional<Usm> Usm = UsmRepository.findById(id); 
      if 
      (Usm.isEmpty())throw new NotFoundException("" + id, "USM", "id");
      else return Usm.get(); }

     /*  //o codigo abaixo e só para devolver todos uos serviços
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
     public Iterable<Servico> getservicos() {
      logger.info("Sending all Local");
      return ServicosRepository.findAll(); }*/

}
