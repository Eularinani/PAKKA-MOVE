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


import com.example.PAKA_MOVE.Repository.LocalRepository;
import com.example.PAKA_MOVE.models.Local;
import com.example.PAKA_MOVE.models.exceptions.NotFoundException;
    @RestController
    @RequestMapping(path = "/api/local") 
    public class LocalController {
    private Logger logger = LoggerFactory.getLogger(LocalController.class); 
    @Autowired
    private LocalRepository LocalRepository;
    //o codigo abaixo e só para devolver um grupo de coisa
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) public Iterable<Local> getLocal() {
    logger.info("Sending all Local");
    return LocalRepository.findAll(); }
         
    //O codigo abaixo é para procurar uma unica coisa
    @GetMapping(path = "/{id:[0-9]+}", produces=MediaType.APPLICATION_JSON_VALUE)
    public Local getlLocal(@PathVariable int id) {
    logger.info("Sending Local with id " + id); 
    Optional<Local> Local = LocalRepository.findById(id); 
    if 
    (Local.isEmpty())throw new NotFoundException("" + id, "Local", "id");
    else return Local.get(); }

    
        //o codigo abaixo é para guardar um local
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Local saveLocal(@RequestBody Local local) {
        Local savedLocal = LocalRepository.save(local); 
        logger.info("Saving Serviço with id " + savedLocal.getId()); 
        return savedLocal;
        }


        /*@DeleteMapping(path = "/{id:[0-9]+}", produces = MediaType.APPLICATION_JSON_VALUE) 
            //public Local deleteLocal(@PathVariable int id) { 
                Local DeleteLocal = LocalRepository.delete(); 
                logger.info("Deleting unit with id " + id); 
                // No verification to see if it exists 
                LocalRepository.deleteById(id); 
                return ("Deleted unit with id " + Local,null); 
            } 

     @DeleteMapping(path = "/delete/{use_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteLocal(@PathVariable int id){
        Local deletedlLocal = LocalRepository.findById(id).get();
        LocalRepository.delete(deleteLocal());
        return "Deleted unit with id " + id;
        }*/
    }
    