package com.spe.CentralSellerPortal.Repositories;

import com.spe.CentralSellerPortal.Entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {

}
