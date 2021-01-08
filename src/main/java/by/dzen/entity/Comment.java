package by.dzen.entity;

import java.sql.Date;

public class Comment {
    private long id;
    private String text;
    private long userId;
    private long postId;
    private Date date;

    public Comment(String text, long userId, long postId) {
        this.text = text;
        this.userId = userId;
        this.postId = postId;
    }

    public Comment(String text) {
        this.text = text;
    }

    public Comment(String text, long userId, long postId, Date date) {
        this.text = text;
        this.userId = userId;
        this.postId = postId;
        this.date = date;
    }

    public Comment() {
    }

    public Comment(long id, String text, long userId, long postId, Date date) {
        this.id = id;
        this.text = text;
        this.userId = userId;
        this.postId = postId;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
