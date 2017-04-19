package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by replay on 2017. 3. 15..
 *
 * try/catch 와 throw => 자신감의 차이!
 *
 * jdbc는 컴파일할땐 필요없는 런타임 클래스
 * Connection, preparedStatement, resultSrt 는 스트림 클래스이기때문에 자원낭비를 방지하게 위해 닫아준다.
 *
 *
 * extract method
 */

public class UserDao {

    JdbcContext jdbcContext;

    public User get(Long id) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("SELECT * FROM userdata WHERE id = ?");
            preparedStatement.setLong(1, id);
            return preparedStatement;
        };
        return jdbcContext.jdbcContextWithStatementStrategyForGet(statementStrategy);
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement;

            preparedStatement = connection.prepareStatement("INSERT INTO userdata VALUES (?,?,?)");
            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3,user.getPassword());
            return preparedStatement;
        };
        jdbcContext.jdbcContexWithStatementStrategyForUpdate(statementStrategy);
    }

    public void delete(Long id) throws SQLException {
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("DELETE FROM userdata WHERE id = ?");
            preparedStatement.setLong(1, id);

            return preparedStatement;
        };
        jdbcContext.jdbcContexWithStatementStrategyForUpdate(statementStrategy);
    }


    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }
}
