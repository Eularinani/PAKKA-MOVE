package com.example.PAKA_MOVE.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado")
public class Estado {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name="estado_id")    private int id; 
    @Column(name="estado_nome")  private String nome;; 

    Estado(){}

    Estado(int ID, String NOME , String MOMENTO){
        id = ID;
        nome = NOME;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

 

}
