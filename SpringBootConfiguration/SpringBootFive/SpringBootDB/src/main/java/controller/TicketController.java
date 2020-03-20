package controller;

import dao.TicketDao;
import model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    //
    @Autowired
    private TicketDao dao;

    @PostMapping("/bookTickets")
    public String bookTicket(@RequestBody List<Ticket> tickets){
           dao.saveAll(tickets);
        return " Ticket booked:" + tickets.size();
    }

    @GetMapping("/getTicket")
    public List<Ticket> getTickets() {
        //
        return (List<Ticket>) dao.findAll();
    }


}


// Resource : https://www.youtube.com/watch?v=voA01jXkXtk+