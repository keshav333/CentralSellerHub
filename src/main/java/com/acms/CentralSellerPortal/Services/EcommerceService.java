package com.acms.CentralSellerPortal.Services;

import com.acms.CentralSellerPortal.Entities.Ecommerce;
import com.acms.CentralSellerPortal.Entities.Ecommerce_seller;
import com.acms.CentralSellerPortal.Repositories.EcommerceRepository;
import com.acms.CentralSellerPortal.Repositories.EcommerceSellerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EcommerceService {
    @Autowired
    EcommerceRepository ecommerceRepository;

    public void save(Ecommerce ecommerce)
    {
        ecommerceRepository.save(ecommerce);
    }

    public List<Ecommerce> findAll() {
        List<Ecommerce> ecommerce;
        ecommerce = ecommerceRepository.findAll();
        return ecommerce;
    }

    public Ecommerce findById(long ecommerce_id)
    {
        Ecommerce ecommerce = ecommerceRepository.findById(ecommerce_id).orElse(null);
        return ecommerce;
    }
}
