package com.example.fractal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetModel {

	private String name;
	private int cantidad;
	private float price_unitario;
	private float cost;
}
