package by.dzen.dao;

import by.dzen.entity.Post;

import java.util.List;

public interface PostDao {

    void createPost(Post post, long id);
    List<Post> getListPostsToFirstPage();
    Post getPostToPage(long id);
    void insertViewPost(long id);
}
