package com.zou.server;

import com.github.pagehelper.PageInfo;
import com.zou.bean.zou.User;
import com.zou.bean.query.UserQuery;

import java.util.List;

public interface UserServer {
    boolean saveUser(User user);

    List<User> queryUserList();

    PageInfo<User> queryUserByName(UserQuery userQuery);
}
