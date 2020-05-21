package com.spe.CentralSellerPortal.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name="product")
public class Product implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long productId;

        @Column
        @NotNull
        private String productName;

        @Column
        @NotNull
        private String productDescription;

        @Column
        @NotNull
        private int price;

        @Column
        @NotNull
        private int discount;

        @Column
        @NotNull
        private int quantity;

        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "seller_id") //nullable = false)
        private Seller seller;

        @Column
        @NotNull
        private int productionTime;

        @Column
        @NotNull
        private String category;

       @NotNull
       @Column
       private String image;

        @ManyToMany(cascade=CascadeType.ALL)
        private List<Ecommerce> ecommerce = new ArrayList();


    public Product() {
    }


    public Product(@NotNull String productName, @NotNull String productDescription, @NotNull int price, @NotNull int discount, @NotNull int quantity, Seller seller, @NotNull int productionTime, @NotNull String category, @NotNull String image, List<Ecommerce> ecommerce) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.seller = seller;
        this.productionTime = productionTime;
        this.category = category;
        this.image = image;
        this.ecommerce = ecommerce;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long product_id) {
        this.productId = product_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String product_name) {
        this.productName = product_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String product_description) {
        this.productDescription = product_description;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(int productionTime) {
        this.productionTime = productionTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

   public String getImage() {
       return image;
   }

   public void setImage(String image) {
       this.image = image;
   }

    public List<Ecommerce> getEcommerce() {
        return ecommerce;
    }

    public void setEcommerce(List<Ecommerce> ecommerce) {
        this.ecommerce = ecommerce;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", quantity=" + quantity +
                ", seller=" + seller +
                ", productionTime=" + productionTime +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                ", ecommerce=" + ecommerce +
                '}';
    }
}
