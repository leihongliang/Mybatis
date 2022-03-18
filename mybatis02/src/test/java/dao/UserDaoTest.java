package dao;

import learn.dao.UserMapper;
import learn.pojo.User;
import learn.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import java.util.HashMap;
import java.util.List;


public class UserDaoTest {
    static Logger logger = Logger.getLogger(UserDaoTest.class);
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);

        System.out.println(user.toString());
        sqlSession.close();
    }

    /**
     * 日志
     */
    @Test
    public void log4j(){
        logger.info("info 进入log4j");
    }

    /**
     * 分页查询
     */
    @Test
    public void getUserByLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> list = mapper.getUserByLimit(map);
        System.out.println(list);
        sqlSession.close();
    }
    /**
     * RowBounds分页查询
     */
    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(1, 2);
        List<User> list = sqlSession.selectList("learn.dao.UserMapper.getUserByRowBounds", null, rowBounds);
        System.out.println(list);
        sqlSession.close();
    }




}
