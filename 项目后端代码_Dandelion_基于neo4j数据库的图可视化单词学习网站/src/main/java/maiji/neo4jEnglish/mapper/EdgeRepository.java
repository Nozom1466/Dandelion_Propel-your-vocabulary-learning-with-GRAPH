package maiji.neo4jEnglish.mapper;

import maiji.neo4jEnglish.pojo.Edge;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EdgeRepository extends Neo4jRepository<Edge, Long> {

    @Query("MATCH (n1:Word)-[r:synonyms|relative|phrase]->(n2:Word) " +
            "RETURN id(r) as id, type(r) as label, id(startNode(r)) as from, id(endNode(r)) as to")
    List<Edge> findAllEdges();

    @Query("MATCH (n1:Word)-[r]->(n2:Word) WHERE id(n2) IN $nodeIds AND id(n1) IN $nodeIds " +
            "RETURN id(r) as id, type(r) as label, id(startNode(r)) as from, id(endNode(r)) as to")
    List<Edge> findAllEdges(@Param("nodeIds") List<Long> nodeIds);
}


