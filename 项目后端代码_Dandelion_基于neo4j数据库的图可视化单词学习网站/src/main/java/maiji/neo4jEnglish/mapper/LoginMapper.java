package maiji.neo4jEnglish.mapper;

import maiji.neo4jEnglish.pojo.Neo4jUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    @Select("select * from Neo4jUser where username=#{username} and password =#{password}")
    Neo4jUser getByUsernameAndPassword(Neo4jUser neo4jUser);

    @Select("select COUNT(*) from Neo4jUser where username=#{username}")
    Integer getByUsername(String username);

    @Insert("insert into Neo4jUser(username,password,permission,create_time) values(#{username},#{password},#{permission},#{createTime})")
    void insertVideoUser(Neo4jUser neo4jUser);
}
