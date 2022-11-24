package com.example.fractal.service;

import java.util.List;

import com.example.fractal.model.OrderDetModel;
import com.example.fractal.model.OrderModel;

public interface IPedidosService {

	public List<OrderModel> listOrder(String name);
	public void saveOrder(OrderModel orderModel);
	
	public List<OrderDetModel> listOrderDet(int id);
}
