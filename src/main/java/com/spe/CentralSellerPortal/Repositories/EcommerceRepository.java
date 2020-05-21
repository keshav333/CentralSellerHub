package com.spe.CentralSellerPortal.Repositories;

import com.spe.CentralSellerPortal.Entities.Ecommerce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EcommerceRepository extends JpaRepository<Ecommerce, Long> {

    @Query("select p.productId from Ecommerce e inner join e.products p  where e.ecommId = :ecomm_id")
    List<Long> findProductId(Long ecomm_id);

//    @Query("select p.productId from product_ecommerce e inner join e.product p  where e.products_product_id = :productId")
//    List<Long> findBySeller_SellerId(Long productId);


    }

