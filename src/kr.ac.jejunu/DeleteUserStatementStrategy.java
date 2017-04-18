package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by blue on 2017-04-18.
 */
public class DeleteUserStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makeStatement(Object object, Connection connection) throws SQLException {
        Long id = (Long) object;
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("DELETE FROM userdata WHERE id = ?");
        preparedStatement.setLong(1, id);

        return preparedStatement;
    }
}
