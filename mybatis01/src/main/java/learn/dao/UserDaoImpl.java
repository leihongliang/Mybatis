package learn.dao;
import learn.pojo.User;
import java.util.List;
import java.util.Map;

/**
 * 传统方法否
 */
public class UserDaoImpl implements UserDao{
    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public List<User> getUserList() {
        //执行sql语句，连接数据库
        String sql= "select * from mybatis.user";
        //结果集 ResultSet
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }

    @Override
    public int addUser2(Map<String, Object> map) {
        return 0;
    }

    @Override
    public User getUserByID2(Map<String, Object> map) {
        return null;
    }

    @Override
    public List<User> getUserLike(String value) {
        return null;
    }
}
