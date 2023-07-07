package maiji.neo4jEnglish.mapper;

import maiji.neo4jEnglish.pojo.Neo4jUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface AdminUserMapper {
    List<Neo4jUser> findUserByNameContaining(String name, LocalDate begin, LocalDate end);

    @Insert("insert into Neo4jUser(username,password,permission, toefl,ielts,gre,create_time)" +
            "values(#{username},#{password},#{permission}, #{toefl},#{ielts},#{gre},#{createTime})")
    void createNewUser(Neo4jUser neo4jUser);

    void updateUser(Neo4jUser neo4jUser);

    void deleteUser(List<Integer> ids);

    @Select("select * from Neo4jUser where id = #{id}")
    Neo4jUser findById(Integer id);
}
