package maiji.neo4jEnglish.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Neo4jUser {
    private Integer id;
    private String username;
    private String password;
    private Short permission;
    private Short toefl;
    private Short ielts;
    private Short gre;
    private LocalDateTime createTime;
}
