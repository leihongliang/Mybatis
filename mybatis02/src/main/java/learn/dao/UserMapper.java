package learn.dao;
import learn.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getUserLike(String value);
    User getUserById(int id);

}

