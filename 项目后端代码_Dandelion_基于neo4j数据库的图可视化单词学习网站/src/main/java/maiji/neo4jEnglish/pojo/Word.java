package maiji.neo4jEnglish.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.*;

@Data
@Node
@NoArgsConstructor
@AllArgsConstructor
public class Word {
    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "label")
    private String label;

    @Property(name = "info")
    private String info;

    @Property(name = "value")
    private Integer value;

    @Property(name = "level")
    private String level;

    @Property(name = "categories")
    private String categories;
}

