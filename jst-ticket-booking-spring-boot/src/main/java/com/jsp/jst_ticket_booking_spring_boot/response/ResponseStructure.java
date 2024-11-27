package com.jsp.jst_ticket_booking_spring_boot.response;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ResponseStructure<T> {
	
	private int statusCode;
	private String message;
	private T data;

}
