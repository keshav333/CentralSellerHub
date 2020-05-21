package com.spe.CentralSellerPortal.Controllers;
import com.spe.CentralSellerPortal.Entities.Ecommerce_seller;
import com.spe.CentralSellerPortal.Repositories.EcommerceSellerRepository;
import javax.servlet.http.HttpSession;


import com.spe.CentralSellerPortal.Entities.Seller;
import com.spe.CentralSellerPortal.Repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class LoginController {



    @Autowired
    EcommerceSellerRepository ecommerceSellerRepository;


    @Autowired
    SellerRepository sellerRepository;




    @RequestMapping(value="/verifyseller" , method=RequestMethod.GET)
    public RedirectView create(@RequestParam("s_mobile") String s_mobile,
                               @RequestParam("s_password") String s_password ,
                               RedirectAttributes redirectAttrs,
                               HttpSession session

                               ){
        List<Seller> seller = new ArrayList<Seller>();
        seller = sellerRepository.findAll();

        for(Seller s: seller){
            if((s_password).equals(s.getSellerPassword()) && (s_mobile).equals(s.getSellerContactNo())){
                session.setAttribute("sellerId", s.getSellerId());
                session.setAttribute("shopName", s.getShopName());
                session.setAttribute("sellerContactNo", s.getSellerContactNo());
                session.setAttribute("sellerEmailId", s.getSellerEmailId());
                session.setAttribute("sellerPassword", s.getSellerPassword());
                session.setAttribute("sellerAddress", s.getSellerAddress());
                session.setAttribute("sellerName", s.getSellerName());

                RedirectView rv = new RedirectView();
                String rurl="/SellerDashboard.jsp?id="+Long.toString(s.getSellerId());
                rv.setUrl(rurl);
                return rv;

            }

        }
        RedirectView rv = new RedirectView();
        String failLogin = "/FailedLogin.jsp";
        rv.setUrl(failLogin);

        return rv;
    }

    @RequestMapping(value="/verifyecommerce" , method=RequestMethod.GET)
    public RedirectView createecomm(@RequestParam("c_email") String c_email,
                                    @RequestParam("c_password") String c_password , RedirectAttributes redirectAttrs,
                                    HttpSession session
                                    ){
        List<Ecommerce_seller> ecomm = new ArrayList<Ecommerce_seller>();
        ecomm = ecommerceSellerRepository.findAll();

//        for(Ecommerce c: ecomm){
//            if((c_password).equals(c.getEcommPassword()) && (c_email).equals(c.getEcommEmailId())){

//                session.setAttribute("ecommName", c.getEcommName());
//                session.setAttribute("ecommEmailId", c.getEcommEmailId());
//                session.setAttribute("ecommPassword", c.getEcommPassword());

//                RedirectView rv = new RedirectView();
//                String rurl="/EcommDashboard.jsp?e_id="+Long.toString(c.getEcommId());
//                rv.setUrl(rurl);
//                return rv;

//            }

//        }
        RedirectView rvf = new RedirectView();
        String furl="/FailedLogin.jsp";
        rvf.setUrl(furl);
        return rvf;
    }
}