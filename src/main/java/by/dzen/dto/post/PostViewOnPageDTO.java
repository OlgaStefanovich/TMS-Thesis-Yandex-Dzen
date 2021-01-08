package by.dzen.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostViewOnPageDTO {

    private long id;
    private String title;
    private String text;
    private Timestamp timestamp;
    private String userName;
    private long view;

    public PostViewOnPageDTO(long id, String title, String text, Timestamp timestamp) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.timestamp = timestamp;
    }
}
