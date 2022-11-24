package com.example.fractal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fractal.model.ProductModel;
import com.example.fractal.repository.IProductRespository;
import com.example.fractal.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private IProductRespository repo;


	@Override
	public List<ProductModel> listProduct(String name) {
	
		 if(name != null && name!="") {
			 return (List<ProductModel>) repo.findByName(name);
		}else {
			return (List<ProductModel>) repo.findAll();
		}
	
	}

	@Override
	public ProductModel findProduct(int id) {
		ProductModel product = repo.findById(id).orElse(null);
		return product;
	}

	@Override
	public void saveProduc(ProductModel productModel) {
		repo.save(productModel);
	}


}
