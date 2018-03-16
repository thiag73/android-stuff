package com.example.thiago.tp5_ex4;

import java.util.Date;

/**
 * Created by Thiago on 16/03/2018.
 */

public class Contact {
    private char sexe;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String tel;
    private String mail;
    private int codePostal;
    private String adresse;
    private String avatar;

    public Contact() {
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

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
