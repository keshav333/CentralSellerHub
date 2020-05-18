package com.acms.CentralSellerPortal.Repositories;

import com.acms.CentralSellerPortal.Entities.Ecommerce;
import com.acms.CentralSellerPortal.Entities.Ecommerce_seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcommerceSellerRepository extends JpaRepository<Ecommerce_seller, Long>  {
}
