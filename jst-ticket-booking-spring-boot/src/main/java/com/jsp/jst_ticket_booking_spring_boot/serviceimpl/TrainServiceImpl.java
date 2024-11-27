package com.jsp.jst_ticket_booking_spring_boot.serviceimpl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.jst_ticket_booking_spring_boot.dao.CustomerDao;
import com.jsp.jst_ticket_booking_spring_boot.dao.TrainDao;
import com.jsp.jst_ticket_booking_spring_boot.dto.Customer;
import com.jsp.jst_ticket_booking_spring_boot.dto.Train;
import com.jsp.jst_ticket_booking_spring_boot.response.ResponseStructure;
import com.jsp.jst_ticket_booking_spring_boot.service.TrainService;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TrainServiceImpl implements TrainService {

	private TrainDao trainDao;

	private HttpSession httpSession;

	private ResponseStructure<Train> responseStructure;

	private ResponseStructure<List<Train>> structure;

	@Override
	public ResponseStructure<Train> saveTrainService(Train train) {

		if (httpSession.getAttribute("adminSession") != null) {
			Train train1 = trainDao.saveTrainDao(train);
			if (train1 != null) {

				responseStructure.setStatusCode(HttpStatus.CREATED.value());
				responseStructure.setMessage("Train Registered!!!");
				responseStructure.setData(train1);
				return responseStructure;

			} else {

				responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
				responseStructure.setMessage("Train Not Registered!!! something went wrong");
				responseStructure.setData(null);
				return responseStructure;
			}
		} else {

			responseStructure.setStatusCode(HttpStatus.UNAUTHORIZED.value());
			responseStructure.setMessage("please loggin with admin and then train details");
			responseStructure.setData(null);
			return responseStructure;

		}

	}

	@Override
	public ResponseStructure<Train> searchTrainByNumberService(long trainNumber) {

		Train train1 = trainDao.searchTrainByNumberDao(trainNumber);

		if (train1 != null) {

			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("train details!!!");
			responseStructure.setData(train1);
			return responseStructure;

		} else {

			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("train number is invalid!!!");
			responseStructure.setData(null);
			return responseStructure;

		}

	}

	@Override
	public ResponseStructure<List<Train>> searchTrainBySourceAndDestinationService(String source, String destination) {

		List<Train> trains = trainDao.searchTrainBySourceAndDestinationDao(source, destination);

		if (!trains.isEmpty()) {

			structure.setStatusCode(HttpStatus.FOUND.value());
			structure.setMessage("train details are!!!");
			structure.setData(trains);
			return structure;

		} else {

			structure.setStatusCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("given source and destination trains are not available!!!");
			structure.setData(null);
			return structure;

		}
	}

}
