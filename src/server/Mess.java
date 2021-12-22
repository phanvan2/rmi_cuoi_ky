package server;

import java.io.Serializable;

public class Mess implements Serializable {
	private int id ;
	private int idUser ; 
	private String nameUser ; 
	private String content ; 
	private String createAt ;
	public Mess(int id, int idUser, String nameUser, String content, String createAt) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.nameUser = nameUser;
		this.content = content;
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
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateAt() {
		return createAt;
	}
	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	} 
	
}
