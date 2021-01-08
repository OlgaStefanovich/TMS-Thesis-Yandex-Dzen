package by.dzen.dao;

import by.dzen.entity.Like;

import java.util.List;

public interface LikeDao {

    void insertLikePost(Like like);
    List<Like> getLikeListFromDB();
}
