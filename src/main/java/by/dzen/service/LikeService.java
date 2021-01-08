package by.dzen.service;

import by.dzen.dao.LikeDaoImpl;
import by.dzen.entity.Like;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {
  private LikeDaoImpl likeDao;

    public LikeService(LikeDaoImpl likeDao) {
        this.likeDao = likeDao;
    }

    public void insertLike(long userId,int postId) {
        Like like = new Like(userId, postId);
        List<Like> likes = likeDao.getLikeListFromDB();
        for (Like item : likes){
            if (item.getUserId()==userId && item.getPostId()==postId){
                return;
            }
        }
        likeDao.insertLikePost(like);
    }

    public long getLikeNumber(long postId){
        List<Like> likes = likeDao.getLikeListFromDB();
        long likesNumber = 0;
        for (Like item : likes){
            if (item.getPostId()==postId){
                likesNumber++;
            }
        }
        return likesNumber;
    }
}

