package com.example.PAKA_MOVE.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="servicos")

public class Servico {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name="serv_id")    private int id; 
    @Column(name="serv_tipo")  private String tiposevico;
    @Column(name="serv_espc") private String especifica; 

    public Servico() {} 
    public int getId() { return id; } 
    

    public Servico(int idServico , String tipoServ, String especificacao){
        id=idServico;
        tiposevico = tipoServ;
        especifica=especificacao;   
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTiposevico() {
        return tiposevico;
    }
    public void setTiposevico(String tiposevico) {
        this.tiposevico = tiposevico;
    }
    public String getEspecifica() {
        return especifica;
    }
    public void setEspecifica(String especifica) {
        this.especifica = especifica;
    }
  
    
   
    
}
