package com.gta.cardealer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mvc.cars")
public class Car {
	@Column(name = "make")
	private String make;
	@Column(name = "model")
	private String model;
	@Column(name = "year")
	private String year;
	@Id
	@Column(name = "vin")
	private String vin;
	@Column(name = "cost")
	private double cost;
	
	public Car() {
	}
	
	public Car(String make, String model, String year, String vin, double cost) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.vin = vin;
		this.cost = cost;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	
	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return String.format("Car [make=%s, model=%s, year=%s, vin=%s, cost=%s]", make, model, year, vin, cost);
	}
	
}
