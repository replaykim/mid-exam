package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by blue on 2017-04-19.
 */
public interface ConnectionMaker {
    Connection getConnection() throws ClassNotFoundException, SQLException;
}