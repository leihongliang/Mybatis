package learn.dao;

import learn.pojo.User;
import learn.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    /**
     * 入门，获取数据库中的User
     */
    @Test
    public void test(){
        // 获得sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 方式一：getMapper
        // 执行sql
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();
        System.out.println(userList.toString());

        //方式二：
        List<Object> userList2 = sqlSession.selectList("learn.dao.UserDao.getUserList");
        System.out.println(userList2.toString());

        sqlSession.close();
    }

    /**
     *select语句 取出一条数据，一条条件
     */
    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }

    /**
     *insert语句 一条数据
     */
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
//        int res = mapper.addUser(new User(4,"lhl", "1234"));
//        if (res > 0){
//            System.out.println("success!"+res);
//        }
        mapper.addUser(new User(5,"lhl", "1234"));
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    /**
     * update语句 一条数据
     */

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.updateUser(new User(4,"lhl", "123456"));
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.deleteUser(5);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 用map进行insert
     */
    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("userId",6);
        stringObjectHashMap.put("userName","map");
        stringObjectHashMap.put("userPwd","123");
        mapper.addUser2(stringObjectHashMap);
        //提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 用map进行select，多个参数查询
     */
    @Test
    public void getUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId",4);
        map.put("userName","lhl");
        User userByID2 = mapper.getUserByID2(map);
        System.out.println(userByID2);
        sqlSession.close();
    }

    /**
     * 用map进行select，多个参数查询
     */
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserLike("l");

        System.out.println(userList.toString());
        sqlSession.close();
    }

}
