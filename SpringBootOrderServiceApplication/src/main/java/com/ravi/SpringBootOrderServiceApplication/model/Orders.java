package com.ravi.SpringBootOrderServiceApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String item;
	private Long price;

	public Orders() {
		super();
	}

	public Orders(String item, Long price) {
		super();
		this.item = item;
		this.price = price;
	}

	public Orders(Long id, String item, Long price) {
		super();
		this.id = id;
		this.item = item;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	
}
