package servlets.service;

import servlets.dao.TicketDao;
import servlets.dto.TicketDto;
import java.util.List;


import static java.util.stream.Collectors.*;

public class TicketService {
    private static final TicketService INSCTANCE = new TicketService();

    private TicketService() {}

    private final TicketDao ticketDao = TicketDao.getInstance();

    public List<TicketDto> findByFlightId(Long flightId) {
        return ticketDao.findByFlightId(flightId)
                .stream()
                .map(ticketEntity -> TicketDto.builder()
                        .id(ticketEntity.getId())
                        .flightId(ticketEntity.getFlightId())
                        .seatNo(ticketEntity.getSeatNo())
                        .build())
                .collect(toList());
    }

    public static TicketService getInstance() {
        return INSCTANCE;
    }
}
