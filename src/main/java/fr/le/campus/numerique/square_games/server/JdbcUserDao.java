package fr.le.campus.numerique.square_games.server;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component("jdbcUserDao")
public class JdbcUserDao implements UserDao {

    private final NamedParameterJdbcTemplate database;

        public JdbcUserDao(NamedParameterJdbcTemplate database) {
            this.database = database;
        }


    @Override
    public List<UserEntity> findAll() {
        String query = "SELECT * FROM users";
        return database.query(query, (resultSet, rowNum) -> {
            UserEntity user = new UserEntity();
            user.setId(resultSet.getString("id"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            return user;
        });
    }

    @Override
    public Optional<UserEntity> findById(String userId) {
        String query = "SELECT * FROM users WHERE id = :id";

        Map<String, Object> params = new HashMap<>();
        params.put("id", userId);

        List<UserEntity> users = database.query(query, params, (resultSet, rowNum) -> {
            UserEntity user = new UserEntity();
            user.setId(resultSet.getString("id"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            return user;
        });

        return users.stream().findFirst();
    }
}
