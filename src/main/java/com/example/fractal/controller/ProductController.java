package com.example.fractal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.fractal.model.ProductModel;
import com.example.fractal.service.IProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private IProductService serv;

	@GetMapping()
	public String listaOfProducts(Model model, @Param("name") String name) {
		List<ProductModel> products = serv.listProduct(name);
		model.addAttribute("products", products);
		return "product";
	}
	
	
}
