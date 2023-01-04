package com.example.PAKA_MOVE.Repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.PAKA_MOVE.models.Usm;

public interface UsmRepository extends CrudRepository<Usm,Integer> {
 /*   @Modifying @Transactional @Query(value=" UPDATE usm  SET "+
"usm_estado_id = :grade, usm_user_id = :,usm_momento= :date "+
"where usm.usm_mac_id = :id", nativeQuery=true) Integer gradeStudent(@Param("id") int regId,
@Param("grade") double grade, @Param("date") LocalDate now); */

}
