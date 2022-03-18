package dao;

import learn.dao.UserMapper;
import learn.pojo.User;
import learn.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;


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

    @Test
    public void log4j(){
        logger.info("info 进入log4j");

    }



}
