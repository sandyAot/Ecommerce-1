package com.example.demo;

 final public class employee {
	private int id;
	private String name;
	private int dpid;
	private int salary;
	public int getId() {
		return id;
	}
	public employee() {
		
	}
	
	public employee(int id, String name, int dpid, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.dpid = dpid;
		this.salary = salary;
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
	public int getDpid() {
		return dpid;
	}
	public void setDpid(int dpid) {
		this.dpid = dpid;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "employee [id=" + id + ", name=" + name + ", dpid=" + dpid + ", salary=" + salary + "]";
	}
	
	

}
