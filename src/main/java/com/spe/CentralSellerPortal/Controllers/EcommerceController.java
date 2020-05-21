package com.spe.CentralSellerPortal.Controllers;

import com.spe.CentralSellerPortal.Entities.Ecommerce;
import com.spe.CentralSellerPortal.Entities.Product;
import com.spe.CentralSellerPortal.Repositories.EcommerceRepository;
import com.spe.CentralSellerPortal.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/ecom")
public class EcommerceController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    EcommerceRepository ecommerceRepository;


    @RequestMapping(value = "/add/{pid}") //, method=RequestMethod.POST)
    public RedirectView addProduct(@PathVariable(value = "pid") Long product_id,
                                      HttpSession session){
        long ecommId = (long)session.getAttribute("eid");
        System.out.println("pid" + product_id);
        System.out.println("ecommid = " + ecommId);
        Product product=productRepository.findByProductId(product_id);
        Ecommerce ecomm=ecommerceRepository.findById(ecommId).orElse(null);
        product.getEcommerce().add(ecomm);
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/ViewEcommProfile.jsp?e_id="+ecommId);
        return redirectView;
    }

    @RequestMapping(value = "/delete/{pid}") //, method=RequestMethod.POST)
    public RedirectView deleteProduct(@PathVariable(value = "pid") Long product_id,
                                   HttpSession session){
        long ecommId = (long)session.getAttribute("eid");
        System.out.println("pid" + product_id);
        System.out.println("ecommid = " + ecommId);
        Product product=productRepository.findByProductId(product_id);
        Ecommerce ecomm=ecommerceRepository.findById(ecommId).orElse(null);
        product.getEcommerce().remove(ecomm);
        RedirectView redirectView = new RedirectView();
        redirectView.setContextRelative(true);
        redirectView.setUrl("/ViewEcommProfile.jsp?e_id="+ecommId);
        return redirectView;
    }

//    @RequestMapping(value="/verifyecommerce")
//    public RedirectView verifyecommerce(@RequestParam("cName") int ecommerce_name,
//                                     @RequestParam("cEmailId") String ecommerce_emailId,
//                                     @RequestParam("cPassword") String ecommerce_password)
//    {
//
//        Ecommerce ecommerce=new Ecommerce();
//        ecommerce.setEcommName(ecommerce_name);
//        ecommerce.setEcommEmailId(ecommerce_emailId);
//        ecommerce.setEcommPassword(ecommerce_password);
//
//        ecommerceService.save(ecommerce);
//        System.out.println("inside ecomm controller after saving data in db..");
//        RedirectView redirectView = new RedirectView();
//        redirectView.setContextRelative(true);
//        redirectView.setUrl("/DisplayAllProducts.jsp?e_id="+Long.toString(ecommerce_name));
//        return redirectView;
//    }
//    @GetMapping("/displayAllEcommerce")
//    public ResponseEntity<List<Ecommerce>> getAllEcommerce() {
//        System.out.println("Evaluating emmorece : ");
//        List<Ecommerce> ecommerceList =ecommerceService.findAll();
//        System.out.println("Displaying emmorece : ");
//        return ResponseEntity.ok().body(ecommerceList);
//    }
//
//    @GetMapping(value = "/displayAllProducts")
//    public ResponseEntity<List<Product>> getAllProduct()
//    {
//        List<Product> productList =productRepository.findAll();
//        return ResponseEntity.ok().body(productList);
//    }
//
//    @RequestMapping(value="/viewEcommerce/{e_id}" ,method=RequestMethod.GET)
//    public RedirectView getSellerById(@PathVariable(value = "e_id") long ecomm_id, HttpSession session)
//    {
//        System.out.println("Getting your details ecomm..please wait!!");
//        System.out.println(ecomm_id);
//        Ecommerce ecommerce = ecommerceService.findById(ecomm_id); //.orElse(null);
//
//        session.setAttribute("ecommEmailId", ecommerce.getEcommEmailId());
//        session.setAttribute("ecommName", ecommerce.getEcommName());
//        //session.setAttribute("ecommassword",seller.getSellerPassword());
//
//        //session.setAttribute("seller", seller);
//
//
//
//        RedirectView rv = new RedirectView();
//        String rurl="/ViewEcommProfile.jsp?e_id="+Long.toString(ecommerce.getEcommId());
//        System.out.println(rurl);
//        rv.setUrl(rurl);
//        return rv;
//    }
//
//    @RequestMapping(value="/updateEcommerce/{e_id}" , method=RequestMethod.POST)
//    public RedirectView updateUser(
//            @PathVariable(value = "e_id") Long ecommId,
//            @RequestParam("c_name") String ecommName,
//            @RequestParam("c_mail") String ecommEmailId,
//            @RequestParam("c_password") String password,
//            HttpSession session)
//    {
//        Ecommerce ecommerce=ecommerceService.findById(ecommId); //.orElse(null);
//        System.out.println("hi................................");
//        ecommerce.setEcommName(ecommName);
//        ecommerce.setEcommEmailId(ecommEmailId);
//        ecommerce.setEcommPassword(password);
//        session.setAttribute("ecommName", ecommerce.getEcommName());
//        session.setAttribute("ecommEmailId", ecommerce.getEcommEmailId());
//        session.setAttribute("ecommPassword", ecommerce.getEcommPassword());
//
//        ecommerceService.save(ecommerce);
//        RedirectView rv = new RedirectView();
//        String rurl="/EcommDashboard.jsp?e_id="+Long.toString(ecommerce.getEcommId());
//        rv.setUrl(rurl);
//        return rv;
//    }
//
//
}