package com.example.PAKA_MOVE.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PAKA_MOVE.Repository.ServicosRepository;
import com.example.PAKA_MOVE.models.Servico;

@RestController
@RequestMapping(path = "/api/servicos")
public class ServicosControllers {
  private Logger logger = LoggerFactory.getLogger(ServicosControllers.class);
   @Autowired
  private ServicosRepository ServicosRepository;

  // o codigo abaixo é para guardar um local
   @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Servico saveServico(@RequestBody Servico servico) {
      Servico savedServico = ServicosRepository.save(servico);
      logger.info("Saving serviÇo with id " + savedServico.getId());
      return savedServico;}

      //o codigo abaixo e só para devolver todos uos serviços
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
     public Iterable<Servico> getservicos() {
      logger.info("Sending all Local");
      return ServicosRepository.findAll(); }
 
}
