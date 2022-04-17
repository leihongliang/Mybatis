package learn.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//SqlSessionFactory-->sqlSession
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            // 1 获取SqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // SqlSession包含面向数据库执行sql命令所需的所有方法
    public static SqlSession getSqlSession(){
        // ture 为自动提交事务
        return sqlSessionFactory.openSession(true);
    }
}
