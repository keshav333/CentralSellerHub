package com.spe.CentralSellerPortal.Services;
import com.spe.CentralSellerPortal.Entities.Product;
import com.spe.CentralSellerPortal.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Value("${upload.path}")
    private String path;

    public void save(Product product) throws IOException {

        productRepository.save(product);
    }

    public Product findById(long product_id)
    {
        Product product= productRepository.findById(product_id).orElse(null);
        return product;
    }
    public void deleteById(long product_id)
    {
        productRepository.deleteById(product_id);
    }

    public List<Product> findBySeller_Id(Long seller_id)
    {
        List<Product> productList = productRepository.findBySeller_SellerId(seller_id);
        return productList;
    }



    public String uploadFile(MultipartFile file) throws IOException {

        // if (file.isEmpty()) {

        //     throw new StorageException("Failed to store empty file");
        // }

        
            String fileName = file.getOriginalFilename();
            InputStream is = file.getInputStream();
            String temp="/uploads/";

            Files.copy(is, Paths.get(path + fileName),
                    StandardCopyOption.REPLACE_EXISTING);
        return temp+fileName;
    }
}
