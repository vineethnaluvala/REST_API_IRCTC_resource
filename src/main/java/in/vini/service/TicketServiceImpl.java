package in.vini.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import in.vini.request.Passenger;
import in.vini.response.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	private Map<Integer,Ticket> tickets=new HashMap<>();
	private Integer ticketNum = 123;
	
	@Override
	public Ticket bookTicket(Passenger passenger) {
		
		Ticket t = new Ticket();
		BeanUtils.copyProperties(passenger, t);
		t.setTicketNo(ticketNum);
		t.setStatus("booked");
		t.setPrice(450.00);
	
		tickets.put(ticketNum, t);
		ticketNum++;

		return t;
	}
	
	@Override
	public Ticket getTicket(Integer ticketNo) {

	 if(tickets.containsKey(ticketNo)) {
		return tickets.get(ticketNo);
	 }
		return null;
	}

	

}


















