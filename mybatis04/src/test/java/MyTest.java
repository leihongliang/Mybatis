import learn.dao.StudentMapper;
import learn.dao.TeacherMapper;
import learn.pojo.Student;
import learn.pojo.Teacher;
import learn.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacehr(1);
        System.out.println(teacher);
        sqlSession.close();
    }
    /**
     * 按照查询嵌套处理
     */
    @Test
    public  void testStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudent();
        System.out.println(students.toString());
        sqlSession.close();
    }

    /**
     * 按照结果嵌套处理
     */
    @Test
    public  void testStudent2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudent2();
        System.out.println(students.toString());
        sqlSession.close();
    }

}
