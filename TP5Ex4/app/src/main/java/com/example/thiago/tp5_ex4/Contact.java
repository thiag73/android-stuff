package com.example.thiago.tp5_ex4;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Thiago on 16/03/2018.
 */

public class Contact implements Serializable {
    private char sexe;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String tel;
    private String mail;
    private String avatar;

    public Contact(String nom, String prenom, char sexe, Date dateNaissance, String tel, String mail, String avatar) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.tel = tel;
        this.mail = mail;
        this.avatar = avatar;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        if (sexe == 'M' || sexe == 'F') {
            this.sexe = sexe;
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        if (dateNaissance.before(new Date()))
        this.dateNaissance = dateNaissance;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String toString() {
        String str = "";
        str += prenom + " " + nom + " (" + sexe + ")\n";
        str += dateNaissance + "\n";
        str += tel + ", " + mail + "\n";
        str += avatar;
        return(str);
    }
}
