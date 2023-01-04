package com.example.PAKA_MOVE.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.PAKA_MOVE.models.Maquina;
import com.example.PAKA_MOVE.models.Views.MaquinaViews;


public interface MaquinaRepository extends CrudRepository<Maquina,Integer> { 
    String Mestado = "SELECT tipo_mac.tipo_mac_compania,tipo_mac.tipo_mac_nome,tipo_mac.tipo_mac_direcion," + 
    " maquina.mac_id,usm.usm_momento," + "usuario.user_nome,estado.estado_nome," + " local_mac.local_latitude,local_mac.local_longitude ";
    String M2 = "FROM maquina " + "INNER JOIN tipo_mac ON maquina.mac_tipo_mac_id = tipo_mac.tipo_mac_id " + 
    "INNER JOIN local_mac ON maquina.mac_local_id = local_mac.local_id " + "INNER JOIN usm ON maquina.mac_id = usm.usm_mac_id " +
     "INNER JOIN usuario ON usuario.user_id_ = usm.usm_user_id " + "INNER JOIN estado ON estado.estado_id = usm.usm_estado_id ORDER BY maquina.mac_id";
    @Query(value= Mestado + M2,nativeQuery = true)Iterable<MaquinaViews>findAllmestados();
}