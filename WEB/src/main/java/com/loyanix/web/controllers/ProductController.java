package com.loyanix.web.controllers;

import com.loyanix.services.DTO.ProductDTO;
import com.loyanix.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final static Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<ProductDTO> findAll() {
        log.info("Find all product");
        return productService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO get(@PathVariable("id") Long id){
        log.info("Delete product with id {}", id);
        return productService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ProductDTO productDTO){
        log.info("Create new product: {}", productDTO.toString());
        productService.create(productDTO);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        log.info("Delete product with id: {}", id);
        productService.delete(id);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO){
        log.info("Update product with id: {}, data:{}", id, productDTO);
        productService.udpate(id, productDTO);
    }
}
