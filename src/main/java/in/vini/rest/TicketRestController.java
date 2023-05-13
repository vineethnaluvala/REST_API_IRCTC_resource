package in.vini.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.vini.request.Passenger;
import in.vini.response.Ticket;
import in.vini.service.TicketServiceImpl;

@RestController
public class TicketRestController {

	@Autowired
	private TicketServiceImpl service;
	
	@PostMapping(value="/book",
			consumes=	{"application/json"},
			produces=	{"application/json"}
			)
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger){
		
		System.out.println(passenger);
		
		Ticket bookTicket = service.bookTicket(passenger);
		
		
		return new ResponseEntity<>(bookTicket, HttpStatus.CREATED);
		
	}
	@GetMapping(value= "/get/{id}",
			produces = {"application/json"}
			)
	public Ticket getTicket(@PathVariable("id")Integer ticketNo) {
		Ticket ticket = service.getTicket(ticketNo);
		
		return ticket;
		
	}
}












