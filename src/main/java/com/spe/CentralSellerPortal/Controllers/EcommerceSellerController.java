package com.spe.CentralSellerPortal.Controllers;

import com.spe.CentralSellerPortal.Entities.Ecommerce_seller;
import com.spe.CentralSellerPortal.Entities.Product;
import com.spe.CentralSellerPortal.Repositories.EcommerceRepository;
import com.spe.CentralSellerPortal.Repositories.EcommerceSellerRepository;
import com.spe.CentralSellerPortal.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ecommsell")

public class EcommerceSellerController {

    @Autowired
    EcommerceRepository ecommerceRepository ;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    EcommerceSellerRepository ecommerceSellerRepository;

    @RequestMapping(value="/verifyecommerce" , method= RequestMethod.GET)
    public RedirectView createecomm(@RequestParam("c_email") String c_email,
                                    @RequestParam("c_name") long c_name,
                                    @RequestParam("c_password") String c_password , RedirectAttributes redirectAttrs,
                                    HttpSession session
    ){
        System.out.println("reached here");
        System.out.println("maybe id"+c_name);
        System.out.println(session.getAttribute("sellerId"));
        List<Ecommerce_seller> ecomm = new ArrayList<>();
        ecomm = ecommerceSellerRepository.findAll();

        for(Ecommerce_seller c: ecomm){
            if((c_password).equals(c.getEcommPassword()) && (c_email).equals(c.getEcommEmailId())){

                session.setAttribute("ecommEmailId", c.getEcommEmailId());
                session.setAttribute("ecommPassword", c.getEcommPassword());
                session.setAttribute("eid", c_name);
                System.out.println("eid1 "+ session.getAttribute("eid"));
                RedirectView rv = new RedirectView();
                String rurl="/ViewEcommProfile.jsp?e_id="+Long.toString(c.getEcommSellerId());
                rv.setUrl(rurl);
                return rv;

            }

        }
        RedirectView rvf = new RedirectView();
        String furl="/FailedLogin.jsp";
        rvf.setUrl(furl);
        return rvf;
    }
    @RequestMapping(value="/ecommproducts" , method= RequestMethod.GET)
    public RedirectView getProductBySellerId(HttpSession session)
    {
        long id =(long) session.getAttribute("sellerId");
        List<Product> productList = productRepository.findBySeller_SellerId(id);
        System.out.println("getting Products");
        System.out.println(productList);
        session.setAttribute("productList",productList);
        System.out.println(session.getAttribute("productList"));
        System.out.println("eid"+session.getAttribute("eid"));

        RedirectView rv = new RedirectView();
        System.out.println(session.getAttributeNames());
        String rurl="/DisplayAllProducts.jsp?id="+id;
        System.out.println(rurl);
        rv.setUrl(rurl);
        return rv;

    }
    @RequestMapping(value="/viewAllEcommProducts/{e_id}" ,method= RequestMethod.GET)
    public RedirectView getAllProductsByEcommId(@PathVariable(value = "e_id") long ecomm_id,
                                                HttpSession session) {
        System.out.println("reached in pro");

//        Ecommerce ecommerce = ecommerceRepository.findById(ecomm_id).orElse(null);
//        System.out.println(ecommerce.getEcommName());
        List<Long> product_id = ecommerceRepository.findProductId((long)session.getAttribute("eid"));
        System.out.println("pl"+ product_id);
        List<Product> productList = new ArrayList();

        for (Long pid : product_id) {
            Product product = productRepository.findByProductId(pid);
            System.out.println("1 = "+ product.getSeller().getSellerId());
            System.out.println("2 = "+ (long)session.getAttribute("sellerId"));
            if((product.getSeller().getSellerId()) == ((long)session.getAttribute("sellerId")))
                productList.add(product);
            System.out.println("product added");
        }
        System.out.println("productList = "+productList);
        RedirectView rv = new RedirectView();
        session.setAttribute("sellerProdList", productList);
        String rurl="/displayAllAddedProducts.jsp?id="+Long.toString(ecomm_id);
        System.out.println(rurl);
        rv.setUrl(rurl);
        return rv;
    }


}
