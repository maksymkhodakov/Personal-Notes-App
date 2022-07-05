package com.example.persistant.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.sql.Clob;

@Entity(name = "Product")
public class Product {

    @Id
    private Integer id;

    private String name;

    @Lob
    private Clob warranty;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clob getWarranty() {
        return warranty;
    }

    public void setWarranty(Clob warranty) {
        this.warranty = warranty;
    }
}
