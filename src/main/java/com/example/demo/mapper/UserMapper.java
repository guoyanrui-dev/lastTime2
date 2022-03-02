package com.example.demo.mapper;

import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @author guoyanrui on 2021/8/16
 */
@Mapper
@Component
public interface UserMapper {
    @Select(" select * from mydata.user")
    List<User> selectAll();
    @Delete("delete from mydata.user where id=#{id}")
    int delete(int id);
    int add(int id,String name,String password);
    User selectOne(int id);
    int update(int id,String name,String password);
}
