package maiji.neo4jEnglish.service.impl;


import maiji.neo4jEnglish.mapper.LoginMapper;
import maiji.neo4jEnglish.pojo.Neo4jUser;
import maiji.neo4jEnglish.service.LoginService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Neo4jUser login(Neo4jUser neo4jUser) {
        neo4jUser.setPassword(DigestUtils.md5Hex(neo4jUser.getPassword()));
        return loginMapper.getByUsernameAndPassword(neo4jUser);
    }

    @Override
    public Integer findVideoUser(String username) {
        return loginMapper.getByUsername(username);
    }

    @Override
    public void register(Neo4jUser neo4jUser) {
        neo4jUser.setPassword(DigestUtils.md5Hex(neo4jUser.getPassword()));
        neo4jUser.setCreateTime(LocalDateTime.now());
        loginMapper.insertVideoUser(neo4jUser);
    }
}
