package com.employ.Detalis.Entity;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employ_detalis")
public class Employ {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employ_id")
	private int id;
	
	@Column(name = "employ_name")
	private String name;
	
	@Column(name = "employ_phone")
	private String phone;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Employ(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public Employ() {
		super();
		
	}

	@Override
	public String toString() {
		return "Employ [id=" + id + ", name=" + name + ", phone=" + phone + "]";
	}
	
	
	
	
}
