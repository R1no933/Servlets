package servlets.service;

import servlets.dao.FlightDao;
import servlets.dto.FlightDto;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class FlightService {

    private static final FlightService INSTANCE = new FlightService();

    private FlightService() {}

    private final FlightDao flightDao = FlightDao.getInstance();

    public List<FlightDto> flightAll() {
        return flightDao.findAll().stream()
                .map(flightEntity -> FlightDto.builder()
                        .id(flightEntity.getId())
                        .description(
                           """
                                %s -> %s : %s
                           """.formatted(
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
