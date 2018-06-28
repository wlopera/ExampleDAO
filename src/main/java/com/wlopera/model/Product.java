package com.wlopera.model;

public class Product {
	
	private int id;
	private String name;
	private double quantity;
	
	public Product() {}

	public Product(String name, double quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public Product(int id, String name, double quantity) {
		this(name, quantity);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity + "]";
	}

}
