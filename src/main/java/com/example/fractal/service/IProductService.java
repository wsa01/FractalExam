package com.example.fractal.service;

import java.util.List;

import com.example.fractal.model.ProductModel;

public interface IProductService {

	public List<ProductModel> listProduct(String name);
	public ProductModel findProduct(int id);
	public void saveProduc(ProductModel productModel);
}
