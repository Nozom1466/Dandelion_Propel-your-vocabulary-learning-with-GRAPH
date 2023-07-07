package maiji.neo4jEnglish;

import maiji.neo4jEnglish.mapper.WordRepository;
import maiji.neo4jEnglish.mapper.EdgeRepository;
import maiji.neo4jEnglish.pojo.Edge;
import maiji.neo4jEnglish.pojo.Word;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class Neo4jEnglishApplicationTests {

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private EdgeRepository edgeRepository;

    //@BeforeEach
//    @Test
//    void deleteAll() {
//        wordRepository.deleteAll();
//    }

    @Test
    void relationship() {
        Word good = new Word();
        good.setLabel("good");
        good.setInfo("好的");
        good.setCategories("adj");

        Word nice = new Word();
        nice.setLabel("nice");
        nice.setInfo("好的");
        nice.setCategories("adj");


        Word good2 = new Word();
        good2.setLabel("good2");
        good2.setInfo("好的");
        good2.setCategories("adj");

        wordRepository.save(good);
        wordRepository.save(nice);
        wordRepository.save(good2);
        wordRepository.createSynonymsRelation("good", "nice");
        wordRepository.createSynonymsRelation("good", "good2");
        wordRepository.createSynonymsRelation("nice", "good");
    }

    @Test
    void MD5_Test()
    {
        String originalText = "1111111111";
        String encryptedText = DigestUtils.md5Hex(originalText);
        System.out.println("原始文本：" + originalText);
        System.out.println("加密后文本：" + encryptedText);
    }

    @Test
    void EdgeTest()
    {
        List<Edge> allRelationship = edgeRepository.findAllEdges();
        System.out.println(allRelationship);
    }
}
