package com.example.fractal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fractal.model.OrderDetModel;
import com.example.fractal.model.OrderModel;
import com.example.fractal.service.IPedidosService;

@Controller
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private IPedidosService serv;
	
	@GetMapping()
	public String listOrders(Model model, @Param("name") String name) {
		List<OrderModel> list =  serv.listOrder(name);
		model.addAttribute("orders",list);
		return "orders";
	}
	
	@GetMapping("/{id}")
	public String orderDetails(Model model, @PathVariable int id,@Param("name") String name,@Param("date") String date, @Param("status") String status) {
		List<OrderDetModel> list =  serv.listOrderDet(id);
		model.addAttribute("details",list);
		model.addAttribute("name",name);
		model.addAttribute("status",status);
		model.addAttribute("date",date);
		model.addAttribute("id",id);
		return "orderDetails";
	}

}
