package com.example.PAKA_MOVE.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.print.attribute.standard.DateTimeAtCompleted;

@Entity
@Table(name = "usm")
public class Usm {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name="usm_id")    private int id; 
    @Column(name="usm_user_id")  private int usuario; 
    @Column(name="usm_estado_id") private int estado ; 
    @Column(name="usm_mac_id") private int maquina ; 
    @Column(name="usm_momento") private LocalDate momento ; 

    public Usm() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getMaquina() {
        return maquina;
    }

    public void setMaquina(int maquina) {
        this.maquina = maquina;
    }

    public LocalDate getMomento() {
        return momento;
    }

    public void setMomento(LocalDate momento) {
        this.momento = momento;
    } 
    

}
