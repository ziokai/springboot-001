package com.zou.server;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zou.bean.zou.User;
import com.zou.bean.query.UserQuery;
import com.zou.dao.zou.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServerImpl implements UserServer {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean saveUser(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public List<User> queryUserList() {
        return userDao.queryUserList();
    }

    @Override
    public PageInfo<User> queryUserByName(UserQuery userQuery) {
        PageHelper.startPage(userQuery.getPageNum(), userQuery.getPageSize());
        return new PageInfo<>(userDao.queryUserByName(userQuery));
    }
}
