package maiji.neo4jEnglish.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WordInfo {
    private Word word;
    private Set<Long> antonyms;
    private Set<Long> synonyms;
}
