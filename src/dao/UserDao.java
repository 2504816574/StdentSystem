package dao;

import bean.User;

/**
 * @author 25048
 * @Date 2020/12/30
 */
public interface UserDao {
    /**
     * 登录
     * sql:"SELECT id,username,`password` FROM users WHERE username = ? AND `password` = ?"
     */
    User getUser(User user);

    /**
     * 检查用户名是否存在
     * sql: select id from users where username = ?
     *
     * @return boolean  true:用户名存在 false:用户名不存在
     */
    boolean checkUserName(String username);

    /**
     * 将user信息保存到数据库
     *
     * @param user sql:insert into users(username,password,email) values(?,?,?)
     */
    boolean saveUser(User user);
}
