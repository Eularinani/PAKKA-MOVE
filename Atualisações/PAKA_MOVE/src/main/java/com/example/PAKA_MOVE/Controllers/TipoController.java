package com.example.PAKA_MOVE.Controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.PAKA_MOVE.models.exceptions.NotFoundException;
import com.example.PAKA_MOVE.Repository.TipoMacRepository;
import com.example.PAKA_MOVE.models.TipoMac;
import com.example.PAKA_MOVE.models.Views.TipoMacViews;

@RestController
@RequestMapping(path = "/api/tipomac") 
public class TipoController {

    //o codigo abaixodevolve um grupo de coisa
    private Logger logger = LoggerFactory.getLogger(TipoController.class);
    @Autowired
    
    private TipoMacRepository TipoMacRepository;
    
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) public Iterable<TipoMac> getTipoMac() {
    logger.info("Sending all tipo mac");
    return TipoMacRepository.findAll(); }


     //O codigo abaixo é para procurar uma unica coisa
     @GetMapping(path = "/{id:[0-9]+}", produces=MediaType.APPLICATION_JSON_VALUE)
     public TipoMac getTipoMac(@PathVariable int id) {
     logger.info("Sending Local with id " + id); 
     Optional<TipoMac> TipoMac = TipoMacRepository.findById(id); 
     if 
     (TipoMac.isEmpty())throw new NotFoundException("" + id, "tipo_mac", "id");
     else return TipoMac.get(); }

      //O codigo abaixo é para procurar uma unica coisa
      @GetMapping(path = "/{nome}", produces=MediaType.APPLICATION_JSON_VALUE)
      public Iterable<TipoMac> getTipoMac(@PathVariable(value = "nome")  String nome) {
      logger.info("Sending Tipo de Maquina with nome " + nome); 
      Iterable<TipoMac> _tipomac = TipoMacRepository.tipomac(nome); 
      if(_tipomac==null) throw new NotFoundException(nome, nome, nome);
      else return _tipomac;}

       //O codigo abaixo é para procurar uma unica coisa
       @GetMapping(path = "/{nome}/", produces=MediaType.APPLICATION_JSON_VALUE)
       public Iterable<TipoMacViews> getTipoMacViews(@PathVariable(value = "nome")  String nome) {
       logger.info("Sending Tipo de Maquina with nome " + nome); 
       Iterable<TipoMacViews> _tiponome = TipoMacRepository.tiponome(nome); 
       if(_tiponome==null) throw new NotFoundException(nome, nome, nome);
       else return _tiponome;}

     // @GetMapping(path = "/{nome:[^0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE)
      //public Iterable<TipoMac> gettipomac(@PathVariable(value = "nome") String nome) {
      //    logger.info("Unit with name like " + nome);
        //  return TipoMacRepository.tipomac(nome);
     // }
      
}
