package com.example.pakkamove;

import java.time.DateTimeException;

public class Usuario {
    int user_perfil_id;
    int id_user;
    String nome;
    String user_senha;
    DateTimeException user_hbd;
    String user_email;
    Usuario() {};

    public int getUser_perfil_id() {
        return user_perfil_id;
    }

    public int getId_user() {
        return id_user;
    }

    public String getNome() {
        return nome;
    }

    public String getUser_senha() {
        return user_senha;
    }

    public void setUser_senha(String user_senha) {
        this.user_senha = user_senha;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
