package servlets.dao;

import servlets.entity.TicketEntity;
import servlets.util.ConnectionManager;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDao implements Dao<Long, TicketEntity> {

    private static final TicketDao INSTANCE = new TicketDao();

    private TicketDao() {}

    private static final String SQL_FILTER = """
            SELECT * FROM ticket
            WHERE flight_id = ?
            """;

    public List<TicketEntity> findByFlightId(Long flightId) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FILTER)) {
            preparedStatement.setObject(1, flightId);
            ResultSet result = preparedStatement.executeQuery();
            List<TicketEntity> ticketList = new ArrayList<>();

            while (result.next()) {
                ticketList.add(buildTicket(result));
            }

            return ticketList;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    private TicketEntity buildTicket(ResultSet result) throws SQLException {
        TicketEntity ticketEntity;
        ticketEntity = new TicketEntity(
                result.getObject("id", Long.class),
                result.getObject("passenger_no", String.class),
                result.getObject("passenger_name", String.class),
                result.getObject("flight_id", Long.class),
                result.getObject("seat_no", String.class),
                result.getObject("cost", BigDecimal.class)
        );
        return ticketEntity;
    }

    @Override
    public List<TicketEntity> findAll() {
        return null;
    }

    @Override
    public Optional<TicketEntity> findById() {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(TicketEntity entity) {

    }

    @Override
    public TicketEntity save(TicketEntity entity) {
        return null;
    }

    public static TicketDao getInstance() {
        return INSTANCE;
    }
}
