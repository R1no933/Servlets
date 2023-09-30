package servlets.dao;

import lombok.SneakyThrows;
import servlets.entity.UserEntity;
import servlets.util.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.*;

public class UserDao implements Dao<Integer, UserEntity> {
    private static final UserDao INSTANCE = new UserDao();
    private static final String SQL_SAVE =
            "INSERT INTO users (username, birthday, email, password, role, gender) VALUES (?, ?, ?, ?, ?, ?)";

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public Optional<UserEntity> findById() {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(UserEntity entity) {
    }

    @Override
    @SneakyThrows
    public UserEntity save(UserEntity entity) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_SAVE, RETURN_GENERATED_KEYS)) {
            preparedStatement.setObject(1, entity.getUsername());
            preparedStatement.setObject(2, entity.getBirthday());
            preparedStatement.setObject(3, entity.getEmail());
            preparedStatement.setObject(4, entity.getPassword());
            preparedStatement.setObject(5, entity.getRole().name());
            preparedStatement.setObject(6, entity.getGender().name());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            entity.setId(resultSet.getObject("id", Integer.class));

            return entity;
        }
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
