package maiji.neo4jEnglish.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnglishQuestion {
    private String word;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
}
