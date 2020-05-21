package com.spe.CentralSellerPortal.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ecommerce")
public class Ecommerce implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ecommId;

    @Column(unique= true)
    @Size(max=100)
    @NotNull
    private String ecommName;


    @JsonIgnore
    @ManyToMany(mappedBy = "ecommerce")
    private List<Product> products = new ArrayList();

    public long getEcommId() {
        return ecommId;
    }

    public void setEcommId(long ecommId) {
        this.ecommId = ecommId;
    }

    public String getEcommName() {
        return ecommName;
    }

    public void setEcommName(String ecommName) {
        this.ecommName = ecommName;
    }

    @Override
    public String toString() {
        return "Ecommerce{" +
                "ecommId=" + ecommId +
                ", ecommName='" + ecommName + '\'' +
                '}';
    }

}
