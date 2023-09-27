package servlets.dao;

import servlets.entity.FlightEntity;
import servlets.entity.FlightStatus;
import servlets.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Long, FlightEntity> {

    private static final FlightDao INSTANCE = new FlightDao();

    private FlightDao() {}

    private static final String SQL_FIND_ALL = """
            SELECT * FROM flight
            """;

    @Override
    public List<FlightEntity> findAll() {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_ALL)) {
            ResultSet result = preparedStatement.executeQuery();

            List<FlightEntity> flights = new ArrayList<>();

            while (result.next()) {
                flights.add(buildFlight(result));
            }

            return flights;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<FlightEntity> findById() {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public void update(FlightEntity entity) {

    }

    @Override
    public FlightEntity save(FlightEntity entity) {
        return null;
    }

    public static FlightDao getInstance() {
        return INSTANCE;
    }

    private FlightEntity buildFlight(ResultSet result) throws SQLException {
        return new FlightEntity(
                result.getObject("id", Long.class),
                result.getObject("flight_no", String.class),
                result.getObject("departure_date", Timestamp.class).toLocalDateTime(),
                result.getObject("departure_airport_code", String.class),
                result.getObject("arrival_date", Timestamp.class).toLocalDateTime(),
                result.getObject("arrival_airport_code", String.class),
                result.getObject("aircraft_id", Integer.class),
                FlightStatus.valueOf(result.getObject("status", String.class))
        );
    }
}
