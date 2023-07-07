package maiji.neo4jEnglish.controller;

import lombok.extern.slf4j.Slf4j;
import maiji.neo4jEnglish.pojo.Neo4jUser;
import maiji.neo4jEnglish.pojo.Result;
import maiji.neo4jEnglish.pojo.VToken;
import maiji.neo4jEnglish.service.LoginService;
import maiji.neo4jEnglish.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result login(@RequestBody Neo4jUser neo4jUser) {
        log.info("/login 接口被调用，username = {}，password = {}",neo4jUser.getUsername(), neo4jUser.getPassword());
        Neo4jUser user = loginService.login(neo4jUser);
        if (user != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", user.getId());
            claims.put("username", user.getUsername());
            claims.put("permission",user.getPermission());
            return Result.success(new VToken(JwtUtils.generateJwt(claims),
                    user.getToefl(),
                    user.getIelts(),
                    user.getGre(),
                    user.getPermission()));
        }
        return Result.error("Your username and password don't match");
    }

    @PostMapping("/register")
    public Result register(@RequestBody Neo4jUser neo4jUser) {
        log.info("/register 接口被调用，username = {}，password = {}",neo4jUser.getUsername(), neo4jUser.getPassword());
        Integer i = loginService.findVideoUser(neo4jUser.getUsername());
        if (i == 0) {
            neo4jUser.setPermission((short) 0);
            loginService.register(neo4jUser);
            return Result.success();
        }
        return Result.error("Your username already exists");
    }
}
