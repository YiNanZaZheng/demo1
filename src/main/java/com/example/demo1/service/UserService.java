package com.example.demo1.service;

import com.example.demo1.dao.UserDao;
import com.example.demo1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    /**
     *  根据客户名称查询客户信息
     * @param name
     * @return User
     */
    public User selectUserByName(String name) {
        return userDao.findUserByName(name);
    }

    /**
     *  查找所有用户
     * @return
     */
    public List<User> selectAllUser() {
        return userDao.findAllUser();
    }

    /**
     *
     * @param user
     */
    public void insertUser(User user) {
        userDao.insertUser(user.getName(),user.getAge(),user.getMoney());
    }

    /**
     * 根据id删除用户
    * @param id
     */
    public void deleteUserById(int id) {
        userDao.deleteUser(id);
    }

    /**
     * 模拟事务
     */
    @Transactional
    public void changMoney() {
        userDao.updateUser("张三", 13, 12200.00, 1);
        int tmp=1/0;
        userDao.updateUser("李四", 13, 11080.00, 2);
    }

}
