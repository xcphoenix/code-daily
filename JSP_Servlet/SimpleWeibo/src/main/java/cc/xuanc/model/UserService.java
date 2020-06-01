package cc.xuanc.model;

import java.io.*;
import java.util.*;
import java.sql.*;
import java.util.Date;
import org.apache.commons.lang.StringUtils;

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
    private Connection conn = null;
    private Statement statement = null;

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

        SQLException ex = null;
        try {
            conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            statement = conn.createStatement();
        } catch (SQLException e) {
            ex = e;
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
        boolean exist = false;

        try {
            ResultSet result =  statement.executeQuery(
                    "SELECT username from `user_data` WHERE username = '" + username + "';");
            if (result.next()) {
                exist = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
     * @throws      RuntimeException SQLException
     */
    public void createUser(String username, String password, String email) {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(
                    "INSERT INTO `user_data` (username, password, email) VALUES(?, ?, ?);"
            );
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * description  验证登录
     * @author      xuanc
     * @date        下午5:53 19-3-4
     * @param		username 用户名
     * @param		password 密码
     * @return      boolean  是否匹配
     * @throws      RuntimeException(SQLException)
     */
    public boolean checkLogin(String username, String password) {
        boolean success = false;

        try {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT username from `user_data` WHERE username = ? AND password = ?;"
            );
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                success = true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return success;
    }

    /**
     * description  新增微博
     * @author      xuanc
     * @date        下午9:51 19-3-4
     * @param		blah 要新增的信息
     * @throws      RuntimeException(SQLException)
     */
    public void addMessage(Blah blah) {
        String username = blah.getUsername();
        String message = blah.getMessage();

        try {
            int userId = getUserId(username);
            if (userId != -1) {
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO message (author_id, message_context, message_time) VALUES (?, ?, UNIX_TIMESTAMP());"
                );
                stmt.setInt(1, userId);
                stmt.setString(2, escapeSpecialChar(message));
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * description  删除信息
     * @author      xuanc
     * @date        下午6:04 19-3-5
     * @param		blah 要删除的消息
     */
    public void deleteMessage(Blah blah) {
        String username = blah.getUsername();
        String message = blah.getMessage();
        Date date = blah.getDate();

        try {
            int userId = getUserId(username);
            if (userId != -1) {
                PreparedStatement stmt = conn.prepareStatement(
                        "DELETE FROM `message` WHERE time = ? AND author_id = ?;"
                );
                // 时间戳转换为UNIX时间戳
                stmt.setLong(1, date.getTime() / 1000);
                stmt.setInt(2, userId);

                stmt.executeUpdate();
            }
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }

    /**
     * description  获取用户发送的微博
     * @author      xuanc
     * @date        下午9:09 19-3-5
     * @param		username 用户名
     * @return      java.util.List<cc.xuanc.model.Blah>
     * @throws      RuntimeException(SQLException)
     */
    public List<Blah> getBlahs(String username) {
        List<Blah> lists = new ArrayList<Blah>();

        try {
            int userId = getUserId(username);
            if (userId != -1) {
                // 获取微博消息-按时间逆序获取
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT message_context, message_time FROM message WHERE author_id = ? ORDER BY `message_time` DESC;"
                );
                stmt.setInt(1, userId);

                ResultSet resultSet = stmt.executeQuery();
                while (resultSet.next()) {
                    // UNIX时间戳转换为时间戳
                    Blah temp = new Blah(username, new Date(1000 * Long.parseLong(resultSet.getString("message_time")) ),
                            resultSet.getString("message_context"));
                    lists.add(temp);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lists;
    }

    /**
     * description
     * @author      xuanc
     * @date        下午5:03 19-3-11
     * @param		username 用户名
     * @return      int 用户id, 查找失败返回-1
     * @throws      RuntimeException(SQLException)
     */
    public int getUserId(String username) {
        int userId = -1;

        SQLException ex = null;

        try {
            ResultSet resultSet = statement.executeQuery("" +
                    "SELECT user_id FROM user_data WHERE username = '" + username + "';");
            if (resultSet.next()) {
                userId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userId;
    }

    /**
     * description  Mysql 语句转义
     * @author      xuanc
     * @date        下午5:54 19-3-5
     * @param		keyword sql 语句
     * @return      java.lang.String 转义后的字符串
     */
    private static String escapeSpecialChar(String keyword){
        return keyword;
    }
}
