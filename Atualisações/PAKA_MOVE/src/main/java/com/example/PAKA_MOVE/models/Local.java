package com.example.PAKA_MOVE.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "local_mac")
public class Local {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    @Column(name="local_id")    private int id; 
    @Column(name="local_dndereco")  private String endereco;; 
    @Column(name="local_cp") private String codigoPostal; 
    @Column(name="local_latitude") private String Latitude;
    @Column(name="local_longitude") private String Longitude;
 
    public Local() {}

    public Local(int identificação,String Morada, String cp, String latitude, String longitude) {
        id=identificação;
        endereco = Morada;
        Latitude = latitude;
        Longitude = longitude;
 
    }

    public int getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    
   
    //public int getId() { return Id_local; } 


}
