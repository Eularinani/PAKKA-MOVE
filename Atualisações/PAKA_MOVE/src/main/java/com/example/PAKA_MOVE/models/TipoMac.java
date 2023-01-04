package com.example.PAKA_MOVE.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_mac")
public class TipoMac {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name="tipo_mac_id")    private int id; 
    @Column(name="Tipo_mac_compania")  private String tipomaqcompania; 
    @Column(name="Tipo_mac_nome") private String tipomacnome ; 
    @Column(name="Tipo_mac_direcion") private String direcionamento ; 
 
    public TipoMac() {} 
    
    

    public TipoMac(int id , String compania , String nome,String bacoligado){
        this.id = id;
        tipomaqcompania = compania;
        tipomacnome = nome;
        direcionamento = bacoligado;
    }
    
    
    public String getTipomaqcompania() {
        return tipomaqcompania;
    }
    public void setTipomaqcompania(String tipomaqcompania) {
        this.tipomaqcompania = tipomaqcompania;
    }
    public String getTipomacnome() {
        return tipomacnome;
    }
    public void setTipomacnome(String tipomacnome) {
        this.tipomacnome = tipomacnome;
    }
    public String getDirecionamento() {
        return direcionamento;
    }
    public void setDirecionamento(String direcionamento) {
        this.direcionamento = direcionamento;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    
    
    
}
    

