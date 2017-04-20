package kr.ac.jejunu;

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

    public User get(Long id) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from userdata where id = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        User user = new User();
        user.setId(resultSet.getLong("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));

        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO userdata VALUES (?,?,?)");
        preparedStatement.setLong(1,user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getPassword());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://117.17.102.106:3306/replayDB?characterEncoding=utf-8", "root", "1234");
    }
}
