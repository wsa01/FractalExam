package com.example.fractal.service;

import java.util.List;

import com.example.fractal.model.ClientModel;

public interface IClienteService {

	public List<ClientModel> listOfClient(String name);
	public void saveClient(ClientModel clientModel);
	
}
