package kr.ac.jejunu;

/**
 * Created by blue on 2017-04-19.
 */
public class DaoFactory {

    public UserDao getUserDao() {
        return new UserDao(getConnectionMaker());
    }

    public JejuConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }
}
