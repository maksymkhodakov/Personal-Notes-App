package com.example.persistant.entity;

import com.example.persistant.entity.helperEntities.Name;

import javax.persistence.*;
import java.net.URL;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private Name name;

    private String notes;

    private URL website;

    private boolean starred;

    public Contact() {
    }

    public Contact(Name name, String notes, URL website, boolean starred) {
        this.name = name;
        this.notes = notes;
        this.website = website;
        this.starred = starred;
    }

    public Integer getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public URL getWebsite() {
        return website;
    }

    public void setWebsite(URL website) {
        this.website = website;
    }

    public boolean isStarred() {
        return starred;
    }

    public void setStarred(boolean starred) {
        this.starred = starred;
    }
}
