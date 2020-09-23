package com.cg.iter.productms.service;

import java.util.List;
import java.util.Random;
import java.util.Optional;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.productms.controller.ProductController;
import com.cg.iter.productms.dto.ProductDTO;
import com.cg.iter.productms.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	private static final Logger Logger = org.apache.log4j.Logger.getLogger(ProductController.class);
	
	@Autowired
	ProductRepository productRepository;
	Random rand = new Random();
	

	
	@Override
	public List<ProductDTO> viewAllProducts() {
		return (List<ProductDTO>) productRepository.findAll();
	}

	@Override
	public boolean addProduct(ProductDTO product) {
		int randomId = rand.nextInt(1000);
		String productId = "PROD"+(productRepository.count()*randomId);
		product.setProductId(productId);
		productRepository.save(product);
		return true;
	}

	@Override
	public boolean editProduct(ProductDTO product) {
		//Option is a data type 
		Optional<ProductDTO> find = productRepository.findById(product.getProductId());
		if(find.isPresent()) {
			productRepository.save(product);
			return true;
		}
		 
		return false;
	}

	@Override
	public boolean deleteProduct(String productId) {
		
		if(productRepository.findById(productId).isPresent()) {

		productRepository.deleteById(productId);
		return true;
	}
		return false;
	}
	
	@Override
	public ProductDTO getProductByName(String productName) {
		Optional<ProductDTO> find = productRepository.findByproductName(productName);
		if(find.isPresent()) {
			return find.get();
		}
		return null;
	}

	@Override
	public ProductDTO getProductById(String productId) {
		Optional<ProductDTO> find = productRepository.findById(productId);
		if(find.isPresent()) {
			return find.get();
		}
		return null;
	}
}
