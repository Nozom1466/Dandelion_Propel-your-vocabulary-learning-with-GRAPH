package maiji.neo4jEnglish.controller;

import lombok.extern.slf4j.Slf4j;
import maiji.neo4jEnglish.mapper.EdgeRepository;
import maiji.neo4jEnglish.mapper.WordRepository;
import maiji.neo4jEnglish.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequestMapping("/neo4j")
public class Neo4jController {

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private EdgeRepository edgeRepository;


    private WordInfo wordForDetail(Word word) {
        return new WordInfo(word,
                wordRepository.findSynonymIds(word.getId()),
                wordRepository.findAntonymIds(word.getId()));
    }

    private List<WordInfo> wordListForDetail(List<Word> wordList) {
        List<WordInfo> wordInfoList = new ArrayList<>();
        for (Word word : wordList)
            wordInfoList.add(new WordInfo(word,
                    wordRepository.findSynonymIds(word.getId()),
                    wordRepository.findAntonymIds(word.getId())));
        return wordInfoList;
    }

    @GetMapping
    public Result getWords(
            @RequestParam(name = "keyword", defaultValue = "", required = false) String keyword,
            @RequestParam(name = "page", defaultValue = "1", required = false) int page,
            @RequestParam(name = "size", defaultValue = "25", required = false) int size) {
        log.info("调用接口 / ，参数：keyword={},page={},size={}",keyword,page,size);
        Pageable pageable = PageRequest.of(page - 1, size);
        List<Word> wordList = wordRepository.findByWordContaining(keyword, pageable);
        List<Long> nodeIds = wordList.stream().map(Word::getId).collect(Collectors.toList());
        List<Edge> edgeList = edgeRepository.findAllEdges(nodeIds);
        return Result.success(new Data(wordList, edgeList));
    }


    @GetMapping("/word")
    public Result getOneWord(@RequestParam(name = "keyword", defaultValue = "", required = false) String keyword) {
        log.info("调用接口 /word ，参数：keyword={}",keyword);
        return Result.success(wordRepository.findByWordContaining(keyword));
    }

    @PostMapping
    public Result getWordsByDetail(
            @RequestParam(name = "keyword", defaultValue = "", required = false) String keyword,
            @RequestParam(name = "page", defaultValue = "1", required = false) int page,
            @RequestParam(name = "size", defaultValue = "25", required = false) int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return Result.success(wordListForDetail(wordRepository.findByWordContaining(keyword, pageable)));
    }

    @GetMapping("/all")
    public Result findAllRelationship() {
        return Result.success(new Data(wordRepository.findAll(),edgeRepository.findAllEdges()));
    }

    @GetMapping("/findAllWords")
    public Result findAllWords() {
        return Result.success(wordRepository.findAll());
    }

    @PostMapping("/findAllWords")
    public Result findAllWordsByDetail() {
        return Result.success(wordListForDetail(wordRepository.findAll()));
    }

    @GetMapping("/Synonyms")
    public Result findSynonymIds(Long id) {
        return Result.success(wordRepository.findSynonymIds(id));
    }

    @GetMapping("/Antonyms")
    public Result findAntonymIds(Long id) {
        return Result.success(wordRepository.findAntonymIds(id));
    }


    @GetMapping("/findSynonymWords")
    public Result findSynonymWords(Long id) {
        return Result.success(wordRepository.findSynonymWords(id));
    }

    @GetMapping("/findAntonymWords")
    public Result findAntonymWords(Long id) {
        return Result.success(wordRepository.findAntonymWords(id));
    }

    @PutMapping
    public Result addRelation(Long id, Long synonymId, Long antonymId) {
        if (id == null)
            return Result.error("参数id必须设定");
        if (synonymId != null) {
            wordRepository.addAntonymForWord(id, synonymId);
        }
        if (antonymId != null)
            wordRepository.addSynonymForWord(id, antonymId);

        return Result.success();
    }
}

