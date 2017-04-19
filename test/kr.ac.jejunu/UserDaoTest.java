package kr.ac.jejunu;

import kr.ac.halla.HallaConnectionMaker;
import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Created by replay on 2017. 3. 15..
 *
 * test 는 다돌리는 습관!
 */
public class UserDaoTest {

    @Test
    public void jejuGet() throws SQLException, ClassNotFoundException {
        // id 를 주면 이름과 비밀번호를 가져온다.

        Long id = 1l;
        String name  = "김재현";
        String password = "12334";

        UserDao userDao =new UserDao(new JejuConnectionMaker());

        User user = userDao.get(id);

        assertThat(id, is(user.getId()));
        assertThat(name, is(user.getName()));
        assertThat(password, is(user.getPassword()));

    }

    @Test
    public void jejuAdd() throws SQLException, ClassNotFoundException {
        Long id = 10l;
        String name = "얍얍얍";
        String password = "12345";

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);

        UserDao userDao = new UserDao(new JejuConnectionMaker());
        userDao.add(user);

        User resultUser = userDao.get(id);

        assertThat(id, is(resultUser.getId()));
        assertThat(name, is(resultUser.getName()));
        assertThat(password, is(resultUser.getPassword()));
    }

    @Test
    public void hallaGet() throws SQLException, ClassNotFoundException {
        // id 를 주면 이름과 비밀번호를 가져온다.

        Long id = 1l;
        String name  = "김재현";
        String password = "12334";

        UserDao userDao = new UserDao(new HallaConnectionMaker());

        User user = userDao.get(id);

        assertThat(id, is(user.getId()));
        assertThat(name, is(user.getName()));
        assertThat(password, is(user.getPassword()));

    }

    @Test
    public void hallaAdd() throws SQLException, ClassNotFoundException {
        Long id = 10l;
        String name = "얍얍얍";
        String password = "12345";

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPassword(password);

        UserDao userDao = new UserDao(new HallaConnectionMaker());
        userDao.add(user);

        User resultUser = userDao.get(id);

        assertThat(id, is(resultUser.getId()));
        assertThat(name, is(resultUser.getName()));
        assertThat(password, is(resultUser.getPassword()));
    }
}
