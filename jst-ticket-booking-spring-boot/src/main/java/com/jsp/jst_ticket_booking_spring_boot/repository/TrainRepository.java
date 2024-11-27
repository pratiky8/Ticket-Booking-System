package com.jsp.jst_ticket_booking_spring_boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.jst_ticket_booking_spring_boot.dto.Train;

public interface TrainRepository extends JpaRepository<Train,Long> {
	
	public Train findByTrainNumber(long trainNumber);
	public List<Train> findBySourceAndDestination(String source,String destination);

}
