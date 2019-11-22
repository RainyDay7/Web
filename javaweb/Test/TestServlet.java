import com.nuesoft.dao.UserDao;
import com.nuesoft.po.User;
import org.junit.Test;

public class TestServlet {
    @Test
    public void testAddUser(){
        UserDao userDao = new UserDao();
        int rows = userDao.addUser(new User(0, "123", "123", "123", "123", "123"));
        System.out.println(rows);
    }
}
