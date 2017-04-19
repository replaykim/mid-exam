package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by blue on 2017-04-19.
 */
public interface StatementStrategy {
    PreparedStatement makeStatement(Connection connection , Object object) throws SQLException;
}
