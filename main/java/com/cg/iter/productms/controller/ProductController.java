package com.cg.iter.productms.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.productms.dto.ProductDTO;
import com.cg.iter.productms.exception.ProductNotFoundDetails;
import com.cg.iter.productms.exception.ProductNotFoundException;
import com.cg.iter.productms.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins="*")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/viewAllProducts")
	List<ProductDTO> viewAllProducts(){
		return productService.viewAllProducts();
	}
	
	@PostMapping("/addProduct")
	String addProduct(@RequestBody ProductDTO product) {
		String status = "product added";
		
		
		if(productService.addProduct(product)) {
			return status;
		}
		
		return "failed to add product!";
		
	}
	
	@PostMapping("/deleteProduct")
	String deleteProduct(@RequestParam String productId) {
		if(productService.deleteProduct(productId)) {
			return "product deleted!";
		}
		return "error";
	}
	
	@PostMapping("/editProduct")
	String editProduct(@RequestBody ProductDTO product) {
		String status = "product updated";
		
		if(productService.editProduct(product)) {
			return status;
		}
		
		return "fail to update product!";
		
	}
	@GetMapping("/getProductByName")
	public ProductDTO getProductByName(@RequestParam String productName) {
		
		return productService.getProductByName(productName);
	}
	
	@GetMapping("/getProductById")
	public ProductDTO getProductById(@RequestParam String productId) {
		return productService.getProductById(productId);
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity productNotFound(ProductNotFoundException e) 
	{
        
		e.getMessage();
		
        int userId = e.Id();
        ProductNotFoundDetails errDetails = new ProductNotFoundDetails();
        //
        //find current time in millis
        //
        long currentTimeMillis = System.currentTimeMillis();
        errDetails.setTimestamp(currentTimeMillis);
        errDetails.setMessage("id not found, wrong id=" + userId);
        String uri = "request uri=/product/find/" + userId;
        errDetails.setDetails(uri);
        return new ResponseEntity(errDetails, HttpStatus.NOT_FOUND);
        
    }

	

}
