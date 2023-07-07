package maiji.neo4jEnglish.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.Nested;
import org.springframework.data.neo4j.core.schema.*;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;


@Node
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Edge {

    @Id
    @Property(name = "id")
    private Long id;

    @Property(name = "label")
    private String label;

    @Property(name = "from")
    private Long from;

    @Property(name = "to")
    private Long to;
}
