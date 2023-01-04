package com.example.PAKA_MOVE.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "usuario")
public class Usuario {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name="user_id_")    private int id; 
    @Column(name="user_nome")  private String nome;; 
    @Column(name="user_senha") private String senha;
    @Column(name="user_hbd")  private LocalDate Data_nsc;; 
    @Column(name="user_email") private String email; 
    @Column(name="user_perfil_id") private int perfil; 

    Usuario(){}
    Usuario(int id, String nome,String senha,LocalDate nacimento,String email,int perfil ){
        this.id = id;
        this.nome = nome;
        this.senha = senha ;
        Data_nsc = nacimento;
        this.email = email;
        this.perfil = perfil;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getPerfil() {
        return perfil;
    }
    public void setPerfil(int perfil) {
        this.perfil = perfil;



        
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public LocalDate getData_nsc() {
        return Data_nsc;
    }
    public void setData_nsc(LocalDate data_nsc) {
        Data_nsc = data_nsc;
    }
   
    


}
