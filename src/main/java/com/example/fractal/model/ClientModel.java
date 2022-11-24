package com.example.fractal.model;

import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "tbl_cliente")
public class ClientModel {
	private int id_cliente;
	private String name;
}
