package dao.impl;

import bean.User;
import dao.BaseDao;
import dao.UserDao;


/**
 * @author 25048
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {
    @Override
    public User getUser(User user) {
        String sql = "SELECT id,username,`password` FROM users WHERE username = ? AND `password` = ?";
        return this.getBean(sql, user.getUsername(), user.getPassword());
    }

    @Override
    public boolean checkUserName(String username) {
        String sql = "SELECT id FROM users WHERE username = ?";
        User bean = this.getBean(sql, username);
        return bean != null;
    }

    @Override
    public boolean saveUser(User user) {
        String sql = "insert into users (username,password) values(?,?)";
        int update = this.update(sql, user.getUsername(), user.getPassword());
        return update > 0;
    }


}
