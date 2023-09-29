package servlets.service;

import servlets.dao.FlightDao;
import servlets.dto.FlightDto;

import java.util.List;

import static java.util.stream.Collectors.*;

public class FlightService {

    private static final FlightService INSTANCE = new FlightService();

    private final FlightDao flightDao = FlightDao.getInstance();

    private FlightService() {}

    public List<FlightDto> flightAll() {
        return flightDao.findAll().stream()
                .map(flightEntity -> FlightDto.builder()
                        .id(flightEntity.getId())
                        .description(
                           """
                                ID: %d - %s -> %s : %s
                           """.formatted(flightEntity.getId(),
                                flightEntity.getDepartureAirportCode(),
                                flightEntity.getArrivalAirportCode(),
                                flightEntity.getStatus().toString()
                        ))
                        .build())
                .collect(toList());
    }

    public static FlightService getInstance() {
        return INSTANCE;
    }
}
