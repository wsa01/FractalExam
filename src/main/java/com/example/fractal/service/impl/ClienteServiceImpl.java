package com.example.fractal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fractal.model.ClientModel;
import com.example.fractal.repository.IClientRepository;
import com.example.fractal.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private IClientRepository repo;
	

	@Override
	public List<ClientModel> listOfClient(String name) {
		if(name!=null && name!="") {
			return repo.findByName(name);
		}else {
			return (List<ClientModel>) repo.findAll();
		}
	}

	@Override
	public void saveClient(ClientModel clientModel) {
		// TODO Auto-generated method stub
		
	}

}
