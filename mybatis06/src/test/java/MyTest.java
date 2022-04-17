import learn.dao.BlogMapper;
import learn.pojo.Blog;
import learn.utils.IDutils;
import learn.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void addBlogTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务");
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test//if
    public void queryBlogIf0(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title", "Spring");
        map.put("author", "狂神说");
        List<Blog> blogs = mapper.queryBlogIf0(map);
        for (Blog blog : blogs){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test//trim
    public void queryBlogIf1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title", "Spring");
        map.put("author", "狂神说");
        List<Blog> blogs = mapper.queryBlogIf1(map);
        for (Blog blog : blogs){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test// choose, where, otherwise
    public void queryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
//        map.put("title", "Spring");
        map.put("author", "狂神说");
        map.put("views", 9999);
        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test// update
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("id","3dd46e80 b14f 4ab9 8636 642a51424ab0");
        map.put("title","Mybatis2");
//        map.put("author","狂神说2");

        mapper.updateBlog(map);
        sqlSession.close();
    }

    @Test// SQL片段
    public void queryBlogIf2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title", "Spring");
        map.put("author", "狂神说");
        List<Blog> blogs = mapper.queryBlogIf2(map);
        for (Blog blog : blogs){
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test// SQL片段
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        map.put("ids", ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs){
            System.out.println(blog);
        }
        sqlSession.close();
    }
}
