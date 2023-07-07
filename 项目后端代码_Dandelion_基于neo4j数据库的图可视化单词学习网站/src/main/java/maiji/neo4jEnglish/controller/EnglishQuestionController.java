package maiji.neo4jEnglish.controller;

import lombok.extern.slf4j.Slf4j;
import maiji.neo4jEnglish.mapper.EnglishQuestionMapper;
import maiji.neo4jEnglish.pojo.EnglishQuestion;
import maiji.neo4jEnglish.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/EQuestion")
public class EnglishQuestionController {
    @Autowired
    private EnglishQuestionMapper englishQuestionMapper;

    @GetMapping
    public Result getEnglishQuestion(Long id){
        log.info("getEnglishQuestion 函数被调用，id = {}", id);
        EnglishQuestion questionById = englishQuestionMapper.getQuestionById(id);
        if (questionById != null)
            return Result.success(questionById);
        return Result.error("查询失败");
    }

    @GetMapping("/random")
    public Result getEnglishQuestionByRandom(){
        log.info("getEnglishQuestionByRandom 函数被调用");
        return Result.success(englishQuestionMapper.getQuestionByRandom());
    }
}
