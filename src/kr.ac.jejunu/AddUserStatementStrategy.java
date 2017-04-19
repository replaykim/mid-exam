package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by blue on 2017-04-19.
 */
public class AddUserStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makeStatement(Connection connection, Object object) throws SQLException {
        PreparedStatement preparedStatement;

        User user = (User) object;

        preparedStatement = connection.prepareStatement("INSERT INTO userdata VALUES (?,?,?)");
        preparedStatement.setLong(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3,user.getPassword());
         return preparedStatement;
    }
}
