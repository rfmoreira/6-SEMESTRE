package com.example.teste;

import java.io.Serializable;

public class Contato implements Serializable {

    private Integer id;
    private String Name;
    private String Telefone;
    private String Celular;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    @Override
    public String toString(){
        return Name + Celular + Telefone;
    }


}
