package br.com.candymachine.model;

public class ResponseModel {

	private int id;
	private String message;
 
	public ResponseModel() {}

	public ResponseModel(Integer id, String message) {
		this.id = id;
		this.message = message;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
  
}
