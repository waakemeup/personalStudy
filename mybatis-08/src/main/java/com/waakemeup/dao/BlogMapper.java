package com.waakemeup.dao;

import com.waakemeup.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    int addBook(Blog blog);

    //查询博客
    List<Blog> queryBlogIF(Map map);

    //更新博客
    int updateBlog(Map map);

    //选择博客
    List<Blog> queryBlogChoose(Map map);

    List<Blog> queryBlogForeach(Map map);
}
