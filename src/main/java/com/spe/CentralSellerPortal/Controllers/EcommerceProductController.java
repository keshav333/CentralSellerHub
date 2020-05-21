package com.spe.CentralSellerPortal.Controllers;

import java.util.*;
import com.spe.CentralSellerPortal.Entities.Ecommerce;
import com.spe.CentralSellerPortal.Entities.Product;
import com.spe.CentralSellerPortal.Repositories.EcommerceRepository;
import com.spe.CentralSellerPortal.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/showcase")
public class EcommerceProductController {

    @Autowired
    EcommerceRepository ecommerceRepository ;

    @Autowired
    ProductRepository productRepository ;

    @RequestMapping(value="/viewAllEcommProducts/{e_id}" ,method= RequestMethod.GET)
    public RedirectView getAllProductsByEcommId(@PathVariable(value = "e_id") long ecomm_id,
                                                HttpSession session) {
        System.out.println("reached in pro");
        Ecommerce ecommerce = ecommerceRepository.findById(ecomm_id).orElse(null);
        System.out.println(ecommerce.getEcommName());
        List<Long> product_id = ecommerceRepository.findProductId(ecomm_id);
        System.out.println("pl"+ product_id);
        List<Product> productList = new ArrayList();

        for (Long pid : product_id) {
            Product product = productRepository.findByProductId(pid);
            System.out.println("product = "+ product.getCategory());
            productList.add(product);
            System.out.println("product added");
        }
        System.out.println("productList = "+productList);
        RedirectView rv = new RedirectView();
        session.setAttribute("showcaseList", productList);
        session.setAttribute("ecommName", ecommerce.getEcommName());
        String rurl="/showcaseView.jsp?id="+Long.toString(ecomm_id);
        System.out.println(rurl);
        rv.setUrl(rurl);
        return rv;
    }

}
