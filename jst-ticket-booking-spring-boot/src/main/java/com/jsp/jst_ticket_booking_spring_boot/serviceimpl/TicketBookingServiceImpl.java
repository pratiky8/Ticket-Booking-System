package com.jsp.jst_ticket_booking_spring_boot.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.jst_ticket_booking_spring_boot.dao.TicketBookingDao;
import com.jsp.jst_ticket_booking_spring_boot.dto.TicketBooking;
import com.jsp.jst_ticket_booking_spring_boot.response.ResponseStructure;
import com.jsp.jst_ticket_booking_spring_boot.service.TicketBookingService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketBookingServiceImpl implements TicketBookingService{

	@Autowired
	private TicketBookingDao ticketBookingDao;

	@Autowired
	private ResponseStructure<TicketBooking> responseStructure;

	@Override
	public ResponseStructure<TicketBooking> saveTicketBookingService(TicketBooking ticketBooking) {

		TicketBooking ticketBooking1 = ticketBookingDao.saveTicketBookingDao(ticketBooking);

		if (ticketBooking1 != null) {
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Ticket booked successfully");
			responseStructure.setData(ticketBooking);
			return responseStructure;
		} else {

			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMessage("Something went Worng!!");
			responseStructure.setData(ticketBooking);
			return responseStructure;

		}

	}

}
