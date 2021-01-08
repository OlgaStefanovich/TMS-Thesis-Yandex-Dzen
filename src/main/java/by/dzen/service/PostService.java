package by.dzen.service;

import by.dzen.dao.PostDaoImpl;
import by.dzen.dao.UserDaoImpl;
import by.dzen.dto.post.PostUserAddDTO;
import by.dzen.dto.post.PostViewOnPageDTO;
import by.dzen.entity.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private PostDaoImpl postDao;
    private UserDaoImpl userDao;

    public PostService(PostDaoImpl postDao, UserDaoImpl userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    public void addPost(PostUserAddDTO postUserAddDTO, long idUser){
       Post post = new Post(postUserAddDTO.getTitle(),postUserAddDTO.getDescription(),postUserAddDTO.getText(), new java.sql.Timestamp(System.currentTimeMillis()));
       postDao.createPost(post, idUser);
    }

    public List<PostViewOnPageDTO> postViewOnTheFirstPage(){
        List<Post> posts = postDao.getListPostsToFirstPage();
        List<PostViewOnPageDTO> postViewOnPageDTOS = new ArrayList<>();
        for(Post item : posts){
            postViewOnPageDTOS.add(new PostViewOnPageDTO(item.getId(),item.getTitle(),item.getText(),item.getTimestamp()));
        }
        return postViewOnPageDTOS;
    }

    public PostViewOnPageDTO getPostViewOnPage(long idPost){
        Post postFromDB = postDao.getPostToPage(idPost);
        String userNameWhoWritePost = null;
        if (userDao.findById(postDao.getPostToPage(idPost).getUserId()).isPresent()){
            userNameWhoWritePost = userDao.findById(postDao.getPostToPage(idPost).getUserId()).get().getName();
        }
        return new PostViewOnPageDTO(postFromDB.getId(),postFromDB.getTitle(),postFromDB.getText(),postFromDB.getTimestamp(), userNameWhoWritePost, postFromDB.getView());
    }

    public void insertView(long id) {
            postDao.insertViewPost(id);

        }
    }



