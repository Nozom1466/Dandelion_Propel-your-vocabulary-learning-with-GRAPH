package maiji.neo4jEnglish.service;

import maiji.neo4jEnglish.pojo.Neo4jUser;

public interface LoginService {

    Neo4jUser login(Neo4jUser neo4jUser);

    Integer findVideoUser(String username);

    void register(Neo4jUser neo4jUser);
}
