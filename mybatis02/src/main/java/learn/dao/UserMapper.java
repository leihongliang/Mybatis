package learn.dao;
import learn.pojo.User;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getUserLike(String value);
    User getUserById(int id);
    List<User> getUserByLimit(Map<String, Integer>map);
    List<User> getUserByRowBounds();
}

