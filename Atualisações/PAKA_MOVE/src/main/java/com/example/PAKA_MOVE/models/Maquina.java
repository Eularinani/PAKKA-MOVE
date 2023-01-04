package com.example.PAKA_MOVE.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "maquina")
public class Maquina {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name="mac_id")    private int id; 
    @Column(name="mac_local_id")  private int mclocal;; 
    @Column(name="mac_tipo_mac_id") private int tipomac; 

    Maquina(){}
    
    Maquina(int id, int local1,int tipo1){
        this.id = id;
        mclocal = local1;
        tipomac = tipo1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMclocal() {
        return mclocal;
    }

    public void setMclocal(int mclocal) {
        this.mclocal = mclocal;
    }

    public int getTipomac() {
        return tipomac;
    }

    public void setTipomac(int tipomac) {
        this.tipomac = tipomac;
    }

    

}
