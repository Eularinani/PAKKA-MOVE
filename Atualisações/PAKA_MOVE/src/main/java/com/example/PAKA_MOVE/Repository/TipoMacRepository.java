package com.example.PAKA_MOVE.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.PAKA_MOVE.models.TipoMac;
import com.example.PAKA_MOVE.models.Views.TipoMacViews;

public  interface TipoMacRepository extends CrudRepository<TipoMac,Integer> { 

    @Query(value="select * from tipo_mac where tipo_mac_nome =:nome ",nativeQuery = true)
    Iterable<TipoMac> tipomac(@Param("nome") String nome);

    @Query(value="select * from tipo_mac where tipo_mac_nome =:nome ",nativeQuery = true)
    Iterable<TipoMacViews>tiponome(@Param("nome") String nome);

}


