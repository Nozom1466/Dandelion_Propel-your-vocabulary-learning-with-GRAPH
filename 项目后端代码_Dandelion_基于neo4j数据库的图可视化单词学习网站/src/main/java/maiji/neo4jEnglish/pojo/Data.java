package maiji.neo4jEnglish.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.List;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class Data {
    private List<Word> nodes;
    private List<Edge> edges;
}
