package com.example.fractal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fractal.model.OrderDetModel;
import com.example.fractal.model.OrderModel;
import com.example.fractal.repository.IOrderRepository;
import com.example.fractal.service.IPedidosService;

@Service
public class OrderServiceImpl implements IPedidosService {
	
	@Autowired
	private IOrderRepository repo;

	@Override
	public List<OrderModel> listOrder(String name) {
		if(name!= null && name != "") {
			return repo.findByName(name);
		}else {
			return repo.findAllOrders();
		}
	}

	@Override
	public void saveOrder(OrderModel orderModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderDetModel> listOrderDet(int id) {
		List<OrderDetModel> list = repo.findById(id);
		return list;
	}
	

}
