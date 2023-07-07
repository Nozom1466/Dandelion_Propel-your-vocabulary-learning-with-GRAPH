package maiji.neo4jEnglish.mapper;

import maiji.neo4jEnglish.pojo.Word;
import org.springframework.data.domain.Pageable;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface WordRepository extends Neo4jRepository<Word, Long> {

    @Query("MATCH (w:Word) WHERE w.label CONTAINS $keyword RETURN w ORDER BY w.id SKIP $skip LIMIT $limit")
    List<Word> findByWordContaining(String keyword, Pageable pageable);

    @Query("MATCH (w:Word) WHERE w.label CONTAINS $keyword RETURN w ORDER BY w.id")
    List<Word> findByWordContaining(String keyword);

    @Query("MATCH (w1:Word {label: $word1}), (w2:Word {label: $word2})" +
            "CREATE (w1)-[:synonyms]->(w2)")
    void createSynonymsRelation(String word1, String word2);

    @Query("MATCH (w1:Word {label: $word1}), (w2:Word {label: $word2})" +
            "CREATE (w1)-[:antonyms]->(w2)")
    void createAntonymsRelation(String word1, String word2);

    @Query("MATCH (w:Word) WHERE id(w) = $wordId " +
            "OPTIONAL MATCH (w)-[:synonyms]->(s:Word) RETURN id(s)")
    Set<Long> findSynonymIds(@Param("wordId") Long wordId);


    @Query("MATCH (w:Word) WHERE w.id = $wordId " +
            "OPTIONAL MATCH (w)-[:antonyms]->(s:Word) RETURN id(s)")
    Set<Long> findAntonymIds(@Param("wordId") Long wordId);

    @Query("MATCH (w:Word) WHERE w.id = $wordId " +
            "OPTIONAL MATCH (w)-[:synonyms]->(s:Word) RETURN s")
    Set<Word> findSynonymWords(@Param("wordId") Long wordId);

    @Query("MATCH (w:Word) WHERE w.id = $wordId " +
            "OPTIONAL MATCH (w)-[:antonyms]->(s:Word) RETURN s")
    Set<Word> findAntonymWords(@Param("wordId") Long wordId);

    @Query("MATCH (w:Word), (s:Word) WHERE w.id = $wordId AND s.id = $synonymId CREATE (w)-[:synonyms]->(s)")
    void addSynonymForWord(@Param("wordId") Long wordId, @Param("synonymId") Long synonymId);

    @Query("MATCH (w:Word), (a:Word) WHERE w.id = $wordId AND a.id = $antonymId CREATE (w)-[:antonyms]->(a)")
    void addAntonymForWord(@Param("wordId") Long wordId, @Param("antonymId") Long antonymId);
}

