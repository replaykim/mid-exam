package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by blue on 2017-04-19.
 */
public class GetUserStatementStrategy implements StatementStrategy {
        Long id ;
    public GetUserStatementStrategy(Long id) {
        this.id = id;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("SELECT * FROM userdata WHERE id = ?");
        preparedStatement.setLong(1, id);
        return preparedStatement;
    }
}
