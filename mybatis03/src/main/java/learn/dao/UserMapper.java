package learn.dao;
import learn.pojo.User;
import org.apache.ibatis.annotations.*;
import sun.rmi.server.UnicastServerRef;

import java.util.List;


public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id );

    @Insert("insert into user(id,name,pwd) value (#{id},#{name},#{password})")
    int addUser(User user);

    @Update("update mybatis.user set name=#{name}, pwd=#{password} where id=#{id}")
    int updateUser(User user);

    @Delete(" delete from mybatis.user where id=#{uid}")
    int deleteUser(@Param("uid") int id);

}

