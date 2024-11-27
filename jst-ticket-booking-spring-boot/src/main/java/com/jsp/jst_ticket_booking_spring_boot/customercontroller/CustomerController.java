package com.jsp.jst_ticket_booking_spring_boot.customercontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.jst_ticket_booking_spring_boot.dto.Customer;
import com.jsp.jst_ticket_booking_spring_boot.response.ResponseStructure;
import com.jsp.jst_ticket_booking_spring_boot.service.CustomerService;

import lombok.AllArgsConstructor;

//@Controller
//@ResponseBody
@RestController
@RequestMapping(value = "/customer")
@AllArgsConstructor
public class CustomerController {

	 private CustomerService customerService;

	    @PostMapping(value = "/register")
	    public ResponseStructure<Customer> saveCustomerController(@RequestBody Customer customer) {
	        return customerService.saveCustomerService(customer);
	    }

	    @GetMapping(value = "/login/{email}/{password}")
	    public ResponseStructure<Customer> loginCustomerWithEmailAndPasswordController(@PathVariable String email, @PathVariable String password) {
	       return customerService.loginCustomerWithEmailAndPasswordService(email,password);
	    }

}
