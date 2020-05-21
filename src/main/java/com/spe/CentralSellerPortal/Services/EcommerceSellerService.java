package com.spe.CentralSellerPortal.Services;

import com.spe.CentralSellerPortal.Entities.Ecommerce_seller;
import com.spe.CentralSellerPortal.Repositories.EcommerceSellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcommerceSellerService {
    @Autowired
    EcommerceSellerRepository ecommerceSellerRepository;

    public void save(Ecommerce_seller ecommerce_seller)
    {
        ecommerceSellerRepository.save(ecommerce_seller);
    }

    public List<Ecommerce_seller> findAll() {
        List<Ecommerce_seller> ecommerce;
        ecommerce = ecommerceSellerRepository.findAll();
        return ecommerce;
    }

    public Ecommerce_seller findById(long ecommerce_id)
    {
        Ecommerce_seller ecommerce = ecommerceSellerRepository.findById(ecommerce_id).orElse(null);
        return ecommerce;
    }
}
