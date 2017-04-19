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
        String sql = "SELECT * FROM userdata WHERE id = ?";
        Object[] params = new Object[]{id};
        return jdbcContext.queryForObject(sql, params);
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO userdata VALUES (?,?,?)";
        Object[] params = new Object[]{user.getId(), user.getName(), user.getPassword()};
        jdbcContext.update(sql, params);
    }

    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM userdata WHERE id = ?";
        Object[] params = new Object[]{id};

        jdbcContext.update(sql, params);
    }

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }
}
