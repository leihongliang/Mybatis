package learn.dao;

import learn.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {
    @Select("select * from mybatis.teacher where id = #{id}")
    Teacher getTeacehr(@Param("id") int id);

}
