package com.restapi.bookrestapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int autherId;
    @Column(name = "first_name")
    private String firstName;
    private String lastName;
    private String authLanguage;

    public Author() {

    }

    public Author(int autherId, String firstName, String lastName, String authLanguage) {
        this.autherId = autherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authLanguage = authLanguage;
    }

    public int getAutherId() {
        return autherId;
    }

    public void setAutherId(int autherId) {
        this.autherId = autherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAuthLanguage() {
        return authLanguage;
    }

    public void setAuthLanguage(String authLanguage) {
        this.authLanguage = authLanguage;
    }

    @Override
    public String toString() {
        return "Author [autherId=" + autherId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", authLanguage=" + authLanguage + "]";
    }

}
