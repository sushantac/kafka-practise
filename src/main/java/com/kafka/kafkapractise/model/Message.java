package com.kafka.kafkapractise.model;

public class Message {

	private Integer id;
    private String message;
    
    public Message() {
    	
    }
    
    public Message(Integer id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	
    public Integer getId() {
		return id;
	}
	
    
    public String getMessage() {
		return message;
	}
    

	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + "]";
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
    
    
}
