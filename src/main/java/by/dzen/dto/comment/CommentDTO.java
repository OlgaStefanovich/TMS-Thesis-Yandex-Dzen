package by.dzen.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

    private String text;
    private Date date;
    private String userName;

    public CommentDTO(String text) {
        this.text = text;
    }

}
