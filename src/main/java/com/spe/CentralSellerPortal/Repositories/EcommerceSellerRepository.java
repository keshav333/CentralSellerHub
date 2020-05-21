package com.spe.CentralSellerPortal.Repositories;

import com.spe.CentralSellerPortal.Entities.Ecommerce_seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcommerceSellerRepository extends JpaRepository<Ecommerce_seller, Long>  {
}
