package server;

import java.io.Serializable;

public class User implements Serializable {
	private int id ; 
	private String name ; 
	public User(int id , String name) {
		super();
		this.id = id ; 
		this.name = name ; 
		// TODO Auto-generated constructor stub
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

	
	
}
