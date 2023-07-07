package maiji.neo4jEnglish.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VToken {
    private String Token;
    private Short toefl;
    private Short ielts;
    private Short gre;
    private Short permission;
}
