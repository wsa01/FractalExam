package com.example.fractal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fractal.model.ClientModel;
import com.example.fractal.service.IClienteService;

@Controller
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private IClienteService serv;
	
	@GetMapping
	public String clientList(Model model,@Param("name") String name) {
		List<ClientModel> list = serv.listOfClient(name);
		model.addAttribute("clients", list);
		return "clients";
	}
	
}
