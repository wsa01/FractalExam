package com.example.fractal.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.fractal.model.ProductModel;

@Repository
public interface IProductRespository extends CrudRepository<ProductModel, Integer>  {
	
	
	public List<ProductModel> findByName(String name);

}
