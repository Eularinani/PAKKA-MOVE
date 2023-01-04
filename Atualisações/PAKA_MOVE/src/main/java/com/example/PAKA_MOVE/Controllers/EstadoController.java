package com.example.PAKA_MOVE.Controllers;

import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PAKA_MOVE.Repository.EstadoRepository;
import com.example.PAKA_MOVE.models.Estado;
import com.example.PAKA_MOVE.models.exceptions.NotFoundException;

@RestController
@RequestMapping(path = "/api/estados") 
public class EstadoController {

//O codigo abaixo é para procurar um grupo de coisas 
@GetMapping(path = "/{id:[0-9]+}", produces=MediaType.APPLICATION_JSON_VALUE)
public Estado getEstado(@PathVariable int id) {
logger.info("Sending Local with id " + id); 
Optional<Estado> Estado = EstadoRepository.findById(id); 
if 
(Estado.isEmpty())throw new NotFoundException("" + id, "Local", "id");
else return Estado.get(); }


//o codigo abaixo e só para devolver uma unica
private Logger logger = LoggerFactory.getLogger(EstadoController.class);
 @Autowired
    private EstadoRepository EstadoRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE) public Iterable<Estado> getEstado() {
    logger.info("Sending all Local");
    return EstadoRepository.findAll(); }


 //o codigo abaixo é para guardar um Estado
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
        public Estado saveEstado(@RequestBody Estado estado) {
         Estado savedEstado = EstadoRepository.save(estado); 
            logger.info("Saving Serviço with id " + savedEstado.getId()); 
             return savedEstado;
             }



            /* @PutMapping(path = "/{id}/registrations",  
             produces = MediaType.APPLICATION_JSON_VALUE) 
                 public Response gradeStudent(@PathVariable  int id, 
                             @RequestBody RegistrationGradeView gradeData) { 
                     logger.info("Grading student with " + id +  
                                 " with grade "+gradeData.getGrade()); 
                     // Not verifying if it exists (error will happen if does not exist) 
                     Integer updated = studentRepository.gradeStudent( 
             gradeData.getRegId(),gradeData.getGrade(), LocalDate.now()); 
                     return new Response(updated+ 
                               " grade updated for student with id "+id,gradeData); 
                 }   
             } */ 
              

}
