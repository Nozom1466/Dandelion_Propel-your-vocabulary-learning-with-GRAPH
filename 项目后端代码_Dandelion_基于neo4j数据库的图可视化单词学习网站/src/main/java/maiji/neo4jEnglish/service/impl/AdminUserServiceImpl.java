package maiji.neo4jEnglish.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import maiji.neo4jEnglish.mapper.AdminUserMapper;
import maiji.neo4jEnglish.mapper.LoginMapper;
import maiji.neo4jEnglish.pojo.Neo4jUser;
import maiji.neo4jEnglish.pojo.PageBean;
import maiji.neo4jEnglish.service.AdminUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public PageBean findUserByNameContaining(String name, Integer page, Integer size, LocalDate begin, LocalDate end) {
        // 1.设置分页参数
        PageHelper.startPage(page, size);
        // 2.执行查询
        List<Neo4jUser> Neo4jList = adminUserMapper.findUserByNameContaining(name, begin, end);
        Page<Neo4jUser> pageList = (Page<Neo4jUser>) Neo4jList;
        // 3.封装PageBean对象
        return new PageBean(pageList.getTotal(), pageList.getResult());
    }

    @Override
    public boolean  createNewUser(Neo4jUser neo4jUser) {
        Integer user = loginMapper.getByUsername(neo4jUser.getUsername());
        if (user > 0)
            return false;
        if (neo4jUser.getGre() == null)
            neo4jUser.setGre((short) 0);
        if (neo4jUser.getIelts() == null)
            neo4jUser.setIelts((short) 0);
        if (neo4jUser.getToefl() == null)
            neo4jUser.setToefl((short) 0);
        neo4jUser.setCreateTime(LocalDateTime.now());
        neo4jUser.setPassword(DigestUtils.md5Hex(neo4jUser.getPassword()));
        adminUserMapper.createNewUser(neo4jUser);
        return true;
    }

    @Override
    public void updateUser(Neo4jUser neo4jUser) {
        adminUserMapper.updateUser(neo4jUser);
    }

    @Override
    public void deleteUser(List<Integer> ids) {
        adminUserMapper.deleteUser(ids);
    }

    @Override
    public Neo4jUser findById(Integer id) {
        Neo4jUser user = adminUserMapper.findById(id);
        if (user == null)
            return null;
        user.setPassword(null);
        return user;
    }
}

