package com.example.fractal.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {

	private int id_pedidos;
	private String name;
	private char status;
	private LocalDate date;
	private Float total;
	
}
