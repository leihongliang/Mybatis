package learn.dao;
import learn.pojo.Blog;
import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int addBlog(Blog Blog);
    List<Blog> queryBlogIf0(Map map);
    List<Blog> queryBlogIf1(Map map);
    List<Blog> queryBlogIf2(Map map);
    List<Blog> queryBlogChoose(Map map);
    int updateBlog(Map map);
    List<Blog> queryBlogForeach(Map map);


}
