package com.zou.dao.zou;

import com.zou.bean.zou.User;
import com.zou.bean.query.UserQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Repository // 将dao交给spring管理
@Mapper // 告诉spring这是一个mybatis的mapper类
public interface UserDao {

    boolean saveUser(User user);

    List<User> queryUserList();

    List<User> queryUserByName(UserQuery userQuery);

}
