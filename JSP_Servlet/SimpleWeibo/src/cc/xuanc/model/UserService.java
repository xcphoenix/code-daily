package cc.xuanc.model;

import java.io.*;
import java.util.*;
import java.sql.*;

/**
 * ClassName    SimpleWeibo-UserService
 * Description  用户的登录验证、注册初始化、获取用户微博、新增微博和删除微博
 * @author      xuanc
 * @date        19-3-4 下午4:03
 * @version     1.0
 */ 
public class UserService {

    private String jdbcUser;
    private String jdbcPassword;
    private String jdbcUrl;

    /**
     * description  获取数据库配置信息并连接数据库
     * @author      xuanc
     * @date        下午4:41 19-3-4
     * @throws      RuntimeException　(ClassNotFoundException)
     */
    public UserService(String user, String password, String url) {
        jdbcUser = user;
        jdbcPassword = password;
        jdbcUrl = url;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * description  从数据库中查找用户名是否已注册
     * @author      xuanc
     * @date        下午4:52 19-3-4
     * @param		username 用户名
     * @return      boolean　返回用户名注册情况
     * @throws      RuntimeException SQLException
     */
    public boolean isExisted(String username) {
        Connection conn = null;
        Statement statement = null;
        SQLException ex = null;
        boolean exist = false;

        try {
            conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            // 创建 Statement 对象
            statement = conn.createStatement();
            ResultSet result =  statement.executeQuery(
                    "SELECT * from `_users_` WHERE username = '" + username + "';");
            if (result.next()) {
                exist = true;
            }
        } catch (SQLException e) {
            ex = e;
        } finally {
            dataClose(ex, statement, conn);
        }

        return exist;
    }

    /**
     * description  新建用户
     * @author      xuanc
     * @date        下午5:15 19-3-4
     * @param		username 用户名
     * @param		password 密码
     * @param		email    邮箱
     */
    public void createUser(String username, String password, String email) {
        Connection conn = null;
        Statement statement = null;
        SQLException ex = null;

        try {
            conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            statement = conn.createStatement();
            // 添加用户信息
            statement.executeUpdate(
                    "INSERT INTO `_users_` VALUES('" + username + "','" + password + "', '" + email + "')");
            // 为用户创建表存储微博
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `" + username + "` (" +
                          "`time` DATETIME NOT NULL," +
                          "`message` VARCHAR(256) NOT NULL);"
            );
        } catch (SQLException e) {
            ex = e;
        } finally {
            dataClose(ex, statement, conn);
        }
    }

    /**
     * description  验证登录
     * @author      xuanc
     * @date        下午5:53 19-3-4
     * @param		username 用户名
     * @param		password 密码
     * @return      boolean  是否匹配
     */
    public boolean checkLogin(String username, String password) {
        Connection conn = null;
        Statement statement = null;
        SQLException ex = null;
        boolean success = false;

        try {
            conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            statement = conn.createStatement();
            ResultSet result =  statement.executeQuery(
                    "SELECT * from `_users_` WHERE username = '" + username + "' AND password = '" + password + "';");
            if (result.next()) {
                success = true;
            }
        } catch (SQLException e) {
            ex = e;
        } finally {
            dataClose(ex, statement, conn);
        }

        return success;
    }

    /**
     * 关闭资源
     */
    private void dataClose(SQLException ex, Statement statement, Connection conn) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                if (ex == null) {
                    ex = e;
                }
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                if (ex == null) {
                    ex = e;
                }
            }
        }
    }
}
