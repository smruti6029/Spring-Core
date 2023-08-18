package com.SpringCore.Ref;

public class A {

	
	private int id;
	
	private String name;
	
	private B obj;

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

	public B getObj() {
		return obj;
	}

	public void setObj(B obj) {
		this.obj = obj;
	}

	public A(int id, String name, B obj) {
		super();
		this.id = id;
		this.name = name;
		this.obj = obj;
	}

	public A() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "A [id=" + id + ", name=" + name + ", obj=" + obj + "]";
	}

	
	
	
	
}
