package com.example.PAKA_MOVE.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.PAKA_MOVE.models.Servico;

public interface ServicosRepository extends CrudRepository<Servico, Integer> {

    
    
}
