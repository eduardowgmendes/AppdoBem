package br.com.goodfeel.app.appdobem.domain;

import java.io.Serializable;

public class Author implements Serializable {

    private String picture, name, lastName, description, birthDate, deathDate;

    public Author(String picture, String name, String lastName, String description, String birthDate, String deathDate) {
        this.picture = picture;
        this.name = name;
        this.lastName = lastName;
        this.description = description;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }

    public String getCompleteName() {
        return this.getName() + " " + this.getLastName();
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getName(), this.getLastName());
    }
}
