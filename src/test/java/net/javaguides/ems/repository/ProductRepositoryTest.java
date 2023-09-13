package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductRepositoryTest {
@Autowired
    private ProductRepository productRepository;
@Test
    void saveMethod(){
    //create product
    Product product = new Product();
    product.setName("product2");
    product.setDescription("product1 description");
    product.setSku("110AN");
    product.setActive(true);
    product.setPrice(new BigDecimal(100));
//save product
    //Product saveProduct = productRepository.save(product);
    //display product info
    //System.out.println(saveProduct.getId());
}
}