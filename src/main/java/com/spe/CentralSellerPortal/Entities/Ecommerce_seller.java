package com.spe.CentralSellerPortal.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="ecommerce_seller")

public class Ecommerce_seller implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ecommSellerId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ecomm_id") //nullable = false)
    private Ecommerce ecomm;

    @Column(unique= true)
    @Size(max=100)
    @NotNull
    private String ecommEmailId;

    @Column
    @NotNull
    private String ecommPassword;

    public Ecommerce_seller(){

    }

    public Ecommerce_seller(@NotNull Ecommerce ecomm, @Size(max = 100) @NotNull String ecommEmailId, @NotNull String ecommPassword) {
        this.ecomm = ecomm;
        this.ecommEmailId = ecommEmailId;
        this.ecommPassword = ecommPassword;
    }

    public long getEcommSellerId() {
        return ecommSellerId;
    }

    public void setEcommSellerId(long ecommSellerId) {
        this.ecommSellerId = ecommSellerId;
    }

    public Ecommerce getEcomm() {
        return ecomm;
    }

    public void setEcomm(Ecommerce ecomm) {
        this.ecomm = ecomm;
    }

    public String getEcommEmailId() {
        return ecommEmailId;
    }

    public void setEcommEmailId(String ecommEmailId) {
        this.ecommEmailId = ecommEmailId;
    }

    public String getEcommPassword() {
        return ecommPassword;
    }

    public void setEcommPassword(String ecommPassword) {
        this.ecommPassword = ecommPassword;
    }

    @Override
    public String toString() {
        return "Ecommerce_seller{" +
                "ecommSellerId=" + ecommSellerId +
                ", ecomm=" + ecomm +
                ", ecommEmailId='" + ecommEmailId + '\'' +
                ", ecommPassword='" + ecommPassword + '\'' +
                '}';
    }
}
