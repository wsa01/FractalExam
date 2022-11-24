package com.example.fractal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.fractal.model.ClientModel;

@Repository
public interface IClientRepository extends CrudRepository<ClientModel, Integer> {

	public List<ClientModel> findByName(String name);
	
}
