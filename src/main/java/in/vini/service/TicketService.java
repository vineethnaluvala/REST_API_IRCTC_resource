package in.vini.service;

import in.vini.request.Passenger;
import in.vini.response.Ticket;

public interface TicketService {

	public Ticket getTicket(Integer ticketNo);

	public Ticket bookTicket(Passenger passenger);

}
