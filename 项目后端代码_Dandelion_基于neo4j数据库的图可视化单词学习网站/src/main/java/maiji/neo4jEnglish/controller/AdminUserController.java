package maiji.neo4jEnglish.controller;

import lombok.extern.slf4j.Slf4j;
import maiji.neo4jEnglish.pojo.Neo4jUser;
import maiji.neo4jEnglish.pojo.Result;
import maiji.neo4jEnglish.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired
    private AdminUserService adminUserService;

    @GetMapping
    public Result page(@RequestParam(name = "keyword", defaultValue = "", required = false) String keyword,
                       @RequestParam(name = "page", defaultValue = "1", required = false) Integer page,
                       @RequestParam(name = "size", defaultValue = "10", required = false) Integer size,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("findAllUser 分页查询接口被调用，keyword = {}，page = {}，size = {}，begin = {}，end = {}", keyword, page, size, begin, end);
        return Result.success(adminUserService.findUserByNameContaining(keyword, page, size, begin, end));
    }

    @PostMapping
    public Result create(@RequestBody Neo4jUser neo4jUser){
        log.info("新增用户");
        if (adminUserService.createNewUser(neo4jUser))
            return Result.success();
        else
            return Result.error("用户已存在");
    }

    @PutMapping
    public Result update(@RequestBody Neo4jUser neo4jUser){
        log.info("修改用户");
        adminUserService.updateUser(neo4jUser);
        return Result.success();
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("批量删除用户");
        adminUserService.deleteUser(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        log.info("通过 id 查询用户");
        return Result.success(adminUserService.findById(id));
    }
}