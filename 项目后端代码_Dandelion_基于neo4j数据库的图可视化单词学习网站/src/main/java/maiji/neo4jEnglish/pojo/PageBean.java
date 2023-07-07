package maiji.neo4jEnglish.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// 分类查询结果的封装类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private Long total; //总记录数
    private List rows;  //数据列表
}
