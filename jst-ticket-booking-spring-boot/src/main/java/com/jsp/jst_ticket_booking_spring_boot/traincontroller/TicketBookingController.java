package com.jsp.jst_ticket_booking_spring_boot.traincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.jst_ticket_booking_spring_boot.dto.TicketBooking;
import com.jsp.jst_ticket_booking_spring_boot.response.ResponseStructure;
import com.jsp.jst_ticket_booking_spring_boot.service.TicketBookingService;

@RestController
@RequestMapping(value = "/ticketBooing")
public class TicketBookingController {

	@Autowired
	private TicketBookingService ticketBookingService;

	@PostMapping(value = "/saveTicket")
	public ResponseStructure<TicketBooking> saveTicketBookingController(@RequestBody TicketBooking ticketBooking) {

		return ticketBookingService.saveTicketBookingService(ticketBooking);

	}

}
