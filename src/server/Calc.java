package server;

import java.io.Serializable;

public class Calc implements Serializable{
	private int id ; 
	private int idUser; 
	private String history ;
	private String createAt;
	public Calc(int id, int idUser, String history, String createAt) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.history = history;
		this.createAt = createAt;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	} 
	
	
}
