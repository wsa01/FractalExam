package com.example.fractal.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fractal.model.OrderDetModel;
import com.example.fractal.model.OrderModel;

@Repository
public interface IOrderRepository extends CrudRepository<OrderModel, Integer> {

	@Query(value = "CALL PEDIDOS_GET;")
	public List<OrderModel> findAllOrders();
	
	@Query(value = "CALL PEDIDOS_FIND(:name);")
	public List<OrderModel> findByName(@Param("name") String name);
	
	@Query(value = "CALL PEDIDOS_DET_GET(:id);")
	public List<OrderDetModel> findById(@Param("id") int id);
	
}
