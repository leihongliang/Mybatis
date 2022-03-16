package learn.dao;
import learn.pojo.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserDao {
    // 查询全部用户
    List<User> getUserList();

    // 根据ID查询用户
    User getUserById(int id);

    // 【增】int代表受影响的行数
    int addUser(User user);

    // 【改】int代表受影响的行数
    int updateUser(User user);

    int deleteUser(int id);

    int addUser2(Map<String, Object> map);

    User getUserByID2(Map<String, Object>map);

    List<User> getUserLike(String value);

}

