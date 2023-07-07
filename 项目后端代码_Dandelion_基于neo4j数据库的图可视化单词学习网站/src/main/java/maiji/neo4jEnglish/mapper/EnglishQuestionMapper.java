package maiji.neo4jEnglish.mapper;

import maiji.neo4jEnglish.pojo.EnglishQuestion;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.StringTypeHandler;

import java.util.List;

@Mapper
public interface EnglishQuestionMapper {
    @Select("SELECT id, word, option1, option2, option3, option4, answer FROM EnglishQuestion WHERE id = #{id}")
    EnglishQuestion getQuestionById(Long id);

    @Select("SELECT id, word, option1, option2, option3, option4, answer FROM EnglishQuestion ORDER BY RAND() LIMIT 1")
    EnglishQuestion getQuestionByRandom();
}
