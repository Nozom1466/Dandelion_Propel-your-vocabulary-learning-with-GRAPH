package maiji.neo4jEnglish.service;

import maiji.neo4jEnglish.pojo.Neo4jUser;

import java.time.LocalDate;
import java.util.List;

public interface AdminUserService {
    Object findUserByNameContaining(String name, Integer page, Integer size, LocalDate begin, LocalDate end);
    boolean createNewUser(Neo4jUser neo4jUser);

    void updateUser(Neo4jUser neo4jUser);

    void deleteUser(List<Integer> ids);

    Object findById(Integer id);
}
