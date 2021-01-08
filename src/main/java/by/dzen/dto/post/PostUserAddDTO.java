package by.dzen.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostUserAddDTO {

    private String title;
    private String description;
    private String text;
    private Timestamp timestamp;

}
