package by.dzen.entity;


import java.sql.Timestamp;

public class Post {
    private long id;
    private String title;
    private String description;
    private String text;
    private Timestamp timestamp;
    private long view;
    private long userId;


    public Post(String title, String description, String text, Timestamp timestamp) {
        this.title = title;
        this.description = description;
        this.text = text;
        this.timestamp = timestamp;
    }

    public Post(long id, String title, String text, Timestamp timestamp) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.timestamp = timestamp;
    }

    public Post(long id, String title, String text, long view, Timestamp timestamp) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.view = view;
        this.timestamp = timestamp;
    }

    public Post(long id, String title, String text, long view, Timestamp timestamp,long userId) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.view = view;
        this.timestamp = timestamp;
        this.userId = userId;
    }

    public Post(long id, String title, String description, String text, Timestamp timestamp, long view, long userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.text = text;
        this.timestamp = timestamp;
        this.view = view;
        this.userId = userId;
    }

    public Post() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public long getView() {
        return view;
    }

    public void setView(long view) {
        this.view = view;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
