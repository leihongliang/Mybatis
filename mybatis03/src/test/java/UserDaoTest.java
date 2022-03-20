import learn.dao.UserMapper;
import learn.pojo.User;
import learn.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;


public class UserDaoTest {

    @Test
    public void getUser(){

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 底层主要应用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.getUsers();
        System.out.println(users.toString());
        sqlSession.close();}

}
