package com.kafka.kafkapractise.model;

public class Message {

	private final Integer id;
    private final String message;
    
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
    
    
    
    
}
